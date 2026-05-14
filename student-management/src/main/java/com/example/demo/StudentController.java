package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.Student;

@Controller
public class StudentController {

    @GetMapping("/students")
    public String showStudents(Model model) {

        List<Student> students = new ArrayList<>();

        students.add(new Student(1, "minh anh", 20, "minhanh@gmail.com"));
        students.add(new Student(2, "phong", 21, "phong@gmail.com"));
        students.add(new Student(3, "nam", 22, "nam@gmail.com"));

        model.addAttribute("students", students);

        return "students";
    }
    @GetMapping("/add-student")
    public String addStudentForm() {
    	
        return "add-student";
    }
    @PostMapping("/students/add")
    public String addStudent(Student student) {

        System.out.println(student.getName());
        System.out.println(student.getAge());
        System.out.println(student.getEmail());

        return "redirect:/students";
    }
}