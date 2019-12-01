package com.mkyong;

import java.net.InetAddress;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private Environment env;
    
    @GetMapping("/")
    public String hello(Model model) throws Exception {

        List<Integer> data = Arrays.asList(1, 2, 3, 4, 5);
        String ipAddress = env.getProperty("spring.cloud.client.ip-address");
        InetAddress inet = InetAddress.getLocalHost();
        logger.debug("Hello from Logback {}, sping cloud ip : {}, inet hostname : {}, inet host Ip : {} ", data, ipAddress, inet.getHostName(), inet.getHostAddress());

        model.addAttribute("num", data);

        return "index"; // index.html
    }

}