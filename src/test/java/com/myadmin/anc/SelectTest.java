package com.myadmin.anc;

import com.myadmin.service.AdmService;
import com.myadmin.service.AncService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class SelectTest {

    @Autowired
    AncService service;

    @Test
    void contextLoads() {

        try {
            service.get(100000);
            log.info("======================================");
            log.info("select 완료");
            log.info("======================================");
        } catch (Exception e) {
            log.info("anc select test error");
            e.printStackTrace();
        }
    }
}
