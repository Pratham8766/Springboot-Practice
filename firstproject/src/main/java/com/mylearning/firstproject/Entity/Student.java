package com.mylearning.firstproject.Entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

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

    private String name;

    private int roll_no;

    private String email;

    private LocalDate date_of_birth;
}
