package com.mylearning.firstproject.Service;

import com.mylearning.firstproject.Entity.Student;
import com.mylearning.firstproject.Entity.StudentMarksProjection;
import com.mylearning.firstproject.Model.StudentModel;
import com.mylearning.firstproject.Repository.StudentRepository;
import com.mylearning.firstproject.dto.StudentMarksDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
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

//For Interface projection
//    public List<StudentMarksProjection> getMarks(){

        // return studentRepository.getStudentMarks();

        public List<StudentMarksDTO> getMarks(){

        List<Object[]> data = studentRepository.getStudentMarks();
        List<StudentMarksDTO> studentMarksDTOList = new ArrayList<>();

        for(Object [] s : data){
            StudentMarksDTO studentMarksDTO = new StudentMarksDTO(
            (String) s[0],
            (String) s[1],
            (BigDecimal) s[2],
            (BigDecimal) s[3],
            (BigDecimal) s[4]
            );
            studentMarksDTOList.add(studentMarksDTO);
        }
        return studentMarksDTOList;
    }
}
