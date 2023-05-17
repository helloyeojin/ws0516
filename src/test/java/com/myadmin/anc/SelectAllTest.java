package com.myadmin.anc;

import com.myadmin.service.AdmService;
import com.myadmin.service.AncService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class SelectAllTest {

    @Autowired
    AncService service;

    @Test
    void contextLoads() {

        try {
            service.get();
            log.info("======================================");
            log.info("select All 완료");
            log.info("======================================");
        } catch (Exception e) {
            log.info("anc select All test error");
            e.printStackTrace();
        }
    }
}
