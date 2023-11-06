package com.react.form.reactform.service.impl;

import com.react.form.reactform.dtos.StudentDto;
import com.react.form.reactform.entities.Student;
import com.react.form.reactform.repository.StudentRepository;
import com.react.form.reactform.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public StudentDto create(StudentDto studentDto) {
        String studentId = UUID.randomUUID().toString();
        studentDto.setStudentId(studentId);
        Student student = dtoToEntity(studentDto);
        Student createdStudent = studentRepository.save(student);
        return entityToDto(createdStudent);
    }

    @Override
    public StudentDto update(StudentDto studentDto, String studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow(()->new RuntimeException("Cannot find Student object"));

        student.setStudentName(studentDto.getStudentName());
        student.setStudentAddress(studentDto.getStudentAddress());

        //update
        Student updatedStudent =  studentRepository.save(student);
        return entityToDto(updatedStudent);
    }

    @Override
    public void delete(String studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow(()->new RuntimeException("Cannot find Student object"));
        studentRepository.delete(student);
    }

    @Override
    public List<StudentDto> getAllStudent() {
        List<Student> studentList = studentRepository.findAll();
        List<StudentDto> studentDtoList = studentList.stream().map(student -> entityToDto(student)).collect(Collectors.toList());
        return studentDtoList;
    }

    private StudentDto entityToDto(Student student){
        StudentDto studentDto = StudentDto.builder()
                .studentId(student.getStudentId())
                .studentName(student.getStudentName())
                .studentAddress(student.getStudentAddress()).build();
        return studentDto;
    }

    private Student dtoToEntity(StudentDto studentDto){
        Student student = Student.builder()
                .studentId(studentDto.getStudentId())
                .studentName(studentDto.getStudentName())
                .studentAddress(studentDto.getStudentAddress()).build();
        return student;
    }
}
