package com.hydra.core;


import com.hydra.core.schedule.AnnotationTaskDescription;
import com.hydra.core.schedule.TaskDescription;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class AnnotationTaskConfigHelper implements TaskConfigHelper{

    private AnnotationTaskConfig  taskConfig = AnnotationTaskConfig.getInstance();

    public List<TaskDescription> getAllDesc() {

        List<TaskDescription> descriptions = new ArrayList<TaskDescription>();
        List<Object> objects = null;
        // from local system
        if(null != taskConfig.getClassList() && !taskConfig.getClassList().isEmpty()){
            objects = new ArrayList<Object>();
            for(Class clazz : taskConfig.getClassList()){
                try {
                    objects.add(clazz.newInstance());
                }catch (Exception e){
                    throw new RuntimeException(e);
                }
            }
        }

        //from spring context
        if(null != taskConfig.getObjects() && !taskConfig.getObjects().isEmpty()){
            objects = taskConfig.getObjects();
        }

        for(Object bean : objects){
            AnnotationTaskDescription taskDescription = new AnnotationTaskDescription();
            taskDescription.setClazz(bean.getClass());
            taskDescription.setObject(bean);
            descriptions.add(taskDescription);
        }
        return descriptions;
    }
}
