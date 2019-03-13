package com.dds.designpattern.factorymethod;

import com.dds.designpattern.IBook;

/**
 * 出版类工厂
 */
public interface PublishingFactory {
    IBook create();
}
