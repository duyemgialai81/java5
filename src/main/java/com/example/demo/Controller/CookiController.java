package com.example.demo.Controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class CookiController {
    @GetMapping("/cooki")
    public String cooki(@CookieValue(name = "user", defaultValue = "Khách") String name, Model model){
        model.addAttribute("user",name);
        return "Chào Mừng Đ  ến với trang cooki"+name;
    }
    @PostMapping("/add")
    public String addCooki(@RequestParam(name = "user", defaultValue = "Khách") String name, HttpServletResponse httpServletRequest){
        Cookie cookie = new Cookie("user", name);
        cookie.setMaxAge(60*60*24);
        cookie.setPath("/api");
        httpServletRequest.addCookie(cookie);
        return "Thêm cooki thành công"+name;
    }
}
