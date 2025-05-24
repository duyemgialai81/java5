package com.example.demo.Buoi1.Controller;

import com.example.demo.Buoi1.Controller.Entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api")
public class StudenController {
public static List<Student> students (){
    List<Student> list = new ArrayList<>();
    list.add(new Student(1L,"Đoàn Ngọc Duy",0, LocalDate.of(2005, 9, 6), "Button.png", 8.5));
    list.add(new Student(2L,"Đoàn Ngọc Duy",1, LocalDate.of(2005,9,6),"Button.png",8.5));
    list.add(new Student(3L,"Đoàn Ngọc Duy",0, LocalDate.of(2005,9,6),"Button.png",8.5));
    list.add(new Student(4L,"Đoàn Ngọc Duy",0, LocalDate.of(2005,9,6),"Button.png",8.5));
    list.add(new Student(5L,"Đoàn Ngọc Duy",0, LocalDate.of(2005,9,6),"Button.png",8.5));
    return list;
    }

//    @GetMapping("/hien-thi")
//    public String StudenController(Model model){
//        model.addAttribute("id", "1");
//        model.addAttribute("name", "Đoàn Ngọc Duy");
//        model.addAttribute("gender", "0");
//        model.addAttribute("birthday", "06/09/2005");
//        model.addAttribute("photo", "Button.png");
//        model.addAttribute("avgMark","8.0");
//        return "hien-thi";
//    }
    @GetMapping("/hien-thi")
    public String getAll(Model model){
    List<Student> students = students();
        model.addAttribute("listt", students);
        return "hien-thi";
    }
}
