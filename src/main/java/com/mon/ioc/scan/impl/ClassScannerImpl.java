package com.mon.ioc.scan.impl;

import com.mon.ioc.scan.ClassDefinition;
import com.mon.ioc.scan.ClassScanner;

import java.util.HashSet;
import java.util.Set;

/**
 * this class scans and collects all classes in the project (based on some criteria)
 */
public class ClassScannerImpl implements ClassScanner {

    final Set<ClassDefinition> allClasses;

    public Set<ClassDefinition> getAllClasses() {
        return allClasses;
    }

    public ClassScannerImpl() {
        allClasses = new HashSet<>();
    }

    @Override
    public void scan() {

    }
}
