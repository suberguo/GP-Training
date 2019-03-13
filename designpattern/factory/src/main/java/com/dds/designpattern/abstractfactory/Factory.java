package com.dds.designpattern.abstractfactory;

import com.dds.designpattern.IBook;
import com.dds.designpattern.IMagazine;

public interface Factory {

    IBook createBook();

    IMagazine createMagazine();
}
