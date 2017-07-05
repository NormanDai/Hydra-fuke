package com.hydra.core.test;


import com.hydra.core.AnnotationBatchSystem;
import com.hydra.core.BatchSystem;

public class Main {

    public static void main(String[] strings){
        BatchSystem system = AnnotationBatchSystem.getInstance().setScanPackage("com.xxxx.xxxx.test");
        system.start();
    }

}
