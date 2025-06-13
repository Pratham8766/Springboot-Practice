package com.mylearning.firstproject.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "marks")
public class Marks {
    @Id
    private int roll_no;

    private int math;
    private int science;
    private int english;
    private int history;
}
