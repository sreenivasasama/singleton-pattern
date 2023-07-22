package org.example;

import java.io.Serial;
import java.io.Serializable;

public class LazySingletonSyncBlockExt extends MyClone implements Serializable {

    public static volatile LazySingletonSyncBlockExt instance = null;

    private LazySingletonSyncBlockExt() throws IllegalAccessException {
        //use the below piece of code to handle any creation outside of this class by modifying the class access thru reflection
        if(instance!=null){
            throw new IllegalAccessException("Constructor modified by reflection");
        }
    }

    //use this method override to NOT support cloning by throwing the exception
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("this class does not support cloning as it is Singleton");
    }

    //use this method to return same instance during serialize/deserialize
    @Serial
    protected Object readResolve(){
        return instance;
    }

    public  static LazySingletonSyncBlockExt getInstance() throws IllegalAccessException {
        //Double check , so no two threads when accessed at same time, will not create the different instance
        if(instance == null){
            synchronized (LazySingleton.class){
                if(instance == null) {
                    instance = new LazySingletonSyncBlockExt();
                }
            }
        }
        return instance;
    }
}
