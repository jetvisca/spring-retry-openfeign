package com.example.openfeign_retry;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("sample")
public interface TestClient {

    @GetMapping("/test")
    String getSampleTest();
}
