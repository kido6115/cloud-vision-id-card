package com.sungyeh.web;

import com.sungyeh.api.CloudVisionApi;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * DemoController
 *
 * @author sungyeh
 */
@Controller

public class DemoController {

    @Resource
    private CloudVisionApi api;

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @PostMapping("/detect")
    @ResponseBody
    public String detect(@RequestParam("para") String para) {
        return api.send(para);
    }
}
