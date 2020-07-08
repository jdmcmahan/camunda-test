package com.example.workflow;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.camunda.bpm.spring.boot.starter.event.PostDeployEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.UUID;

@SpringBootApplication
@EnableProcessApplication
@EnableAsync
@ComponentScan(basePackages = { "com.example", "org.camunda" })
@Slf4j
public class CamundaTestApplication {

    @Autowired
    private RuntimeService runtimeService;

    public static void main(String[] args) {
        SpringApplication.run(CamundaTestApplication.class);
    }

    /*@EventListener
    @Async
    public void processPostDeploy(PostDeployEvent event) {
        log.info("Starting process instance");
        runtimeService.startProcessInstanceByKey("testProcess", UUID.randomUUID().toString());
    }*/
}