package com.example.myproject.Service.impl;

import com.example.myproject.Entity.Classroom;
import com.example.myproject.Repository.ClassroomRepository;
import com.example.myproject.Service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassroomServiceImpl implements ClassroomService {
    @Autowired
    ClassroomRepository classroomRepository;
    @Override
    public Classroom create(Classroom classroom) {

        return classroomRepository.save(classroom);
    }

    @Override
    public Classroom update(Long id, Classroom classroom) {
        Classroom classroom1= classroomRepository.findById(id).orElse(null);
        if(classroom1==null){
            return classroomRepository.save(classroom);
        }
        classroom1.setId(classroom.getId());
        classroom1.setName(classroom.getName());
        return classroomRepository.save(classroom1);
    }

    @Override
    public void delete(Long id) {
        classroomRepository.deleteById(id);
    }

    @Override
    public Classroom findById(Long id) {
        return classroomRepository.findById(id).orElse(null);
    }

    @Override
    public Iterable<Classroom> findAll() {
        return classroomRepository.findAll();
    }
}
