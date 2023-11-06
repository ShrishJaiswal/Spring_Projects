package com.react.form.reactform.service;

import com.react.form.reactform.dtos.StudentDto;

import java.util.List;

public interface StudentService {

    StudentDto create(StudentDto studentDto);

    StudentDto update(StudentDto studentDto, String studentId);

    void delete(String studentId);

    List<StudentDto> getAllStudent();
}
