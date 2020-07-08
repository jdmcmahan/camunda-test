package com.example.workflow;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ItemProcessor implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Object item = delegateExecution.getVariable("item");
        log.info("Processing item {}", item);

        /*try {
            Thread.sleep(10000);
            log.info("Done processing item {}", item);
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
        }*/
    }
}
