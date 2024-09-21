package com.example.websocketchat.controller;

import com.example.websocketchat.model.ChatMessage;
import jakarta.servlet.http.HttpSession;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {



    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    public ChatMessage sendMessage(ChatMessage message) {
        return message;
    }

    @GetMapping("/startChat")
    public String startChat(HttpSession session) {
        session.setAttribute("chatSession", "active");  // ایجاد سشن جدید
        return "chat";  // نمایش صفحه چت
    }

    @GetMapping("/endChat")
    public String endChat(HttpSession session) {
        session.invalidate();  // بستن سشن
        return "redirect:/selectUser";  // بازگشت به لیست کاربران
    }
}
