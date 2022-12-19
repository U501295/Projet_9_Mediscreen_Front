package com.softwareacademy.projet9_front.web;

import com.softwareacademy.projet9_front.DTO.AssessM;
import com.softwareacademy.projet9_front.DTO.HistoryM;
import com.softwareacademy.projet9_front.DTO.PatientM;
import com.softwareacademy.projet9_front.DTO.PatientsM;
import com.softwareacademy.projet9_front.service.Sprint1Service;
import com.softwareacademy.projet9_front.service.Sprint2Service;
import com.softwareacademy.projet9_front.service.Sprint3Service;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    Sprint3Service sprint3Service;
    @Autowired
    Sprint2Service sprint2Service;
    @Autowired
    Sprint1Service sprint1Service;

    @GetMapping("/home")
    public String getPaginatedString(Model model) {
        PatientsM patients = new PatientsM();
        patients.setPatientsM(sprint1Service.getPatients());
        model.addAttribute("patients", patients);
        return "/Mediscreen/home";
    }

    @GetMapping("/info/{id}")
    public String getPaginatedString(Model model,@PathVariable("id") long patientId){
        PatientM patient = sprint1Service.getPatientById(patientId).get();
        AssessM assess = sprint3Service.getDiabeteResultById(patientId);
        HistoryM history = sprint2Service.getHistoryById(patientId).get();
        model.addAttribute("patientInfosFromSprint1", patient);
        model.addAttribute("patientInfosFromSprint2", history);
        model.addAttribute("patientInfosFromSprint3",assess);

        return "/Mediscreen/info";
    }



}
