package com.react.form.reactform.controller;

import com.react.form.reactform.apiresponsemessage.ApiResponseMessage;
import com.react.form.reactform.dtos.StudentDto;
import com.react.form.reactform.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {

    Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents(){
        return new ResponseEntity<>(studentService.getAllStudent(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto){
        return new ResponseEntity<>(studentService.create(studentDto), HttpStatus.CREATED);
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable String studentId, @RequestBody StudentDto studentDto){
        return new ResponseEntity<>(studentService.update(studentDto, studentId), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<ApiResponseMessage> deleteStudent(@PathVariable String studentId) {
        logger.info("Inside delete class");
        studentService.delete(studentId);
        ApiResponseMessage message = ApiResponseMessage.builder().message("Deleted Successfully").success(true).build();
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

}
