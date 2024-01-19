package com.example.myproject.Controller;

import com.example.myproject.Entity.Classroom;
import com.example.myproject.Service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/classroom")
public class ClassroomController {
    @Autowired
    ClassroomService classroomService;
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Classroom classroom){
        classroomService.create(classroom);
        return ResponseEntity.status(HttpStatus.OK).body("tạo mới thành công !!");
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody Classroom classroom){
        classroomService.update(id, classroom);
        return ResponseEntity.status(HttpStatus.OK).body("Đã update!!");
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        classroomService.delete(id);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(classroomService.findById(id).toString());

    }
    @GetMapping()
    public ResponseEntity<?> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(classroomService.findAll().toString());

    }

}
