package com.mycompany.dvdstore;

import com.mycompany.dvdstore.controller.MovieController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"com.mycompany.dvdstore.controller", "com.mycompany.dvdstore.service", "com.mycompany.dvdstore.repository.file"} )
@PropertySource("application.properties")
//for complementary xml
//@ImportResource("clas
public class App
{
    public static void main( String[] args )
    {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(App.class);
        applicationContext.getBean(MovieController.class).addUsingConsole();
    }
}
