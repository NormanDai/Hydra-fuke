package com.hydra.core;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class AnnotationTaskConfig {

    private static AnnotationTaskConfig instance;

    private List<Class<?>> classList;

    private List<Object> objects;

    private AnnotationTaskConfig(){}

    public static AnnotationTaskConfig getInstance(){
        if (instance == null) {
            synchronized (AnnotationTaskConfig.class) {
                if (instance == null) {
                    instance = new AnnotationTaskConfig();
                }
            }
        }
        return instance;
    }


}
