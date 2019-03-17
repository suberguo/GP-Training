package com.dds.designpattern.proxy.dynamicproxy.custome;

import sun.reflect.CallerSensitive;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DdsProxy {

    private final static String LN = "\r\n";

    @CallerSensitive
    public static Object newProxyInstance(DdsClassLoader loader,
                                          Class<?>[] interfaces,
                                          DdsInvocationHandler h)
            throws IllegalArgumentException {
        //1.创建类java代码
        String javaCodeStr = generateProxyJavaFile(interfaces);

        //2.输出文件到磁盘
        String path = loader.getClass().getResource("").getPath();
        try {
            FileWriter writer = new FileWriter(path + "$Proxy20.java");
            writer.write(javaCodeStr);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //2.编译为class文件
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
        Iterable obj = manager.getJavaFileObjects(path + "$Proxy20.java");
        JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, obj);
        task.call();
        try {
            manager.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //3.装载至JVM
        DdsClassLoader clzLoader = new DdsClassLoader();
        Class<?> clz = clzLoader.findClass("$Proxy20");

        //clzLoader.loadClass()
        //4.反设创建对象
        try {
            Constructor<?> constructor = clz.getConstructor(DdsInvocationHandler.class);
            File file = new File(path + "$Proxy20.java");
            file.delete();
            try {
                return constructor.newInstance(h);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } finally {

        }

        return null;
    }

    private static String generateProxyJavaFile(Class<?>[] interfaces) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("package com.dds.designpattern.proxy.dynamicproxy.custome;" + LN);

        stringBuilder.append("import java.lang.reflect.InvocationHandler;" + LN);
        stringBuilder.append("import java.lang.reflect.Method;" + LN);
        stringBuilder.append("import java.lang.reflect.Proxy;" + LN);
        stringBuilder.append("import java.lang.reflect.UndeclaredThrowableException;" + LN);
        stringBuilder.append("public class $Proxy20 implements " + interfaces[0].getName() + " {" + LN);
        stringBuilder.append("DdsInvocationHandler h;" + LN);

        stringBuilder.append("public $Proxy20(DdsInvocationHandler h){" + LN);
        stringBuilder.append("this.h = h;" + LN);
        stringBuilder.append("}" + LN);

        Method[] methods = interfaces[0].getMethods();
        for (Method m : methods) {
            Class<?>[] parameterTypes = m.getParameterTypes();
            stringBuilder.append("public " + m.getReturnType().getName() + " " + m.getName()
                    + "(" + ((parameterTypes.length > 0) ? parameterTypes[0].getName() + " " + m.getParameters()[0].getName() : "") + "){" + LN);

            if(m.getReturnType() != void.class){
                stringBuilder.append("Object result = null;" + LN);
            }
            stringBuilder.append("try{" + LN);
            stringBuilder.append("Method m = " + interfaces[0].getName() + ".class.getMethod(\"" + m.getName() + "\",new Class[]{});"+ LN);
            if(m.getReturnType() != void.class){
                stringBuilder.append("result = this.h.invoke(this,m,null);"+ LN);
            }else {
                stringBuilder.append("this.h.invoke(this,m,null);"+ LN);
            }
            stringBuilder.append("}catch(Throwable e){" + LN);
            stringBuilder.append("e.printStackTrace();" + LN);
            stringBuilder.append("}" + LN);
            if(m.getReturnType() != void.class){
                stringBuilder.append("return result;" + LN);
            }
            stringBuilder.append("}" + LN);
        }

        stringBuilder.append("}");

        System.out.println(stringBuilder.toString());

        return stringBuilder.toString();

    }
}
