package com.mylearning.firstproject.Entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "student")
public class Student {
    @Id
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "roll_no")
    private int roll_no;

    @Column(name = "email")
    private String email;

    @Column(name = "date_of_birth")
    private LocalDate date_of_birth;
}
