package com.hydra.core;

import com.hydra.core.common.utils.P;
import com.hydra.core.common.utils.PackageScanner;
import com.hydra.core.common.utils.ReflactUtil;
import com.hydra.core.common.utils.StringUtil;

import java.util.List;


public class AnnotationSystemBootstrap extends AbstractSystemBootstrap{

    private String scanPath;

    private static AnnotationSystemBootstrap instance;

    private AnnotationSystemBootstrap(){}

    public static AnnotationSystemBootstrap getInstance(){
        if (instance == null) {
            synchronized (AnnotationSystemBootstrap.class) {
                if (instance == null) {
                    instance = new AnnotationSystemBootstrap();
                }
            }
        }
        return instance;
    }


    @Override
    void initialize() {
        P.println("AnnotationSystemBootstrap  initialize");

        if(StringUtil.isNotEmpty(scanPath)){// from spring
            AnnotationTaskConfig config = AnnotationTaskConfig.getInstance();
            List<Class<?>> classes = PackageScanner.getClasses(scanPath);
            for(Class clazz : classes){
                if(clazz.isInterface()){
                    classes.remove(clazz);
                }
            }
            config.setClassList(PackageScanner.getClasses(scanPath));
        }
        BatchSytemComponentWrapper componentWrapper = BatchSytemComponentWrapper.getInstance();
        componentWrapper.setConfigHelper(new AnnotationTaskConfigHelper());
        componentWrapper.cooking();
        //TODO
    }

    @Override
    void bootStart() {
        P.println("AnnotationSystemBootstrap  bootStart");
    }

    @Override
    void destroy() {
        P.println("AnnotationSystemBootstrap  destroy");
    }

    public AnnotationSystemBootstrap setProperty(String scanPath){
        this.scanPath = scanPath;
        return this;
    }
}
