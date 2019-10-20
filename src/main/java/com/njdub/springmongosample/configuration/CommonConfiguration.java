package com.njdub.springmongosample.configuration;

import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@Configuration
public class CommonConfiguration {
    @PostConstruct
    void configureTimeZone() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }
}
