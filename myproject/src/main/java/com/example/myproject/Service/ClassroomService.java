package com.example.myproject.Service;

import com.example.myproject.Entity.Classroom;

public interface ClassroomService {
    Classroom create(Classroom classroom);
    Classroom update(Long id,Classroom classroom);
    void delete (Long id);
    Classroom findById(Long id);
    Iterable<Classroom> findAll();

}
