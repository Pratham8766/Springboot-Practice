package com.mylearning.firstproject.Service;

import com.mylearning.firstproject.Entity.Student;
import com.mylearning.firstproject.Model.StudentModel;
import com.mylearning.firstproject.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudentData(){
        return studentRepository.findAll();

    }
}
