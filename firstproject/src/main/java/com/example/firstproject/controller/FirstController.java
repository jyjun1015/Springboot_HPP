package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {
	
    @GetMapping("/hi")
    public String niceTOMeetYou(Model model){
        model.addAttribute("username", "정영돈");
        return "greetings"; // templates/greetings.mustache -> 釉뚮씪�슦��濡� �쟾�넚
    };

}
