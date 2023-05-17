package com.myadmin.adm;

import com.myadmin.dto.Adm;
import com.myadmin.dto.Lecture;
import com.myadmin.service.AdmService;
import com.myadmin.service.LectureService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class UpdateTest {

    @Autowired
    AdmService service;

    @Test
    void contextLoads() {
        Adm obj = new Adm("id", "111", 2);
        try {
            service.modify(obj);
            service.get();
            log.info("======================================");
            log.info("수정완료");
            log.info("======================================");
        } catch (Exception e) {
            log.info("adm update test error");
            e.printStackTrace();
        }
    }
}
