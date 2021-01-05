package com.kgc.kmall.kmallsearchweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SearchController {
    @RequestMapping("/index.html")
    public String index(){        return "index";}

    @RequestMapping("/list.html")
    public String list(String keyword){
        return "list";
    }
}
