package com.example.demo.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class SesstionCOntroller {
    @Autowired
    HttpSession session;
    @GetMapping
    public String Login(@RequestParam String username) {
        session.setAttribute("username", username);
        System.out.println(username);
        return "redirect:/login/info";
    }
    @GetMapping("/info")
    public String register(Model model){
        String username = (String) session.getAttribute("username");
        if (username == null){
            model.addAttribute("info","Chưa Lưu sesstion");
        }else {
            model.addAttribute("info","Tên Sesstion :"+username);
        }
        return "index";
    }
    @GetMapping("/logout")
    public String logout(){
        session.removeAttribute("username");
        return "redirect:/login/info";
    }
}
