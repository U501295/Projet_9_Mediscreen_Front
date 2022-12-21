package com.softwareacademy.projet9_front.service;

import com.softwareacademy.projet9_front.DTO.HistoryM;
import com.softwareacademy.projet9_front.DTO.NoteM;
import com.softwareacademy.projet9_front.DTO.PatientM;
import com.softwareacademy.projet9_front.proxy.Sprint1Proxy;
import com.softwareacademy.projet9_front.proxy.Sprint2Proxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Sprint2Service {
    @Autowired
    Sprint2Proxy proxy;


    public Optional <HistoryM> getHistoryById(long id){
        return proxy.getHistoryById(id);
    }

    public ResponseEntity<Object> addPatientHistory(HistoryM historyToadd){
        return proxy.addPatientHistory(historyToadd);
    }

    public ResponseEntity<Object> updateOrAddNote(String firstName, String lastName, NoteM noteToAdd){
        return proxy.updateOrAddNote(firstName,lastName,noteToAdd);
    }

}
