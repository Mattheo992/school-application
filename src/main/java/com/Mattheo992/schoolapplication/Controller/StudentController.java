package com.Mattheo992.schoolapplication.Controller;

import com.Mattheo992.schoolapplication.Model.Sex;
import com.Mattheo992.schoolapplication.Model.Student;
import com.Mattheo992.schoolapplication.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<Student> getStudents(@RequestParam(required = false) String lastName) {
        return studentService.getStudents(lastName);
    }

    @GetMapping("{id}")
    public Student getStudent(@PathVariable("id") Long id) {
        return studentService.getStudentById(id);
    }


    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    @PutMapping("/{id}")
    public Student editStudent(@PathVariable("id") Long id, @RequestBody Student newStudent) {
        return studentService.editStudent(id, newStudent);
    }

    @PatchMapping("/{id}/number")
    public Student editStudentPhoneNumber(@PathVariable("id") Long id, @RequestBody Student newStudent) {
        return studentService.editStudentPhoneNumber(id, newStudent);
    }

    @PatchMapping("{id}/birthday")
    public Student editStudentBirthday(@PathVariable("id") Long id, @RequestBody Student newStudent) {
        return studentService.editStudentBirthday(id, newStudent);
    }
}