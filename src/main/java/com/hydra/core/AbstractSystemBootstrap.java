package com.hydra.core;


public abstract class AbstractSystemBootstrap {

    /**
     * 启动引导程序
     */
    void bootload(){
        initialize();
        bootStart();
    }

    /**
     * 系统初始化
     */
    abstract void initialize();

    /**
     * 启动
     */
    abstract void bootStart();

    /**
     * 销毁
     */
    abstract void destroy();

}
