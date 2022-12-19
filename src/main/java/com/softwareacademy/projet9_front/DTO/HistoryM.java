package com.softwareacademy.projet9_front.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HistoryM {

    private Long patientId;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    private List<NoteM> notes;
}
