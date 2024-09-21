package com.example.websocketchat.controller;

import com.example.websocketchat.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/onlineUsers")
    @ResponseBody
    public Set<String> getOnlineUsers() {
        return userService.getOnlineUsers();
    }

    // افزودن کاربر به لیست آنلاین‌ها و انتقال به صفحه انتخاب کاربر
    @GetMapping("/selectUser/{username}")
    public String selectUser(@PathVariable String username) {
        userService.startChat(username);  // کاربر را آنلاین کنید
        return "select_user";  // انتقال به صفحه انتخاب کاربر
    }
    // افزودن کاربر به لیست آنلاین‌ها و انتقال به صفحه چت
    @GetMapping("/startChat/{username}")
    public String startChat(@PathVariable String username) {
        userService.startChat(username);  // کاربر را آنلاین کنید
        return "chat";  // انتقال به صفحه چت
    }

    // بستن سشن و حذف کاربر از لیست آنلاین‌ها
    @GetMapping("/endChat/{username}")
    public String endChat(@PathVariable String username) {
        userService.endChat(username);  // کاربر را آفلاین کنید
        return "redirect:/";  // بازگشت به صفحه ورود نام کاربری
    }
    @GetMapping("/")
    public String home() {
        return "enter_username";  // نمایش صفحه دریافت نام کاربری
    }
}
