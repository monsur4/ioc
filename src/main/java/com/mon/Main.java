package com.mon;

import com.mon.ioc.scan.ClassDefinition;
import com.mon.ioc.scan.impl.ClassScannerImpl;

import java.util.Set;

/**
 * create an ioc container that:
 * create objects (singleton and prototype scoped)
 * inject objects (singleton and prototype scoped)
 */
public class Main {
    public static void main(String[] args) {
        // create container

        // do a component scan
        ClassScannerImpl classScanner = new ClassScannerImpl();
        classScanner.scan(Main.class);
        Set<ClassDefinition> classDefinitions = classScanner.getClassDefinitions();
        for (ClassDefinition classDefinition : classDefinitions) {
            System.out.println("classDefinition = " + classDefinition);
        }
        // create the objects (single and prototype) => Object creation service

        // inject them

        // see if they are properly injected

        // write tests
        System.out.println("Hello world!");
    }
}