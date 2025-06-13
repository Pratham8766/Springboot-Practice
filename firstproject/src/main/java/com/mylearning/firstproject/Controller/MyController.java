package com.mylearning.firstproject.Controller;

import com.mylearning.firstproject.Builder.ResponseWrapper;
import com.mylearning.firstproject.Entity.Student;
import com.mylearning.firstproject.Model.StudentModel;
import com.mylearning.firstproject.Service.StudentService;
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
    private StudentService studentService;

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

    @GetMapping("/getStudentDataById")
    public ResponseWrapper<Object> getStudentById(@RequestParam String id1){
         return ResponseWrapper.builder()
                 .id(STUDENT_DATA_BY_ID)
                 .type("Getting student data by Id")
                 .attributes(data.get(Long.parseLong(id1)))
                 .build();
    }

    @PostMapping("/setStudentData")
    public ResponseWrapper<Object> setStudentData(@RequestBody StudentModel student){
        data.put(Long.parseLong(student.getId()), student);
        return ResponseWrapper.builder()
                .id(STUDENT_DATA)
                .type("Getting student list")
                .attributes(data)
                .build();
    }

    @PutMapping("/updateName/{id}/{name}")
    public ResponseWrapper<Object> updateStudentName(@PathVariable String id, @PathVariable String name){
        StudentModel s = data.get(Long.parseLong(id));
        s.setName(name);
        data.put(Long.parseLong(id), s);
        return ResponseWrapper.builder()
                .id(STUDENT_DATA)
                .type("Getting student list")
                .attributes(s)
                .build();
    }

    @DeleteMapping("/deleteStudent")
    public void deleteStudentData(@RequestParam String id){
        data.remove(Long.parseLong(id));
    }

    @GetMapping("/teachers")
    public ResponseWrapper<Object> getTeachers(){
        return ResponseWrapper.builder()
                .id("12")
                .type("Teachers")
                .code(ResponseEntity.status(HttpStatus.OK).toString())
                .attributes(data)
                .build()
                ;
    }
}