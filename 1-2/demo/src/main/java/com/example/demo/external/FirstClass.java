package com.example.demo.external;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Qualifier("firstClass")
@Lazy
public class FirstClass implements MyInterface{
    public FirstClass() {
        System.out.println("In Constructor " + this.getClass());
    }

    @Override
    public String myFunction() {
        return "FirstClass";
    }
}
