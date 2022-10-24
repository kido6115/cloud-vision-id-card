package com.sungyeh.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Config
 *
 * @author sungyeh
 */
@ConfigurationProperties(prefix = "google")
@Data
@Component
public class Config {

    private String cloudVision;
}
