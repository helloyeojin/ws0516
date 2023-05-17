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
public class UpdateTest {

    @Autowired
    MarkerService service;

    @Test
    void contextLoads() {
        Marker obj = new Marker(100000, "맛집22332", 37.0,132.0,"a.img",5,"노맛333입니다22");

        try {
            service.modify(obj);
            service.get();
            log.info("======================================");
            log.info("수정완료");
            log.info("======================================");
        } catch (Exception e) {
            log.info("marker update test error");
            e.printStackTrace();
        }
    }
}
