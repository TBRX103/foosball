package com.bentest;

import org.jsondoc.spring.boot.starter.EnableJSONDoc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@SpringBootApplication
@EnableJSONDoc
public class BentestApplication {

    @RequestMapping( value = "/", method = RequestMethod.GET )
    String home() {
        return "WELCOME TO THE PAGE";
    }

    public static void main( String[] args ) {
        SpringApplication.run( BentestApplication.class, args );
    }
}
