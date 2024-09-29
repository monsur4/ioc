package com.mon.ioc.container;

public interface IOCContainer {
    Object getObject(Class<?> clazz);
    void createObjects();
}
