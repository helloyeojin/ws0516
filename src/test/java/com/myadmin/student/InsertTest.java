package com.myadmin.student;

import com.myadmin.dto.Adm;
import com.myadmin.dto.Student;
import com.myadmin.service.AdmService;
import com.myadmin.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class InsertTest {

    @Autowired
    StudentService service;

    @Test
    void contextLoads() {
        Student obj = new Student("st01", "pwd01", "karina", "digi@gmail.com", "0100000000");
        try {
            service.register(obj);
            service.get();
            log.info("======================================");
            log.info("등록완료");
            log.info("======================================");
        } catch (Exception e) {
            log.info("student insert test error");
            e.printStackTrace();
        }
    }
}
