package com.mycompany.dvdstore;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"com.mycompany.dvdstore.controller", "com.mycompany.dvdstore.service", "com.mycompany.dvdstore.repository.file"} )
@PropertySource("application.properties")
//for complementary xml
//@ImportResource("classpath:applicationContext.xml")
public class AppConfig {
}
