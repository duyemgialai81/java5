package com.example.demo.Buoi1.Controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ResponeinfoController {
    @Autowired
    HttpServletResponse response;

    public String login(){
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        return "Bạn Chưa Đăng Nhập";
    }
}
