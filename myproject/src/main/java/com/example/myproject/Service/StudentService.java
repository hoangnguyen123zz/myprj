package com.example.myproject.Service;

import com.example.myproject.Entity.Classroom;
import com.example.myproject.Entity.Student;

public interface StudentService {
    Student create(Student student);
    Student update(Long id,Student student);
    void delete (Long id);
    Student findById(Long id);
    Iterable<Student> findAll();

}
