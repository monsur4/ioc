package com.mon.ioc.scan;

import java.util.Set;

public interface ClassScanner {
    void scan(Class<?> startUpClass);

    Set<ClassDefinition> getClassDefinitions();

    ClassDefinition getClassDefinition(Class<?> clazz);
}
