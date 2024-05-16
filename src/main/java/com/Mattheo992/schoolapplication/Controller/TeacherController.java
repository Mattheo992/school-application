package com.Mattheo992.schoolapplication.Controller;

import com.Mattheo992.schoolapplication.Model.Sex;
import com.Mattheo992.schoolapplication.Model.Student;
import com.Mattheo992.schoolapplication.Model.Teacher;
import com.Mattheo992.schoolapplication.Service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.Mattheo992.schoolapplication.Model.Sex;

import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("/teachers")
@RequiredArgsConstructor
@RestController
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping
    public List<Teacher> getTeachers(@RequestParam(required = false) Sex sex) {
        return teacherService.getTeachers(sex);
    }

    @GetMapping("{id}")
    public Teacher getTeacherById(@PathVariable Long id) {
        return teacherService.getTeacherById(id);
    }

    @PostMapping
    public Teacher createTeacher(@RequestBody Teacher teacher) {
        return teacherService.createTeacher(teacher);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable("id") Long id) {
        teacherService.deleteTeacher(id);
    }

    @PutMapping("/{id}")
    public Teacher editTeacher(@PathVariable("id") Long id, @RequestBody Teacher newTeacher) {
        return teacherService.editTeacher(id, newTeacher);
    }

    @PatchMapping("/{id}/number")
    public Teacher editTeacherPhoneNumber(@PathVariable Long id, @RequestBody Teacher newTeacher) {
        return teacherService.editTeacherPhoneNumber(id, newTeacher);
    }

    @PatchMapping("/{id}/birthday")
    public Teacher editTeacherBirthday(@PathVariable Long id, @RequestBody Teacher newTeacher) {
        return teacherService.editTeacherBirthday(id, newTeacher);
    }
}