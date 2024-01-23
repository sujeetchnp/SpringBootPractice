package com.sujeet.project.springboot.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;



@Service
public class MyAppService {

    @Value("${appName}")
    private String myAppName;

    public void printAppName(){
        System.out.println(myAppName);
    }
}
