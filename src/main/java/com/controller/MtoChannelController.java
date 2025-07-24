package com.controller;

import com.domain.MtoChannel;
import com.example.task.demotest.DemotestApplication;
import com.service.MtoChannelService;
import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@Controller
public class MtoChannelController {

    private static final Logger logger = LoggerFactory.getLogger(MtoChannelController.class);


    @Autowired
    private MtoChannelService mtoChannelService;

    // 使用@PostConstruct替代@Bean，在Bean初始化后执行测试
//    @PostConstruct
//    public void test() {
//        try {
//            int i = mtoChannelService.deleteByPrimaryKey(1);
//            if (i > 0) {
//                System.out.println("success");
//            } else {
//                System.out.println("fail - no record found or deleted");
//            }
//        } catch (Exception e) {
//            System.out.println("fail - exception: " + e.getMessage());
//        }
//    }

    @GetMapping("/show")
    @ResponseBody
    public void showdata(){
        System.out.println("hello world!");
    }

    // 添加一个简单的测试接口
    @GetMapping("/test")
    @ResponseBody
    public String testEndpoint() {
        return "Controller is working!";
    }
    @GetMapping("/mtoChannel/{id}")
    @ResponseBody
    public MtoChannel getMtoChannel(@PathVariable Integer id) {
        return mtoChannelService.selectByPrimaryKey(id);
    }

    @PostMapping("/mtoChannel")
    @ResponseBody
    public ResponseEntity<?> insert(@RequestBody MtoChannel mtoChannel) {
        try {
            int insert = mtoChannelService.insert(mtoChannel);
            if (insert == 1) {
                return ResponseEntity.ok().body(Map.of("message", "success"));
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(Map.of("message", "Failed to insert data"));
            }
        } catch (Exception e) {
            logger.error("Error inserting MtoChannel", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("message", "Error occurred: " + e.getMessage()));
        }
    }


}