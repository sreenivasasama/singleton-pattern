package org.example;

public class LazySingletonSyncBlock {

    public static volatile LazySingletonSyncBlock instance = null;

    private LazySingletonSyncBlock() {
    }

    public  static LazySingletonSyncBlock getInstance(){
        //Double check , so no two threads when accessed at same time, will not create the different instance
        if(instance == null){
            synchronized (LazySingleton.class){
                if(instance == null) {
                    instance = new LazySingletonSyncBlock();
                }
            }
        }
        return instance;
    }
}
