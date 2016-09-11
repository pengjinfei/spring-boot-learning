package com.pengjinfei.ch4.controller;

import com.pengjinfei.ch4.domain.DemoObj;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Pengjinfei on 16/9/10.
 * Description:
 */
@RestController
@RequestMapping("/rest")
public class DemoRestController {

    @RequestMapping(value = "/getjson", produces = "application/json;charset=UTF-8")
    public DemoObj getjson(DemoObj demoObj) {
        return new DemoObj(demoObj.getId() + 1, demoObj.getName() + "_json");
    }

    @RequestMapping(value = "/getxml", produces = "application/xml;charset=UTF-8")
    public DemoObj getxml(DemoObj demoObj) {
        return new DemoObj(demoObj.getId() + 1, demoObj.getName() + "_xml");
    }
}
