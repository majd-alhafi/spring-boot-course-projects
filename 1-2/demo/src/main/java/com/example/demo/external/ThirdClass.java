package com.example.demo.external;

public class ThirdClass implements MyInterface{
    /*
    * This Class Does not Contain @Component Annotation.
    * But We Will Define It As Bean through @Configuration */
    @Override
    public String myFunction() {
        return "ThirdClass";
    }
}
