package com.example.workflow;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.ProcessEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/items")
@Slf4j
public class ItemController {

    @Autowired
    private ProcessEngine engine;

    @DeleteMapping("{item}")
    public ResponseEntity<Void> cancelItem(@PathVariable String item) {
        log.info("Canceling item {}", item);

        engine.getRuntimeService()
                .createMessageCorrelation("ItemCanceledEvent")
                .localVariableEquals("item", item)
                .correlate();

        return ResponseEntity.noContent()
                .build();
    }
}
