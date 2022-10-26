package com.sungyeh;

import com.sungyeh.api.CloudVisionApi;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

/**
 * ApiTest
 *
 * @author sungyeh
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ApiTest {
    @Resource
    private CloudVisionApi cloudVisionApi;

    @Test
    public void test() {

//        cloudVisionApi.send();
    }
}
