package com.react.form.reactform.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    @Id
    private String studentId;

    @Column(name="name")
    private String studentName;

    @Column(name="address")
    private String studentAddress;

}
