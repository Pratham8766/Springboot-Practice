package com.mylearning.firstproject.Controller;

import com.mylearning.firstproject.Builder.ResponseWrapper;
import com.mylearning.firstproject.Entity.Student;
import com.mylearning.firstproject.Entity.StudentMarksProjection;
import com.mylearning.firstproject.Model.StudentModel;
import com.mylearning.firstproject.Service.StudentService;
import com.mylearning.firstproject.dto.StudentMarksDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.mylearning.firstproject.constants.StudentConstants.STUDENT_DATA;
import static com.mylearning.firstproject.constants.StudentConstants.STUDENT_DATA_BY_ID;

@RestController
@RequestMapping("/student")
public class MyController {
    
    @Autowired
    private final StudentService studentService;

    public MyController(StudentService studentService){
        this.studentService = studentService;
    }

    public Map<Long, StudentModel> data = new HashMap<>();

    @GetMapping("/getStudentData")
    public ResponseWrapper<Object> getStudentData(){
        List<Student> mylist = studentService.getStudentData();
        return ResponseWrapper.builder()
                .id(STUDENT_DATA)
                .type("Getting student list")
                .attributes(mylist)
                .build();
    }

    @GetMapping("/getSpecificStudent/{roll_no}")
    public ResponseWrapper<Object> getSpecificStudent(@PathVariable String roll_no){
        Student specificStudent = studentService.getSpecificStudent(Integer.parseInt(roll_no));
         return ResponseWrapper.builder()
                 .id(STUDENT_DATA_BY_ID)
                 .type("Getting student data by Id")
                 .attributes(specificStudent)
                 .code(HttpStatus.OK.toString())
                 .build();
    }

    @PostMapping("/setStudentData")
    public ResponseWrapper<Object> setStudentData(@RequestBody Student student){
        Student s = studentService.postStudent(student);
        return ResponseWrapper.builder()
                .id(STUDENT_DATA)
                .type("Getting student list")
                .attributes(data)
                .code(HttpStatus.OK.toString())
                .build();
    }

    @PutMapping("/updateName/{roll_no}/{name}")
    public ResponseWrapper<Object> updateStudentName(@PathVariable String roll_no, @PathVariable String name){
       studentService.updateStudentName(Integer.parseInt(roll_no), name);
        return ResponseWrapper.builder()
                .id(STUDENT_DATA)
                .type("Updated StudentName")
                .attributes("Student Name updated")
                .code(HttpStatus.OK.toString())
                .build();
    }

    @DeleteMapping("/deleteStudent")
    public ResponseWrapper<Object> deleteStudentData(@RequestParam String rollNo){
        studentService.deleteStudent(Integer.parseInt(rollNo));
        return ResponseWrapper.builder()
                .id(STUDENT_DATA)
                .type("Updated StudentName")
                .attributes("Student Deleted")
                .code(HttpStatus.OK.toString())
                .build();
    }

    @GetMapping("/marks")
    public ResponseWrapper<Object> getMarks(){
//        List<StudentMarksProjection> marks = studentService.getMarks();
        List<StudentMarksDTO> marks = studentService.getMarks();

        return ResponseWrapper.builder()
                .id("12")
                .type("Teachers")
                .code(ResponseEntity.status(HttpStatus.OK).toString())
                .attributes(marks)
                .build()
                ;
    }
}