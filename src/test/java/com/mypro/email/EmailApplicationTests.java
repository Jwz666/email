package com.mypro.email;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmailApplicationTests {

    @Autowired
    private alipay alipay;

    @Test
    void contextLoads() throws Exception {
        alipay.payTest();
    }

}
