package com.example.h2dbdemo.service;


import com.example.h2dbdemo.data.Message;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    public void saveMessage(Message message){
        System.out.println("Message saved as "+message.toString());
    }
}
