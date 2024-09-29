package com.mon;

import com.mon.ioc.container.IOCContainer;
import com.mon.ioc.container.impl.IOCContainerImpl;
import com.mon.ioc.scan.ClassScanner;
import com.mon.ioc.scan.impl.ClassScannerImpl;
import com.mon.ioc.service.ObjectCreator;
import com.mon.ioc.service.impl.ObjectCreatorImpl;
import com.mon.ioc.test.TestClassOne;

/**
 * create an ioc container that:
 * create objects (singleton and prototype scoped)
 * inject objects (singleton and prototype scoped)
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        // do a component scan
        ClassScannerImpl classScanner = new ClassScannerImpl();

        // create the objects (single and prototype) => Object creation service
        ObjectCreator objectCreator = new ObjectCreatorImpl();

        // create container
        IOCContainer container = new IOCContainerImpl(classScanner, objectCreator, Main.class);

        // TODO: inject them

        // TODO: see if they are properly injected

        // retrieve objects of a class type
        TestClassOne object1 = (TestClassOne) container.getObject(TestClassOne.class);
        TestClassOne object2 = (TestClassOne) container.getObject(TestClassOne.class);
        if(object1.equals(object2)) System.out.println("Singleton");

        // retrieving by type
        ClassScanner object3 = (ClassScanner) container.getObject(ClassScanner.class);
        System.out.println("object3 = " + object3);

        // TODO: write tests
    }
}