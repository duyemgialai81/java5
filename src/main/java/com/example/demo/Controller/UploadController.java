package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Objects;

@Controller
@RequestMapping("/api")
public class UploadController {
    @GetMapping("/load")
    public String upload(){
        return "upload";
    }
    @PostMapping("/up-load")
    public String upload(@RequestPart("file")MultipartFile multipartFile, Model model){
        if (multipartFile.isEmpty()){
            model.addAttribute("thongBao","file chưa được chọn");
            return "upload";
        }
        try{
            String duongDan = "D:\\Java\\JAVA5\\demo1\\src\\main\\resources\\static\\Upload";
            File fileName = new File(duongDan);
            if (!fileName.exists()){
                fileName.mkdirs();
            }
            String file = new File(fileName, Objects.requireNonNull(multipartFile.getOriginalFilename())).getName();
            multipartFile.transferTo(new File(fileName, file));
            model.addAttribute("thongBao","Tải Tập Tin Thành Công");
            return "upload";
        }catch (Exception e){
            e.printStackTrace();
            return "upload";
        }
    }
}
