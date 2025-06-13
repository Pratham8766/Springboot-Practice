package com.mylearning.firstproject.Repository;

import com.mylearning.firstproject.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
