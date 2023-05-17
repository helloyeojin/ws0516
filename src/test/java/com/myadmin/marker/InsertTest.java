package com.myadmin.marker;

import com.myadmin.dto.Lecture;
import com.myadmin.dto.Marker;
import com.myadmin.service.LectureService;
import com.myadmin.service.MarkerService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class InsertTest {

    @Autowired
    MarkerService service;

    @Test
    void contextLoads() {
        Marker obj = new Marker(1, "맛집22", 37.0,132.0,"a.img",3,"노맛입니다22");
        try {
            service.register(obj);
            service.get();
            log.info("======================================");
            log.info("등록완료");
            log.info("======================================");
        } catch (Exception e) {
            log.info("marker insert test error");
            e.printStackTrace();
        }
    }
}
