package com.dds.mvc.v1;

import com.dds.annotation.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;

public class DispatchServlet extends HttpServlet {

    private String scanPackage = null;
    private List<String> classList = new ArrayList<>();
    private Map<String, Object> instanceMap = new HashMap<>();
    private Map<String, Method> handlerMap = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doDispatch(req, resp);
    }


    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws IOException {
       String uri = req.getRequestURI();
       uri = uri.replace(req.getContextPath(),"");
       if(!this.handlerMap.containsKey(uri)){
           resp.getWriter().write("404 Not Found " + uri);
           return;
       }
       Method method = this.handlerMap.get(uri);
        List<Object> params = new ArrayList<>();
       try {
           List<String> parameterNames = Collections.list(req.getParameterNames());
           Annotation[][] annotations  = method.getParameterAnnotations();
           if(annotations != null && annotations.length>0) {
               params.add(req);
               params.add(resp);
               for (int i = 0; i < annotations.length; i++) {
                   if(annotations[i].length == 0){continue;}
                   RequestParam requestParam = annotations[i][0].annotationType().getAnnotation(RequestParam.class);
                   String name = requestParam.value();
                   if (parameterNames.contains(name)) {
                       params.add(req.getParameterValues(name)[0]);
                   }
               }
           }
           System.out.println(method.getDeclaringClass().getTypeName());
           method.invoke(this.instanceMap.get(method.getDeclaringClass().getTypeName()), params.toArray());
       }catch (IllegalAccessException  | InvocationTargetException e){
           e.printStackTrace();
       }
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        //1.加载配置
        doLoadConfig(config);

        //2.扫描包
        doScan(this.scanPackage);

        //3.初始化IOC容器
        doInit();

        //4.注入
        doInject();

        //5.绑定handler
        doHandlerMapping();

        System.out.println("initiated");

        super.init(config);

    }

    private void doLoadConfig(ServletConfig config) {
        String configPath = config.getInitParameter("contextConfigLocation");
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(configPath);
        Properties properties = new Properties();
        try {
            properties.load(is);
            this.scanPackage = properties.getProperty("scanpackage");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void doScan(String packagePath) {
        URL url = this.getClass().getClassLoader().getResource("/" + packagePath.replaceAll("\\.", "/"));
        System.out.println(url);
        File file = new File(url.getFile());
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                this.doScan(packagePath + "." + f.getName());
            } else if (f.isFile()) {
                if (f.getName().endsWith(".class")) {
                    try {
                        this.classList.add(packagePath + "." + f.getName().replace(".class",""));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    continue;
                }
            } else {
                continue;
            }
        }


    }

    private void doInit() {
        if (!this.classList.isEmpty()) {
            try {
                for (String className : classList) {

                    Class<?> clazz = Class.forName(className);
                    if (clazz.isAnnotationPresent(Controller.class)) {
                        this.instanceMap.put(clazz.getTypeName(), clazz.newInstance());
                        Class<?>[] clazzInterfaces = clazz.getInterfaces();
                        for (Class<?> classInt : clazzInterfaces) {
                            this.instanceMap.put(classInt.getTypeName(), this.instanceMap.get(clazz.getTypeName()));
                        }

                    } else if (clazz.isAnnotationPresent(Service.class)) {
                        this.instanceMap.put(clazz.getTypeName(), clazz.newInstance());
                        Class<?>[] clazzInterfaces = clazz.getInterfaces();
                        for (Class<?> classInt : clazzInterfaces) {
                            this.instanceMap.put(classInt.getTypeName(), this.instanceMap.get(clazz.getTypeName()));
                        }
                    } else {
                        continue;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void doInject() {
        if (!this.instanceMap.isEmpty()) {
            try {
                for (Map.Entry<String, Object> clazz : this.instanceMap.entrySet()) {
                    Field[] fields = clazz.getValue().getClass().getDeclaredFields();
                    for (Field field : fields) {
                        if (field.isAnnotationPresent(Autowired.class)) {
                            Autowired autowired = field.getAnnotation(Autowired.class);
                            String beanName = "".equals(autowired.value()) ? field.getType().getName() : autowired.value();
                            field.setAccessible(true);
                            field.set(clazz.getValue(), this.instanceMap.get(beanName));
                            field.setAccessible(false);
                        } else {
                            continue;
                        }
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private void doHandlerMapping() {
        if(this.instanceMap.isEmpty()) return;

        for (Map.Entry<String,Object> entry : instanceMap.entrySet()) {
            if(!entry.getValue().getClass().isAnnotationPresent(RequestMapping.class)) continue;

            RequestMapping requestMapping = entry.getValue().getClass().getAnnotation(RequestMapping.class);
            String[] path = requestMapping.value();
            Method[] methods = entry.getValue().getClass().getMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(RequestMapping.class)) {
                    RequestMapping reqMapping = method.getAnnotation(RequestMapping.class);
                    String[] subPath = reqMapping.value();
                    this.handlerMap.put("/"+path[0] + subPath[0], method);
                }
            }

        }
    }


}
