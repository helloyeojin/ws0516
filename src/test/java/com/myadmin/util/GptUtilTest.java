package com.myadmin.util;

import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.URISyntaxException;

@SpringBootTest
public class GptUtilTest {

    @Test
    void GptTest() throws URISyntaxException, IOException, InterruptedException, ParseException {
        GptUtil.getResult("how to sleep?");
    }
}
