package com.mon.ioc.scan;

public class ClassDefinition {
    private String fullClassName;
    private TYPE type = TYPE.SINGLETON;

    public String fullClassName() {
        return fullClassName;
    }

    public ClassDefinition setFullClassName(String fullClassName) {
        this.fullClassName = fullClassName;
        return this;
    }

    public TYPE type() {
        return type;
    }

    public ClassDefinition setType(TYPE type) {
        this.type = type;
        return this;
    }

    public ClassDefinition(String fullClassName, TYPE type) {
        this.fullClassName = fullClassName;
        this.type = type;
    }

    public ClassDefinition() {
    }

    public enum TYPE {
        SINGLETON, PROTOTYPE;
    }
}
