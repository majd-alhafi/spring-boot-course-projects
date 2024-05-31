package com.example.demo.config;

import com.example.demo.external.MyInterface;
import com.example.demo.external.ThirdClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationClass {
    @Bean
    //@Bean("CustomBeanId")
    public MyInterface thirdClass(){ //the method name 'thirdClass' will be the @Qualifier for this bean.
        return new ThirdClass();
    }
}
