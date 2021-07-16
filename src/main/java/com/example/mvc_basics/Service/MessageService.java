package com.example.mvc_basics.Service;

import com.example.mvc_basics.ChatForm;
import com.example.mvc_basics.ChatMessage;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class MessageService {

    private List<ChatMessage> chatMesaage;

    @PostConstruct
    public void postconstruct(){

        System.out.println("Creating MessageService Bean");
        this.chatMesaage = new ArrayList<>();

    }
    public void addMessage(ChatForm chatForm){

        ChatMessage newMessage = new ChatMessage();

        newMessage.setUsername(chatForm.getUsername());

        switch(chatForm.getMessageType()){

            case "Say":

                newMessage.setMessage(chatForm.getMessageText());


            case "Shout":

                newMessage.setMessage(chatForm.getMessageText().toUpperCase());

                break;
            case "Whisper":

                newMessage.setMessage(chatForm.getMessageText().toLowerCase());

                break;

        }
        this.chatMesaage.add(newMessage);



    }

    public List<ChatMessage> getChatMesaages(){

        return chatMesaage;
    }
}
