package com.myadmin.lecture;

import com.myadmin.dto.Lecture;
import com.myadmin.service.LectureService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class InsertTest {

    @Autowired
    LectureService service;

    @Test
    void contextLoads() {
        Lecture obj = new Lecture(1, "title", "teacher", "topic", "target",
                "rdate", "time", 100000, "a.jpg");
        try {
            service.register(obj);
            service.get();
            log.info("======================================");
            log.info("등록완료");
            log.info("======================================");
        } catch (Exception e) {
            log.info("lecture insert test error");
            e.printStackTrace();
        }
    }
}
