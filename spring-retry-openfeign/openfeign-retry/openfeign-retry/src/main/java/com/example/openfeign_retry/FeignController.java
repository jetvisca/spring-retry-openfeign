package com.example.openfeign_retry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/feign")
public class FeignController {

    @Autowired
    TestClient testClient;


    @GetMapping("/test")
    @Retryable(maxAttempts = 10, backoff = @Backoff(delay = 1000, maxDelay = 5000))
    ResponseEntity<String> getSample(){
        return ResponseEntity.ok(testClient.getSampleTest());
    }
}
