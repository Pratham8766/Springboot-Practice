package com.mylearning.firstproject.Repository;

import com.mylearning.firstproject.Entity.Student;
import com.sun.org.glassfish.gmbal.ManagedData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
//    @Query(value = "SELECT s FROM student s WHERE s.id >= 3 and s.email='rahul.mehta@example.com';")
    @Query(value = "SELECT * FROM student WHERE roll_no=:roll_no", nativeQuery = true)
    Student getSpecificStudent(@Param("roll_no") int roll_no);

    @Modifying
    @Query(value = "UPDATE student SET name=:name WHERE roll_no=:roll_no", nativeQuery = true)
    void updatedSpecificStudentName(@Param("name") String name, @Param("roll_no") int roll_no);

    @Modifying
    @Query(value = "DELETE FROM student WHERE roll_no=:roll_no", nativeQuery = true)
    void deleteStudent(@Param("roll_no") int roll_no);
}
