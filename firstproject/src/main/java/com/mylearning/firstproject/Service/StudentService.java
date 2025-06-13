package com.mylearning.firstproject.Service;

import com.mylearning.firstproject.Entity.Student;
import com.mylearning.firstproject.Model.StudentModel;
import com.mylearning.firstproject.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public Student getSpecificStudent(int roll_no){
        return studentRepository.getSpecificStudent(roll_no);
    }
    public Student postStudent(Student student){
        return studentRepository.save(student);
    }

    @Transactional
    public void updateStudentName(int roll_no, String name){
        studentRepository.updatedSpecificStudentName(name, roll_no);
    }

    @Transactional
    public void deleteStudent(int roll_no){
        studentRepository.deleteStudent(roll_no);
    }
}
