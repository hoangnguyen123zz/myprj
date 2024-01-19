package com.example.myproject.Service.impl;

import com.example.myproject.Entity.Student;
import com.example.myproject.Repository.StudentRepository;
import com.example.myproject.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Override
    public Student create(Student student) {

        return studentRepository.save(student);
    }

    @Override
    public Student update(Long id, Student student) {
        Student student1=studentRepository.findById(id).orElse(null);
        if (student1==null){
            return null;
        }
        student1.setName(student.getName());
        student1.setAge(student.getAge());
        student1.setAddress(student.getAddress());
        student1.setGender(student.getGender());
        student1.setClassRoom(student.getClassRoom());
        return student1;
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);

    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Iterable<Student> findAll() {
        return studentRepository.findAll();
    }
}
