package com.liumapp.spic.core;

import com.alibaba.fastjson.JSONObject;
import com.liumapp.qtools.file.base64.Base64FileTool;
import com.liumapp.spic.core.qr.GenerateQrCode;
import com.liumapp.spic.core.qr.require.GenerateQrCodeRequire;
import junit.framework.TestCase;
import org.junit.Test;

import java.io.IOException;

/**
 * @author liumapp
 * @file SpicCoreTest.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 2018/8/14
 */
public class SpicCoreTest extends TestCase {

    private String savepath = "/usr/local/tomcat/project/hand-painted-signature-core/data/";

    @Test
    public void testGenerateQr () throws IOException {
        SpicCore spicCore = new SpicCore();
        GenerateQrCode generateQrCode = new GenerateQrCode();
        GenerateQrCodeRequire generateQrCodeRequire = new GenerateQrCodeRequire();
        generateQrCodeRequire.setAppId("test_app_id")
                .setAppSecret("test_app_secret")
                .setHost("https://localhost:3030")
                .setPath("/qr/generate");
        JSONObject object = spicCore.doJob(generateQrCode, generateQrCodeRequire);
        Base64FileTool.saveBase64File(object.get("content").toString(), savepath + "qr.jpg");
    }


}
