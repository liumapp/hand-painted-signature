package com.liumapp.spic.core.status;

/**
 * @author liumapp
 * @file Status.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 2018/8/14
 */
public enum Status {

    ERROR_CODE(10000),

    SUCCESS(10001),

    GENERATE_QRCODE_ERROR(10002),

    AUTH_FAILED(10003);

    private Integer value;

    public Integer getValue () {
        return this.value;
    }

    private Status(Integer value) {
        this.value = value;
    }

}
