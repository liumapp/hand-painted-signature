package com.liumapp.spic.core.qr;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.liumapp.qtools.http.HttpTool;
import com.liumapp.spic.core.job.JobDetail;
import com.liumapp.spic.core.qr.require.GenerateQrCodeRequire;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

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
        Map<String, String> headers = new HashMap<String, String>();
        Map<String, String> querys = new HashMap<String, String>();
        JSONObject object = new JSONObject();
        try {
            object.put("code", data.getAppCode());
            String bodys = object.toJSONString();
            headers.put("Content-Type", "application/json");
            HttpResponse response = httpTool.doPost(data.getHost(),
                    data.getPath(),
                    "POST",
                    headers,
                    querys,
                    bodys);
            String res = EntityUtils.toString(response.getEntity());
            JSONObject res_obj = JSON.parseObject(res);
            Integer status = res_obj.getInteger("status");
            if (status.equals(10001)) {
                this.jobResult.put("msg", "success");
                this.jobResult.put("content", res_obj.get("content"));
            } else if (status.equals(10003)) {
                this.jobResult.put("msg", "权限认证失败，请检查appid与appkey是否正确");
            } else {
                this.jobResult.put("msg", "生成二维码失败");
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            this.jobResult.put("msg", "error");
        }
        return this.jobResult;
    }

}
