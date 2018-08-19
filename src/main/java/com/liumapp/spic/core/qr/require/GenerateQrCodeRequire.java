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

    private String returnUrl;

    public GenerateQrCodeRequire() {
    }

    public GenerateQrCodeRequire(String host, String path, String appId, String appSecret, String returnUrl) {
        this.host = host;
        this.path = path;
        this.appId = appId;
        this.appSecret = appSecret;
        this.returnUrl = returnUrl;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public GenerateQrCodeRequire setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
        return this;
    }

    public String getAppCode () throws Exception {
        EncryptUtil encryptUtil = new EncryptUtil(GenerateQrCodeRequire.encryKey, "utf-8");
        String result = "";
        result += encryptUtil.encode(this.appId);
        result += "_";
        result += encryptUtil.encode(this.appSecret);
        return result;
    }

    public String getHost() {
        return host;
    }

    public GenerateQrCodeRequire setHost(String host) {
        this.host = host;
        return this;
    }

    public String getPath() {
        return path;
    }

    public GenerateQrCodeRequire setPath(String path) {
        this.path = path;
        return this;
    }

    public String getAppId() {
        return appId;
    }

    public GenerateQrCodeRequire setAppId(String appId) {
        this.appId = appId;
        return this;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public GenerateQrCodeRequire setAppSecret(String appSecret) {
        this.appSecret = appSecret;
        return this;
    }
}
