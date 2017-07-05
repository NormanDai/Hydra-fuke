package com.hydra.core;


public class AnnotationScheduleSystem implements ScheduleSystem{

    private static AnnotationScheduleSystem instance;

    private AnnotationScheduleSystem(){}

    private AnnotationSystemBootstrap bootstrap = AnnotationSystemBootstrap.getInstance();

    private String scanPath;

    /**
     * 获取 AnnotationScheduleSystem 示例
     * @return
     */
    public static AnnotationScheduleSystem getInstance(){
        if (instance == null) {
            synchronized (AnnotationScheduleSystem.class) {
                if (instance == null) {
                    instance = new AnnotationScheduleSystem();
                }
            }
        }
        return instance;
    }

    /**
     * 启动系统
     */
    public void start() {
        /**  启动系统加载类*/
        bootstrap.setProperty(scanPath);
        bootstrap.bootload();
    }

    /**
     * 关闭系统
     */
    public void shutdown() {
        /**  销毁系统资源*/
        bootstrap.destroy();
        /**  关闭hook*/
        //TODO
    }

    public AnnotationScheduleSystem setProperty(String scanPath){
        this.scanPath = scanPath;
        return this;
    }

}
