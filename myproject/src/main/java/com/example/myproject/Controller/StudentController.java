package com.example.myproject.Controller;

import com.example.myproject.Entity.Classroom;
import com.example.myproject.Entity.Student;
import com.example.myproject.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Student student){
        studentService.create(student);
        return ResponseEntity.status(HttpStatus.OK).body("tạo mới thành công !!");
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody Student student){
        studentService.update(id, student);
        return ResponseEntity.status(HttpStatus.OK).body("Đã update!!");
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        studentService.delete(id);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.findById(id).toString());

    }
    @GetMapping()
    public ResponseEntity<?> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.findAll().toString());

    }

}
