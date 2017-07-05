package com.hydra.core;


public class AnnotationScheduleSystemFactory implements  ScheduleSystemFactory{

    private String scanPath;


    AnnotationScheduleSystemFactory(String scanPath){
        this.scanPath = scanPath;
    }

    /**
     * 获取系统启动实例
     * @return
     */
    public ScheduleSystem getSystem() {
        return AnnotationScheduleSystem.getInstance().setProperty(scanPath);
    }

}
