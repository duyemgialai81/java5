package com.example.demo.Controller;

import ch.qos.logback.core.util.COWArrayList;
import com.example.demo.Entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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
        return "product/Category";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute Student student,
                       @RequestParam("photo") MultipartFile file) {

        // Lưu ảnh vào thư mục Upload (đảm bảo bạn đã tạo thư mục này trong project)
        String uploadDir = "src/main/resources/static/Upload/";
        String fileName = file.getOriginalFilename();

        try {
            if (!file.isEmpty()) {
                File saveFile = new File(uploadDir + fileName);
                file.transferTo(saveFile);
                student.setPhoto(fileName);
            } else {
                student.setPhoto("default.png"); // hoặc giữ nguyên ảnh cũ
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Gán ID tự động (tăng dần)
        COWArrayList<Object> studentList;
        Long nextId = studentList.isEmpty() ? 1 : studentList.get(studentList.size() - 1).getId() + 1;
        student.setId(nextId);

        // Thêm vào danh sách
        studentList.add(student);

        return "redirect:/api/hien-thi";
    }
}
