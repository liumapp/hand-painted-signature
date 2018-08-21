package com.liumapp.spic.server.controller;

import com.liumapp.spic.server.pattern.ReturnPicPattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * file ReturnUrlController.java
 * author liumapp
 * email liumapp.com@gmail.com
 * homepage http://www.liumapp.com
 * date 2018/8/20
 */
@RestController
@RequestMapping("returnurl")
public class ReturnUrlController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/getpic")
    public void getReturnPic (@RequestBody ReturnPicPattern returnPicPattern) {
        logger.info("get return info : " + returnPicPattern.toString());
        //save your signed pic here
        //and do something you like
        // :)
    }

}
