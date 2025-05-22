package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class ProductController {
    @GetMapping("/product/{size}/{number}")
    public String getProduct(@PathVariable("size") int pageSize, @PathVariable("number") int pageNumBer){
        System.out.println("size:"+pageSize);
        System.out.println("number:"+pageNumBer);
        return "product";
    }
}
