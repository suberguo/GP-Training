package com.dds.designpattern.factorymethod;

import com.dds.designpattern.Fairytale;
import com.dds.designpattern.IBook;

/**
 * 杂志类工厂
 */
public class FairytaleFactory implements PublishingFactory {
    @Override
    public IBook create() {
        Fairytale fairytale = new Fairytale();
        fairytale.setTitle("安徒生的童话故事");
        fairytale.setIsbn("2001");
        return fairytale;
    }
}
