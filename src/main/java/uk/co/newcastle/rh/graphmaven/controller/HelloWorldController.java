package uk.co.newcastle.rh.graphmaven.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloWorldController {

    private final static Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

    @RequestMapping("/")
    public String sayHello() {
        //logger.info("logback使用成功！");
        return "Hello,World!";
    }

}
