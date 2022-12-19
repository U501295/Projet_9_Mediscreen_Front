package com.softwareacademy.projet9_front.proxy;

import com.softwareacademy.projet9_front.DTO.HistoryM;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "mediscreen-sprint-2", url = "localhost:8082")
    public interface Sprint2Proxy {

    @GetMapping("/patientHistory/{id}")
    public Optional<HistoryM> getHistoryById(@PathVariable("id") Long id);
    }
