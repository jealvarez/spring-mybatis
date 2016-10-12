package org.spring.mybatis.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class ApplicationInitializer extends SpringBootServletInitializer {

    public static void main(String[] arguments) {
        final Object[] configurationList = new Object[] {
                ApplicationInitializer.class
        };
        SpringApplication.run(configurationList, arguments);
    }

    @Override
    protected SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
        return application.sources(ApplicationInitializer.class);
    }

}
