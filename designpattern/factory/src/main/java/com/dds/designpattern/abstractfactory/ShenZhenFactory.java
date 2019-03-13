package com.dds.designpattern.abstractfactory;

import com.dds.designpattern.*;

/**
 * 书刊类工厂
 */
public class ShenZhenFactory implements Factory {

    @Override
    public IBook createBook() {
        Book book = new Book();
        book.setAuthor("xmg");
        book.setTitle("Spring Boot编程思想");
        book.setIsbn("1001");
        return book;
    }

    @Override
    public IMagazine createMagazine() {
        Magazine magazine = new Magazine();
        magazine.setTitle("知音");
        magazine.setIsbn("1234");
        return magazine;
    }
}
