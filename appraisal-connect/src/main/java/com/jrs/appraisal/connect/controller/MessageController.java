package com.jrs.appraisal.connect.controller;

import com.jrs.appraisal.connect.model.Message;
import com.jrs.appraisal.connect.model.Vlog;
import com.jrs.appraisal.connect.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/message")
@CrossOrigin(origins = "http://localhost:4200")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createMessage(@RequestBody Message message) {
        log.info("Create message {}", message);
        messageService.createMessage(message);

        return new ResponseEntity<>("Message saved successfully!", HttpStatus.CREATED);
    }

    @GetMapping("/byId/{id}")
    public List<Message> getVlogs(@PathVariable String id) {
        log.info("retrieve vlogs");
        return messageService.getMessagesById(id);
    }

}
