package com.mon.ioc.service.impl;

import com.mon.ioc.scan.ClassDefinition;
import org.junit.jupiter.api.Test;

import static com.mon.ioc.scan.ClassDefinition.TYPE.*;

class ObjectCreatorImplTest {

    ObjectCreatorImpl objectCreator = new ObjectCreatorImpl();

    @Test
    void whenCreate_ObjectConstructorIsCalled(){

        String fullClassName = "com.mon.ioc.test.TestClassOne";

        // given
        ClassDefinition classDefinition = new ClassDefinition()
                .setFullClassName(fullClassName)
                .setType(SINGLETON);

        // when

        objectCreator.create(classDefinition);

    }

    @Test
    void whenCreateIsCalledOnSingletonType_ObjectConstructorIsCalledOnlyOnce(){
        String fullClassName = "com.mon.ioc.test.TestClassOne";

        // given
        ClassDefinition classDefinition = new ClassDefinition()
                .setFullClassName(fullClassName)
                .setType(SINGLETON);

        // when
        objectCreator.create(classDefinition);
        objectCreator.create(classDefinition);

    }

    @Test
    void whenCreateIsCalledOnAlreadyCreatedSingletonType_ObjectConstructorIsRetrievedFromStore(){
        String fullClassName = "com.mon.ioc.test.TestClassOne";

        // given
        ClassDefinition classDefinition = new ClassDefinition()
                .setFullClassName(fullClassName)
                .setType(SINGLETON);

        // when
        objectCreator.create(classDefinition);
        objectCreator.create(classDefinition);
    }

}