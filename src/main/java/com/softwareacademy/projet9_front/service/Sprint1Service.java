package com.softwareacademy.projet9_front.service;

import com.softwareacademy.projet9_front.DTO.PatientM;
import com.softwareacademy.projet9_front.proxy.Sprint1Proxy;
import com.softwareacademy.projet9_front.proxy.Sprint3Proxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Sprint1Service {

    @Autowired
    Sprint1Proxy proxy;

   public List<PatientM> getPatients(){
       return proxy.getPatients();
   }

    public Optional <PatientM> getPatientById(long id){
        return proxy.getPatientById(id);
    }

    public ResponseEntity<Object> addPatient(PatientM patientToAdd){
        proxy.addPatient(patientToAdd);
        return ResponseEntity.status(HttpStatus.CREATED).body(patientToAdd);
    }

}
