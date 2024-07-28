package com.example.h2dbdemo.service;


import com.example.h2dbdemo.constants.StatusConstants;
import com.example.h2dbdemo.data.Message;
import com.example.h2dbdemo.repo.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ContactService {

    private final ContactRepository repo;

    @Autowired
    public ContactService(ContactRepository repo) {
        this.repo = repo;
    }

    public void saveMessage(Message message){
        message.setStatus(StatusConstants.OPEN);
        message.setCreatedBy(StatusConstants.ANONYMOUS);
        message.setCreatedAt(LocalDateTime.now());
        int res = repo.saveContact(message);
        System.out.println("Message saved and "+res+" rows/columns are updates");

    }

    public List<Message> findMessageWithOpenStatus() {
        List<Message> result = repo.getMessageWithOpenStatus();
        System.out.println(result);
        return result;
    }

    public boolean changeTicketStatus(int id,String updatedBy){
        boolean isUpdated= false;
        int res = repo.changeTicketStatus(id,StatusConstants.CLOSE,updatedBy);
        if(res > 0){
            isUpdated = true;
        }
        return isUpdated;
    }
}
