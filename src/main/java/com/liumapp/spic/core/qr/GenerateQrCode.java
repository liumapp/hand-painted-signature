package com.liumapp.spic.core.qr;

import com.alibaba.fastjson.JSONObject;
import com.liumapp.qtools.http.HttpTool;
import com.liumapp.spic.core.job.JobDetail;
import com.liumapp.spic.core.qr.require.GenerateQrCodeRequire;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author liumapp
 * @file GenerateQrCode.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 2018/8/13
 */
public class GenerateQrCode extends JobDetail <GenerateQrCodeRequire> {

    private HttpTool httpTool;

    private static Logger logger = LoggerFactory.getLogger(GenerateQrCode.class);

    public GenerateQrCode () {
        this.httpTool = new HttpTool();
    }

    @Override
    public JSONObject handle(GenerateQrCodeRequire data) {

        return null;
    }

}
