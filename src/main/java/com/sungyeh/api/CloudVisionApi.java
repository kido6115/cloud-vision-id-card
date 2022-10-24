package com.sungyeh.api;

import com.sungyeh.config.Config;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * CloudVisionApi
 *
 * @author sungyeh
 */
@Component
@Slf4j
public class CloudVisionApi {

    @Resource
    private Config config;

    @Value("classpath:sample.json")
    org.springframework.core.io.Resource resourceFile;

    public void send() {
        InputStream stream = null;
        InputStreamReader isReader = null;
        BufferedReader reader = null;
        String text = "";
        try {
            stream = resourceFile.getInputStream();
            isReader = new InputStreamReader(stream, StandardCharsets.UTF_8);
            reader = new BufferedReader(isReader);
            String line = null;
            while ((line = reader.readLine()) != null) {
                text += line;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e) {
                    log.info(e.getMessage(), e);
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    log.info(e.getMessage(), e);
                }
            }
            if (isReader != null) {
                try {
                    isReader.close();
                } catch (IOException e) {
                    log.info(e.getMessage(), e);
                }
            }
        }
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> request = new HttpEntity<>(text, httpHeaders);
        String test = restTemplate.postForObject("https://vision.googleapis.com/v1/images:annotate?key=" + config.getCloudVision(), request, String.class);
        System.out.println(test);
    }
}
