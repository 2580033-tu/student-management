package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Student;

@Controller
public class StudentController {

    private List<Student> students = new ArrayList<>();
    private int nextId = 4;
    public StudentController() {

        students.add(new Student(1, "minh anh", 20, "minhanh@gmail.com"));
        students.add(new Student(2, "phong", 21, "phong@gmail.com"));
        students.add(new Student(3, "nam", 22, "nam@gmail.com"));

    }

    @GetMapping("/students")
    public String showStudents(Model model) {

        model.addAttribute("students", students);

        return "students";
    }

    @GetMapping("/add-student")
    public String addStudentForm() {

        return "add-student";
    }

    @PostMapping("/students/add")
    public String addStudent(Student student) {

        student.setId(nextId);
        nextId++;

        students.add(student);

        return "redirect:/students";
    }
}