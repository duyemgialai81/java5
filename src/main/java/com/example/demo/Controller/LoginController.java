package com.example.demo.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.zip.Checksum;

@Controller
@RequestMapping("/api")
public class LoginController {
    @GetMapping("/login")
    public String loggin(){
        return "login";
    }
    @GetMapping("/trang-chu")
    public String home(HttpSession session, Model model){
        model.addAttribute("taiKhoan",session.getAttribute("taiKhoan"));
        model.addAttribute("matKhau",session.getAttribute("matKhauu"));
        model.addAttribute("hovaten",session.getAttribute("hovaten"));
        model.addAttribute("diachi",session.getAttribute("diachi"));
        model.addAttribute("nam",session.getAttribute("nam"));
        model.addAttribute("gt",session.getAttribute("gt"));
        return "hone";
    }
    @PostMapping("/au-then")
    public String auThen(@RequestParam String taiKhoan, @RequestParam String matKhauu, Model model, HttpSession session){
        if (!taiKhoan.equalsIgnoreCase("admin") || !matKhauu.equalsIgnoreCase("1")){
            model.addAttribute("thongBao", "Tài Khoản Mật Không Chính Xác");
            return "login";
        }
        session.setAttribute("taiKhoan",taiKhoan);
        session.setAttribute("matKhauu",matKhauu);
        session.setAttribute("hovaten","Đoàn Ngọc Duy");
        session.setAttribute("diachi","GiaLai");
        session.setAttribute("nam","2005/09/06");
        session.setAttribute("gt","true");
        return "redirect:/api/trang-chu";
    }
}
