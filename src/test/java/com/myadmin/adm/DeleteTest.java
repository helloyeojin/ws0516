package com.myadmin.adm;

import com.myadmin.service.AdmService;
import com.myadmin.service.LectureService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class DeleteTest {

    @Autowired
    AdmService service;

    @Test
    void contextLoads() {

        try {
            service.remove("id");
            service.get();
            log.info("======================================");
            log.info("제거완료");
            log.info("======================================");
        } catch (Exception e) {
            log.info("adm delete test error");
            e.printStackTrace();
        }
    }
}
