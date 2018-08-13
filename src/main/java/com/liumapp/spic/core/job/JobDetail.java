package com.liumapp.spic.core.job;

import com.alibaba.fastjson.JSONObject;

/**
 * @author liumapp
 * @file JobDetail.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 2018/8/13
 */
public abstract class JobDetail<T extends JobData> {

    protected JSONObject jobResult;

    public JobDetail() {
        this.jobResult = new JSONObject();
    }

    public abstract JSONObject handle(T data);

}