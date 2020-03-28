package com.mt.tlstools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
public class TlsToolsApplication {

    public static void main(String[] args) {
        SpringApplication.run(TlsToolsApplication.class, args);
    }



}
