package com.dds.designpattern.proxy.dynamicproxy.custome;


public class DdsClassLoader extends ClassLoader {


    public Class findClass(String name) {
        String clzName = DdsClassLoader.class.getPackage().getName() + "." + name.replaceAll("\\.", "/");
        String file = DdsClassLoader.class.getResource("").getPath() + name + ".class";
        byte[] bytes = FileUtil.read(file);
        return defineClass(clzName, bytes, 0, bytes.length);
    }
}
