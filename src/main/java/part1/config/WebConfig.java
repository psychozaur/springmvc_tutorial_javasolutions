package main.java.part1.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan("main.java.part1") //pakiet gdzie bedziemy poszukiwac kontrolerow?
                                    //ma zasięgiem obejmować wszystkie adnotacje Component, więc niekoniecznie
public class WebConfig implements WebMvcConfigurer {

    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp();
    }
}
