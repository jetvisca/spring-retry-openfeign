package com.example.openfeign_retry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class RetryServiceSample {

    private static final Logger logger = LoggerFactory.getLogger(RetryServiceSample.class);

    @Retryable(
            value = { RuntimeException.class },
            maxAttempts = 3,
            backoff = @Backoff(delay = 2000)
    )
    public void performTask() {
        logger.info("Attempting task...");
        throw new RuntimeException("Simulated failure");
    }

    @Recover
    public void recover(RuntimeException e) {
        logger.error("Recovering from failure: {}", e.getMessage());
    }

}


