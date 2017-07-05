package com.hydra.core;

public class APP {


    public static void main(String[] args) {

        /**  注解方式启动*/
        ScheduleSystemFactory factory = new AnnotationScheduleSystemFactory("com.hydra.core.test");
        ScheduleSystem system = factory.getSystem();
        system.start();

        /**  xml方式启动*/
//        ScheduleSystemFactory factory2 = new XmlScheduleSystemFactory("/schedule-config.xml");
//        ScheduleSystem system2 = factory2.getSystem();
//        system2.start();
    }
}
