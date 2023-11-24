package com.jrs.appraisal.connect.service;

import com.jrs.appraisal.connect.model.Message;
import com.jrs.appraisal.connect.model.Order;
import com.jrs.appraisal.connect.model.Vlog;
import com.jrs.appraisal.connect.repository.MessageRepository;
import com.jrs.appraisal.connect.repository.VlogRepository;
import com.jrs.appraisal.connect.util.myutils;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
@Transactional
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    myutils _utils;

    @Override
    public void createMessage(Message myMessage) {

        try {

            String myTimestamp = _utils.get_timestamp();
            String myDate = myTimestamp.substring(0,8);
            String myTime = myTimestamp.substring(8,17);

            //CREATE MESSAGE
            myMessage.setMsgDateTime(myDate + myTime);
            messageRepository.save(myMessage);


        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public List<Message> getMessagesById(String id) {
        return messageRepository.findByMsgFileIdOrderByMsgDateTime(id);
    }
}
