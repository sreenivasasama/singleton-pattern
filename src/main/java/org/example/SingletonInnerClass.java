package org.example;

public class SingletonInnerClass {
    private SingletonInnerClass(){

    }

    private static class SingletonHelper {
        private static final SingletonInnerClass instance = new SingletonInnerClass();
    }

    public static SingletonInnerClass getInstance() {
        return SingletonHelper.instance;
    }
}
