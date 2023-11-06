package com.react.form.reactform.dtos;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDto {
    private String studentId;

    private String studentName;

    private String studentAddress;
}
