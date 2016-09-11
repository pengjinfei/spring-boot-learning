package com.pengjinfei.ch4.controller;

import com.pengjinfei.ch4.domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Pengjinfei on 16/9/10.
 * Description:
 */
@Controller
public class ConverterController {

    @ResponseBody
    @RequestMapping(value = "/convert",produces = "application/pengjinfei")
    public DemoObj convert(@RequestBody DemoObj demoObj) {
        return demoObj;
    }
}
