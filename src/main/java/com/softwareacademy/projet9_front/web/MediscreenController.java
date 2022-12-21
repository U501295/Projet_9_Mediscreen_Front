package com.softwareacademy.projet9_front.web;

import com.softwareacademy.projet9_front.DTO.*;
import com.softwareacademy.projet9_front.service.Sprint1Service;
import com.softwareacademy.projet9_front.service.Sprint2Service;
import com.softwareacademy.projet9_front.service.Sprint3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
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

    @PostMapping("/home/addpatient")
    public String addTransferApp(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("birthdate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate birthdate, @RequestParam("gender") String gender, @RequestParam("phone") String phone, @RequestParam("address") String address, Model model) {

        PatientM newPatient = new PatientM();
        newPatient.setFirstName(firstName);
        newPatient.setLastName(lastName);
        newPatient.setBirthdate(birthdate);
        newPatient.setGender(gender);
        newPatient.setPhone(phone);
        newPatient.setAddress(address);

        NoteM emptyNote = new NoteM("Début du suivi du patient");
        List<NoteM> emptyNoteList = new ArrayList<>();
        emptyNoteList.add(emptyNote);

        sprint1Service.addPatient(newPatient);
        newPatient.setId(sprint1Service.getPatients().get(sprint1Service.getPatients().size()-1).getId());
        sprint2Service.addPatientHistory(new HistoryM(newPatient.getId(), newPatient.getFirstName(), newPatient.getLastName(), emptyNoteList));
        return "redirect:/Mediscreen/home";

    }

    @PostMapping("/info/note/{id}")
    public String updateOrCreateNote(@PathVariable("id") long patientId,@RequestParam("content") String content,Model model) {
        PatientM patient = sprint1Service.getPatientById(patientId).get();
        AssessM assess = sprint3Service.getDiabeteResultById(patientId);
        HistoryM history = sprint2Service.getHistoryById(patientId).get();
        model.addAttribute("patientInfosFromSprint1", patient);
        model.addAttribute("patientInfosFromSprint2", history);
        model.addAttribute("patientInfosFromSprint3",assess);
        model.addAttribute("newLineChar", '\n');
        NoteM noteToBePublished = new NoteM(content);
        sprint2Service.updateOrAddNote(patient.getFirstName(), patient.getLastName(), noteToBePublished);
        return "redirect:/Mediscreen/info/{id}";

    }



}
