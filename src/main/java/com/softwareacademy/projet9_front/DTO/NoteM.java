package com.softwareacademy.projet9_front.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.validation.constraints.NotBlank;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class NoteM {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate creationDate;

    @NotBlank
    private String content;
}
