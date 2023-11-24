package com.jrs.appraisal.connect.repository;

import com.jrs.appraisal.connect.model.Message;
import com.jrs.appraisal.connect.model.Vlog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, String> {

    //List<Message> findByMsgFileId(String msgFileId);
    List<Message> findByMsgFileIdOrderByMsgDateTime(String msgFileId);

}
