package org.example;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonDemo extends Object {
    public static void main(String[] args) throws CloneNotSupportedException, InstantiationException,
            IllegalAccessException, IllegalArgumentException, InvocationTargetException,
            IOException, ClassNotFoundException {

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

        // Lazy synchronized Block Singleton EXT - break it thru reflection, this will throw an IllegalAccessException as the
        // constructor is now equipped with exception when tried to create the object again
        //        if(instance!=null){
        //            throw new IllegalAccessException("Constructor modified by reflection");
        //        }
        System.out.println("Lazy Synchronized Block Singleton - Break it thru Reflection");
        LazySingletonSyncBlockExt instance11 = LazySingletonSyncBlockExt.getInstance();
        System.out.println("Lazy sync block singleton first instance hashcode (reflection): " + instance11.hashCode());

        //      below piece of code is commented to run further as the constructor is now equipped to handle illegal access.
        // LazySingletonSyncBlockExt instance12 = null;
        //      get all the constructors using getDeclaredConstructors (not getConstructors - it will get only public constructors)
        // Constructor<?>[] constructors = LazySingletonSyncBlockExt.class.getDeclaredConstructors();
        // for(Constructor constructor: constructors){
        //     constructor.setAccessible(true);
        //     instance12 = (LazySingletonSyncBlockExt) constructor.newInstance();
        // }
        //System.out.println("Lazy sync block singleton Second instance hashcode : " + instance12.hashCode());

        // Lazy synchronized Block Singleton EXT - break it thru cloning, now clone method throws CloneNotSupported exception inside
        //Lazy synchtronized Block Ext class.
        System.out.println("Lazy Synchronized Block Singleton - Break it thru Cloning");
        LazySingletonSyncBlockExt instance13 = LazySingletonSyncBlockExt.getInstance();
        System.out.println("Lazy sync block singleton first instance hashcode (clone): " + instance13.hashCode());
        //      below piece of code is commented to run further or it will throw exception as the clone() method
        //      is overridden in the class LazySingletonSyncBlockExt.
        // LazySingletonSyncBlockExt instance14 = (LazySingletonSyncBlockExt) instance13.clone();
        // System.out.println("Lazy sync block singleton Second instance hashcode : " + instance14.hashCode());

        // Lazy synchronized Block Singleton EXT - break it thru Serializable,
        // now handled in the class thru readResolve() method and so, the instance16 will be same as instance15
        // if you comment readResolve method in LazySingletonSyncBlockExt, instance16 will be different from instance15
        System.out.println("Lazy Synchronized Block Singleton - Break it thru Serializable");
        LazySingletonSyncBlockExt instance15 = LazySingletonSyncBlockExt.getInstance();
        System.out.println("Lazy sync block singleton first instance hashcode(Serializable) : " + instance15.hashCode());

        //serialize singleton object to file
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream("SingletonDemo.ser"));
        out.writeObject(instance15);
        out.close();

        //deserialize singleton object from file
        ObjectInput in = new ObjectInputStream(new FileInputStream("SingletonDemo.ser"));
        LazySingletonSyncBlockExt instance16 = (LazySingletonSyncBlockExt) in.readObject();
        System.out.println("Lazy sync block singleton second instance hashcode(Deserializable) : " + instance16.hashCode());
    }
}