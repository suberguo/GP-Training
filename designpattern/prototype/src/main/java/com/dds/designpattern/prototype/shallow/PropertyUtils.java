package com.dds.designpattern.prototype.shallow;

import com.dds.designpattern.prototype.Person;

public class PropertyUtils {

    public static void copy(Person source, Person dest){

        dest.setAge(source.getAge());
        dest.setName(source.getName());
        dest.setPosition(source.getPosition());
        dest.setSex(source.getSex());
        dest.setAddress(source.getAddress());
    }

}
