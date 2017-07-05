package com.hydra.core.container;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class EnvironmentHookContext extends AbstractContext{

    private static EnvironmentHookContext instance = new EnvironmentHookContext();

    private static Map<String,Object> beanMap = new ConcurrentHashMap<String, Object>();

    private EnvironmentHookContext(){
    }

    public static EnvironmentHookContext getInstance(){
        if (instance == null) {
            synchronized (EnvironmentHookContext.class) {
                if (instance == null) {
                    instance = new EnvironmentHookContext();
                }
            }
        }
        return instance;
    }

    @Override
    Map<String, Object> getObjectMap() {
        return beanMap;
    }
}
