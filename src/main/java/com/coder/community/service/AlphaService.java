package com.coder.community.service;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class AlphaService {

    public AlphaService(){
        System.out.println("实例化Alpha SERvice!");
    }

    @PostConstruct
    public void init(){
        System.out.println("初始化Alpha Service!");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("destroy!");
    }

}
