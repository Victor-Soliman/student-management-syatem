package com.myprojects.studentmanagementsyatem.repository;

import com.myprojects.studentmanagementsyatem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository  // tou don't need to add this annotation because the JpaRepository has a class Simple.. that has it
public interface StudentRepository extends JpaRepository<Student,Long> {


}
