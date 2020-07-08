package com.example.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class ItemGenerator implements JavaDelegate {


    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        List<String> items = IntStream.range(0, 3)
                .mapToObj(String::valueOf)
                .collect(Collectors.toList());

        delegateExecution.setVariable("items", items);
    }
}
