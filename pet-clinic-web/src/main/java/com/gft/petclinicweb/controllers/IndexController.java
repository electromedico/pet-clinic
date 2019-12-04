package com.gft.petclinicweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping("*")
    public String index(){
        return "index";
    }

    @RequestMapping({"oups"})
    public String findOwners(Model model){
        return "notimplemented";
    }
}
