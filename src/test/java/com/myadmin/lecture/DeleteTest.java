package com.myadmin.lecture;

import com.myadmin.dto.Lecture;
import com.myadmin.service.LectureService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class DeleteTest {

    @Autowired
    LectureService service;

    @Test
    void contextLoads() {

        try {
            service.remove(100000);
            service.get();
            log.info("======================================");
            log.info("제거완료");
            log.info("======================================");
        } catch (Exception e) {
            log.info("lecture delete test error");
            e.printStackTrace();
        }
    }
}
