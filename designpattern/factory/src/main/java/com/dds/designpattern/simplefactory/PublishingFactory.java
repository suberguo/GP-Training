package com.dds.designpattern.simplefactory;

import com.dds.designpattern.IBook;

/**
 * 出版类刊物工厂
 */
public class PublishingFactory {

    /**
     * 生产相关刊物
     * @param book
     * @return
     */
    public IBook create(Class<? extends IBook> book) {
        try {
            IBook bookInstance = book.newInstance();
            return bookInstance;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
