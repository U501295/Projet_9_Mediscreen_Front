package com.softwareacademy.projet9_front.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/Mediscreen")
public class MediscreenController {

    @GetMapping("/home")
    public String getPaginatedString(Model model) {

        return "/Mediscreen/home";
    }



}
