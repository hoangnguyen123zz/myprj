package com.example.myproject.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long age;
    private String gender;
    private String address;
    @ManyToOne
    @JoinColumn(name = "c_id")
    private Classroom classRoom;

}
