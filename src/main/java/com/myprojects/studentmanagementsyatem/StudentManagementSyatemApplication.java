package com.myprojects.studentmanagementsyatem;

import com.myprojects.studentmanagementsyatem.entity.Student;
import com.myprojects.studentmanagementsyatem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentManagementSyatemApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(StudentManagementSyatemApplication.class, args);
    }

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {
//        Student student1 = new Student("Marcel", "Popovici", "marcel@gmail.com");
//        studentRepository.save(student1);
//        Student student2 = new Student("Marian", "Ionescu", "marian@gmail.com");
//        studentRepository.save(student2);
//        Student student3 = new Student("Andrei", "Vasilescu", "andrei@gmail.com");
//        studentRepository.save(student3);
    }
}
