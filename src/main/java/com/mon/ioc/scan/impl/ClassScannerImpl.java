package com.mon.ioc.scan.impl;

import com.mon.ioc.scan.ClassDefinition;
import com.mon.ioc.scan.ClassScanner;

import java.util.HashSet;
import java.util.Set;

public class ClassScannerImpl implements ClassScanner {

    final Set<ClassDefinition> allClasses;

    public ClassScannerImpl() {
        allClasses = new HashSet<>();
    }

    @Override
    public void scan() {

    }
}
