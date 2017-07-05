package com.hydra.core;


import java.io.File;
import java.io.InputStream;

public class XmlScheduleSystemFactory implements  ScheduleSystemFactory{

    private String configPath;

    private File configFile;

    private InputStream inputStream;

    XmlScheduleSystemFactory(String configPath){
        this.configPath = configPath;
    }
    XmlScheduleSystemFactory(File config){
        this.configFile = config;
    }

    XmlScheduleSystemFactory(InputStream inputStream){
        this.inputStream = inputStream;
    }

    public ScheduleSystem getSystem() {
        return null;
    }

}
