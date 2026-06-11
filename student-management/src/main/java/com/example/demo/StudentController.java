package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Student;
import org.springframework.web.bind.annotation.PathVariable;
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
    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable int id) {

        students.removeIf(student -> student.getId() == id);

        return "redirect:/students";
    }
    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable int id, Model model) {

        for (Student student : students) {

            if (student.getId() == id) {

                model.addAttribute("student", student);

                return "edit-student";
            }
        }

        return "redirect:/students";
    }
    @PostMapping("/students/add")
    public String addStudent(Student student) {

        student.setId(nextId);
        nextId++;

        students.add(student);

        return "redirect:/students";
    }
}