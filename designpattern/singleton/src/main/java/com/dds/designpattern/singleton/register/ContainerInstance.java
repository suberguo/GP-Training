package com.dds.designpattern.singleton.register;

import java.util.HashMap;
import java.util.Map;

public class ContainerInstance {

    private static Map<String,Object> instanceMap = new HashMap<>();

    static {
        instanceMap.put("CEO",new CEO());
    }

    public static Object getInstance(String key){
        return instanceMap.get(key);
    }

}
