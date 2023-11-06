package com.react.form.reactform.repository;

import com.react.form.reactform.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface StudentRepository extends JpaRepository<Student, String> {
}
