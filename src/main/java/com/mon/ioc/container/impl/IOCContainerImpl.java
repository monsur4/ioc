package com.mon.ioc.container.impl;

import com.mon.ioc.container.IOCContainer;
import com.mon.ioc.scan.ClassDefinition;
import com.mon.ioc.scan.ClassScanner;
import com.mon.ioc.service.ObjectCreator;

/**
 * This is the implementation of the container that stores instances of objects
 * and also injects them into other classes
 */
public class IOCContainerImpl implements IOCContainer {

    private ClassScanner classScanner;

    private ObjectCreator objectCreator;

    private Class<?> startUpClass;

    public IOCContainerImpl() {
    }

    public IOCContainerImpl(
            ClassScanner classScanner,
            ObjectCreator objectCreator,
            Class<?> startUpClass
    ) {
        this.classScanner = classScanner;
        this.objectCreator = objectCreator;
        this.startUpClass = startUpClass;
        createObjects();
    }

    public void createObjects(){
        classScanner.scan(startUpClass);
        for(ClassDefinition classDefinition: classScanner.getClassDefinitions()){
            objectCreator.create(classDefinition);
        }
    }

    public Object getObject(Class<?> clazz){
        ClassDefinition classDefinition = classScanner.getClassDefinition(clazz);
        return objectCreator.create(classDefinition);
    }
}
