package com.liumapp.spic.core.qr.require;

import com.liumapp.qtools.security.encrypt.EncryptUtil;
import com.liumapp.spic.core.job.JobData;

/**
 * @author liumapp
 * @file GenerateQrCodeRequire.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 2018/8/13
 */
public class GenerateQrCodeRequire extends JobData {

    private static final String encryKey = "9ba76bfd500642328ec03ad8ef1b6e75";

    private String host;

    private String path;

    private String appId;

    private String appSecret;

    public GenerateQrCodeRequire() {
    }

    public GenerateQrCodeRequire(String host, String path, String appId, String appSecret) {
        this.host = host;
        this.path = path;
        this.appId = appId;
        this.appSecret = appSecret;
    }

    public String getAppCode () throws Exception {
        EncryptUtil encryptUtil = new EncryptUtil(GenerateQrCodeRequire.encryKey, "utf-8");
        String result = "";
        result += encryptUtil.encode(this.appId);
        result += "_";
        result += encryptUtil.encode(this.appSecret);
        return result;
    }
}
