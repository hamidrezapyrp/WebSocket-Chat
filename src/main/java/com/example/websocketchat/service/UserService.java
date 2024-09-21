package com.example.websocketchat.service;

import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserService {

    private Set<String> onlineUsers = ConcurrentHashMap.newKeySet();

    public Set<String> getOnlineUsers() {
        return onlineUsers;
    }

    public String startChat( String username) {
        onlineUsers.add(username);
        return "chat";
    }

    public void endChat( String username) {
        onlineUsers.remove(username);
    }
}
