package org.example;

public class LazySingletonSync {

    public static LazySingletonSync instance = null;

    private LazySingletonSync() {
    }

    public  static synchronized LazySingletonSync  getInstance(){
        if(instance==null){
            instance = new LazySingletonSync();
        }
        return instance;
    }
}
