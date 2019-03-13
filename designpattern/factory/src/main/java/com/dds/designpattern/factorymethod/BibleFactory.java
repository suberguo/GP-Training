package com.dds.designpattern.factorymethod;

import com.dds.designpattern.Bible;
import com.dds.designpattern.Book;
import com.dds.designpattern.IBook;

/**
 * 书籍类工厂
 */
public class BibleFactory implements PublishingFactory {
    @Override
    public IBook create() {
        Bible book = new Bible();
        book.setTitle("圣经");
        book.setIsbn("1001");
        return book;
    }
}
