package com.hydra.core;


import com.hydra.core.common.utils.StringUtil;

public class HydraBatchSpringBootloader {

    private String configType = CONF_TYPE_ANT;

    private String scanPath;

    private String configPath;

    public static final String CONF_TYPE_ANT = "annotation";
    public static final String CONF_TYPE_XML = "xml";

    /**
     * Spring 启动方法
     */
    public HydraBatchSpringBootloader(){

        if(HydraBatchSpringBootloader.CONF_TYPE_ANT.equals(configType)){
            if(StringUtil.isNotEmpty(scanPath)){
                /**  注解方式启动*/
                ScheduleSystemFactory factory = new AnnotationScheduleSystemFactory(scanPath);
                ScheduleSystem system = factory.getSystem();
                system.start();
            }else {
                throw new RuntimeException("scanPath property is empty for object HydraBatchSpringBootloader !");
            }

        }

        if(HydraBatchSpringBootloader.CONF_TYPE_XML.equals(configType)){

            if(StringUtil.isNotEmpty(configPath)){
                /**  注解方式启动*/
                ScheduleSystemFactory factory = new XmlScheduleSystemFactory(configPath);
                ScheduleSystem system = factory.getSystem();
                system.start();
            }else {
                throw new RuntimeException("configPath property is empty for object HydraBatchSpringBootloader !");
            }
        }

    }

}
