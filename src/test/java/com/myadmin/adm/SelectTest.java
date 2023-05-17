package com.myadmin.adm;

import com.myadmin.service.AdmService;
import com.myadmin.service.LectureService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class SelectTest {

    @Autowired
    AdmService service;

    @Test
    void contextLoads() {

        try {
            service.get("id");
            log.info("======================================");
            log.info("select 완료");
            log.info("======================================");
        } catch (Exception e) {
            log.info("adm select test error");
            e.printStackTrace();
        }
    }
}
