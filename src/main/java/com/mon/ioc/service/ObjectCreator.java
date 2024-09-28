package com.mon.ioc.service;

import com.mon.ioc.scan.ClassDefinition;

public interface ObjectCreator {

    Object create(ClassDefinition classDefinition);
}
