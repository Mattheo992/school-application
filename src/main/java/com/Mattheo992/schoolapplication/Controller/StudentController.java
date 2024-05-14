package com.Mattheo992.schoolapplication.Controller;

import com.Mattheo992.schoolapplication.Model.Student;
import com.Mattheo992.schoolapplication.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @GetMapping("/id/{id}")
    public Optional<Student> getStudent(@PathVariable Long id) {
         return studentService.getStudentById(id);
    }

    @GetMapping("/{lastName}")
    public List<Student> getStudentsByLastName(@RequestParam String lastName) {
        return studentService.getStudentsWithTheSameLastName(lastName);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    @PutMapping("/{id}")
    public void editStudent(@PathVariable Long id, @RequestBody Student newStudent) {
        studentService.editStudent(id, newStudent);
    }

    @PatchMapping("/{id}")
    public void editStudentPhoneNumber(@PathVariable Long id, @RequestBody String phoneNumber) {
        studentService.editStudentPhoneNumber(id, phoneNumber);
    }
}
