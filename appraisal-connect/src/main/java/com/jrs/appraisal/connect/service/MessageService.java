package com.jrs.appraisal.connect.service;

import com.jrs.appraisal.connect.model.Message;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MessageService {

    public void createMessage(Message message);

    public List<Message> getMessagesById(String id);

}
