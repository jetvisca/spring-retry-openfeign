package com.example.openfeign_retry_wstocall;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class TestController {


    private static final Logger log = LoggerFactory.getLogger(TestController.class);
    AtomicInteger failCount = new AtomicInteger(0);

    @GetMapping("/test")
    ResponseEntity<String> printTestData(){
        log.info("Current failcount: {}", failCount);
        if(failCount.get() < 5){
            failCount.getAndIncrement();
            return ResponseEntity.internalServerError().body("fail count < 5: " + failCount);
        }else{
            return ResponseEntity.ok("Wondeful! its working!");
        }
    }
}
