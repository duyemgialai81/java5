package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/admin")
@Controller
public class admin {
    @GetMapping("/home")
    public String demo(Model model){
        model.addAttribute("tile","Đây Là Trang Chủ");
        return "index";
    }
}

