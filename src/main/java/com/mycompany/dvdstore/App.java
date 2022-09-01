package com.mycompany.dvdstore;

import com.mycompany.dvdstore.controller.MovieController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
//for complementary xml
//@ImportResource("clas
public class App
{
    public static void main( String[] args )
    {
        ApplicationContext applicationContext =  SpringApplication.run(App.class);
        applicationContext.getBean(MovieController.class).addUsingConsole();
    }
}
