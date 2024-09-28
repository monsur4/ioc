package com.mon.ioc.service.impl;

import com.mon.ioc.scan.ClassDefinition;
import com.mon.ioc.service.ObjectCreator;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ObjectCreatorImpl implements ObjectCreator {

    Logger logger = Logger.getLogger(ObjectCreatorImpl.class.getName());

    private final Map<String, Object> singletons;

    public ObjectCreatorImpl() {
        singletons = new HashMap<>();
    }

    @Override
    public Object create(ClassDefinition classDefinition) {
        if(classDefinition.type() == ClassDefinition.TYPE.SINGLETON){
            if (singletons.containsKey(classDefinition.fullClassName())){
                logger.log(Level.INFO, String.format("retrieving class %s from store", classDefinition.fullClassName()));
                return singletons.get(classDefinition.fullClassName());
            }
        }

        Object o;
        try {
            Class<?> clazz = Class.forName(classDefinition.fullClassName());
            Constructor<?> constructor = clazz.getConstructors()[0];
            constructor.setAccessible(true);
            o = constructor.newInstance();
            if(classDefinition.type() == ClassDefinition.TYPE.SINGLETON){
                singletons.put(classDefinition.fullClassName(), o);
            }
        } catch (ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return o;
    }
}
