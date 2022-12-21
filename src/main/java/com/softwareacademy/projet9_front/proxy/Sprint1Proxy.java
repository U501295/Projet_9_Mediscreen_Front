package com.softwareacademy.projet9_front.proxy;

import com.softwareacademy.projet9_front.DTO.PatientM;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "mediscreen-sprint-1", url = "localhost:8081")
public interface Sprint1Proxy {

    @GetMapping("/patients")
    List<PatientM> getPatients();

    @GetMapping("/patient/{id}")
    Optional<PatientM> getPatientById(@PathVariable("id") Long id);

    @PostMapping("/patient/add")
    public ResponseEntity<Object> addPatient(@RequestBody PatientM patient);
}
