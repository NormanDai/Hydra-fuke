package com.hydra.core;


import com.hydra.core.annotation.Task;
import com.hydra.core.common.utils.StringUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HydraBatchSpringBootloader implements ApplicationContextAware,InitializingBean{

    private String configType = CONF_TYPE_ANT;

    private String configPath;

    private List<Object> objects;

    public static final String CONF_TYPE_ANT = "annotation";
    public static final String CONF_TYPE_XML = "xml";

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, Object> beansWithAnnotation = applicationContext.getBeansWithAnnotation(Task.class);
        this.objects = new ArrayList<Object>();
        for(Map.Entry<String,Object> entry : beansWithAnnotation.entrySet()){
            objects.add(entry.getValue());
        }
        AnnotationTaskConfig.getInstance().setObjects(objects);
    }

    public void afterPropertiesSet() throws Exception {

        if(HydraBatchSpringBootloader.CONF_TYPE_ANT.equals(configType)) {
            /**  注解方式启动*/
            ScheduleSystemFactory factory = new AnnotationScheduleSystemFactory("");
            ScheduleSystem system = factory.getSystem();
            system.start();
        }

        if(HydraBatchSpringBootloader.CONF_TYPE_XML.equals(configType)){

            if(StringUtil.isNotEmpty(configPath)){
                /**  xml方式启动*/
                ScheduleSystemFactory factory = new XmlScheduleSystemFactory(configPath);
                ScheduleSystem system = factory.getSystem();
                system.start();
            }else {
                throw new RuntimeException("configPath property is empty for object HydraBatchSpringBootloader !");
            }
        }
    }
}
