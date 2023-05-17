package com.myadmin.anc;

import com.myadmin.service.AdmService;
import com.myadmin.service.AncService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class DeleteTest {

    @Autowired
    AncService service;

    @Test
    void contextLoads() {

        try {
            service.remove(100000);
            service.get();
            log.info("======================================");
            log.info("제거완료");
            log.info("======================================");
        } catch (Exception e) {
            log.info("anc delete test error");
            e.printStackTrace();
        }
    }
}
