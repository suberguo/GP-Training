package com.dds.designpattern.abstractfactory;

import com.dds.designpattern.Book;
import com.dds.designpattern.IBook;
import com.dds.designpattern.IMagazine;
import com.dds.designpattern.Magazine;

public class HuMenFactory implements Factory {

    @Override
    public IBook createBook() {
        Book book = new Book();
        book.setAuthor("suber");
        book.setTitle("设计模式");
        book.setIsbn("1002");
        return book;
    }

    @Override
    public IMagazine createMagazine() {
        Magazine magazine = new Magazine();
        magazine.setTitle("读者");
        magazine.setIsbn("1234");
        return magazine;
    }
}
