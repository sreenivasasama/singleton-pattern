package org.example;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        // Eager Singleton - created at class load
        System.out.println("Eager Singleton");
        EagerSingleton instance1 = EagerSingleton.getInstance();
        System.out.println("Eager singleton first instance hashcode : " + instance1.hashCode());
        EagerSingleton instance2 = EagerSingleton.getInstance();
        System.out.println("Eager singleton Second instance hashcode : " + instance2.hashCode());

        // Lazy Singleton - created when accessed
        System.out.println("Lazy Singleton");
        LazySingleton instance3 = LazySingleton.getInstance();
        System.out.println("Lazy singleton first instance hashcode : " + instance3.hashCode());
        LazySingleton instance4 = LazySingleton.getInstance();
        System.out.println("Lazy singleton Second instance hashcode : " + instance4.hashCode());

        // Lazy synchronized Singleton - created when accessed
        System.out.println("Lazy Synchronized Singleton");
        LazySingletonSync instance5 = LazySingletonSync.getInstance();
        System.out.println("Lazy sync singleton first instance hashcode : " + instance5.hashCode());
        LazySingletonSync instance6 = LazySingletonSync.getInstance();
        System.out.println("Lazy sync singleton Second instance hashcode : " + instance6.hashCode());

        // Lazy synchronized Block Singleton - created when accessed
        System.out.println("Lazy Synchronized Block Singleton");
        LazySingletonSyncBlock instance7 = LazySingletonSyncBlock.getInstance();
        System.out.println("Lazy sync block singleton first instance hashcode : " + instance7.hashCode());
        LazySingletonSyncBlock instance8 = LazySingletonSyncBlock.getInstance();
        System.out.println("Lazy sync block singleton Second instance hashcode : " + instance8.hashCode());

        // Singleton thru Inner class - created when accessed
        System.out.println("Singleton thru Inner class");
        SingletonInnerClass instance9 = SingletonInnerClass.getInstance();
        System.out.println("Singleton Inner class first instance hashcode : " + instance9.hashCode());
        SingletonInnerClass instance10 = SingletonInnerClass.getInstance();
        System.out.println("Singleton Inner class Second instance hashcode : " + instance10.hashCode());
    }
}