package com.liumapp.spic.core;

import com.alibaba.fastjson.JSONObject;
import com.liumapp.spic.core.job.JobData;
import com.liumapp.spic.core.job.JobDetail;

/**
 * @author liumapp
 * @file SpicCore.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 2018/8/13
 */
public class SpicCore {

    public JSONObject doJob(JobDetail jobDetail, JobData jobData) {
        return jobDetail.handle(jobData);
    }

}
