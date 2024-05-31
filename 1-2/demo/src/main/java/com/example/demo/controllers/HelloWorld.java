package com.example.demo.controllers;

import com.example.demo.external.MyInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class HelloWorld {
    //private MyInterface myInterface;
    //This is called Constructor Injection
    /*
    @Autowired
    public HelloWorld(MyInterface myInterface) {
        this.myInterface = myInterface;
    }
    public HelloWorld() {
        this.myInterface = new FirstClass();
    }
    */
    //This is called Setter Injection
    /*@Autowired
    public void setMyInterface(MyInterface myInterface) {
        this.myInterface = myInterface;
    }*/
    //This is called Filed Injection
    /*@Autowired
    private MyInterface myInterface;*/

    private final MyInterface myInterface;
    //private final MyInterface myInterface2;
    /*
    @Autowired
    public HelloWorld(@Qualifier("secondClass") MyInterface myInterface,@Qualifier("secondClass") MyInterface myInterface2) {
        this.myInterface2 = myInterface2;
        this.myInterface = myInterface;
    }
    */
    /*@Autowired
    public HelloWorld(@Qualifier("secondClass") MyInterface myInterface) {
        this.myInterface = myInterface;
    }*/
    @Autowired
    public HelloWorld(@Qualifier("thirdClass") MyInterface myInterface) {
        this.myInterface = myInterface;
    }

    @Value("${team.coach}")
    private String teamCoach;
    @Value("${team.club}")
    private String teamClub;
    @GetMapping("/team-info")
    public String teamInfo(){
        return "team club : " + teamClub + ", team coach  : " + teamCoach;
    }
    @GetMapping("/")
    public String sayHelloWorld(){
        return "Hello World!!!";
    }
    @GetMapping("/interface")
    public String myInterface(){
        //MyInterface myInterface = new FirstClass();
        //MyInterface myInterface = new SecondClass();
        return myInterface.myFunction();// + myInterface2.myFunction();
    }
    /*@GetMapping("/check")
    public boolean check(){
        return myInterface==myInterface2;
    }*/
}
