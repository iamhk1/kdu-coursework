package com.kdu.caching;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
@Slf4j
@SpringBootTest
class CachingApplicationTest {

    @Test
    void contextLoads() {
        log.info("context loads");
        // This test method can be empty; it's just used to ensure that the application context loads successfully
    }
}