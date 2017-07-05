package com.hydra.core;


import com.hydra.core.container.EnvironmentContext;
import com.hydra.core.flow.TaskFlowParser;
import com.hydra.core.schedule.NormalTaskDescParser;
import com.hydra.core.schedule.TaskDescription;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class BatchSytemComponentWrapper {// 系统执行组件包装类

    private static final EnvironmentContext environmentContext = EnvironmentContext.getInstance();

    private  AnnotationTaskConfigHelper configHelper;

    private static BatchSytemComponentWrapper instance;

    private BatchSytemComponentWrapper(){}

    private String taskLoadType = TASK_LOAD_ANT;

    public static final String TASK_LOAD_ANT = "annotation";
    public static final String TASK_LOAD_XML = "xml";

    public static BatchSytemComponentWrapper getInstance(){
        if (instance == null) {
            synchronized (BatchSytemComponentWrapper.class) {
                if (instance == null) {
                    instance = new BatchSytemComponentWrapper();
                }
            }
        }
        return instance;
    }

    /**
     * 初始化作业配置（炒菜）
     */
    public void cooking(){

        List<TaskDescription> descriptions = configHelper.getAllDesc();
        for (TaskDescription description : descriptions){
            NormalTaskDescParser parser = new NormalTaskDescParser();
            parser.parser(description);
        }
        new TaskFlowParser().parser();
    }

}
