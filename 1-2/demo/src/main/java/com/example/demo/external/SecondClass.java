package com.example.demo.external;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Qualifier("secondClass")
@Primary
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//Prototype beans are lazy by default. There is no need to use the @Lazy annotation for prototype scopes beans.

public class SecondClass implements MyInterface{
    private final String field;

    public SecondClass() {
        this.field = "Default Constructor";
        System.out.println("In Constructor " + this.getClass());
    }

    public SecondClass(String filed) {
        this.field = filed;
    }

    @Override
    public String myFunction() {
        return this.field;
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("postConstruct");
    }
    @PreDestroy
    public void preDestroy(){
        System.out.println("preDestroy");
    }

}
