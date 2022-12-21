package com.softwareacademy.projet9_front.proxy;

import com.softwareacademy.projet9_front.DTO.HistoryM;
import com.softwareacademy.projet9_front.DTO.NoteM;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@FeignClient(name = "mediscreen-sprint-2", url = "localhost:8082")
    public interface Sprint2Proxy {

    @GetMapping("/patientHistory/{id}")
    public Optional<HistoryM> getHistoryById(@PathVariable("id") Long id);


    @PostMapping("/patientHistory/add")
    public ResponseEntity<Object> addPatientHistory(@RequestBody HistoryM patientHistory);

    @PutMapping("/patientHistory")
    public ResponseEntity<Object> updateOrAddNote(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestBody NoteM note);
}
