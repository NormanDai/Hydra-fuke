package com.hydra.core.common;

import lombok.Getter;

@Getter
public enum ContextKeyEnum {

    CONTXT_PACKAGE("allClass","CONTXT_PACKAGE"),
    CONTXT_WRAPERS("wrappers","CONTXT_WRAPERS"),
    CONTXT_SCHEDUS("schedules","CONTXT_SCHEDUS"),
    CONTXT_JBNMS("jobNames","CONTXT_JBNMS"),
    CONTXT_IVK_CLS("invokeClass","CONTXT_IVK_CLS"),
    CONTXT_IVK_MTHD("invokeMethods","CONTXT_IVK_MTHD");

    private  String code;
    private  String value;

    ContextKeyEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }
}
