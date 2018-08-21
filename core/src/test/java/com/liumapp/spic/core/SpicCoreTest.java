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

    private String savepath = "/usr/local/tomcat/project/hand-painted-signature/core/data/";

    @Test
    public void testGenerateQr () throws IOException {
        SpicCore spicCore = new SpicCore();
        GenerateQrCode generateQrCode = new GenerateQrCode();
        GenerateQrCodeRequire generateQrCodeRequire = new GenerateQrCodeRequire();
        generateQrCodeRequire.setAppId("test_app_id")
                .setAppSecret("test_app_secret")
                .setHost("http://localhost:3030")
                .setReturnUrl("http://localhost:7070/returnurl/getpic") //您获取签名图片的通知回调地址 请勿添加任何形式的参数（不能带有? & =等符号）
                .setPath("/qr/generate");
        JSONObject object = spicCore.doJob(generateQrCode, generateQrCodeRequire);
        Base64FileTool.saveBase64File(object.get("content").toString(), savepath + "qr.jpg");//存储二维码图片到本地
        System.out.println("your picNo is : " + object.get("picNo").toString());//签名图片唯一标识
    }


}
