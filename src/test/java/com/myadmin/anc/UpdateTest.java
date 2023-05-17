package com.myadmin.anc;

import com.myadmin.dto.Adm;
import com.myadmin.dto.Anc;
import com.myadmin.service.AdmService;
import com.myadmin.service.AncService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class UpdateTest {

    @Autowired
    AncService service;

    @Test
    void contextLoads() {
        Anc obj = new Anc(100000, "111","아디111","길어111","null","kuk.jpg");
        try {
            service.modify(obj);
            service.get();
            log.info("======================================");
            log.info("수정완료");
            log.info("======================================");
        } catch (Exception e) {
            log.info("anc update test error");
            e.printStackTrace();
        }
    }
}
