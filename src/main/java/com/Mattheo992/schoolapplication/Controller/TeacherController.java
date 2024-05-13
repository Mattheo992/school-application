package com.Mattheo992.schoolapplication.Controller;

import com.Mattheo992.schoolapplication.Model.Student;
import com.Mattheo992.schoolapplication.Model.Teacher;
import com.Mattheo992.schoolapplication.Service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/teachers")
@RequiredArgsConstructor
@RestController
public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping
    public List<Teacher> getTeachers() {
        return teacherService.getTeachers();
    }

    @GetMapping("/id/{id}")
    public Teacher getTeacherById(@PathVariable Long id) {
        return teacherService.getTeacherById(id);
    }

    @GetMapping("/{sex}")
    public List<Teacher> getTeachersBySex(@PathVariable String sex){
        return teacherService.getTeachersBySex(sex);
    }

    @PostMapping
    public void createTeacher (@RequestBody Teacher teacher) {
        teacherService.createTeacher(teacher);
    }

    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
    }

    @PutMapping("/{id}")
    public void editTeacher(@PathVariable Long id, @RequestBody Teacher newTeacher) {
        teacherService.editTeacher(id, newTeacher);
    }

    @PatchMapping("/{id}")
    public void editTeacherPhoneNumber(@PathVariable Long id, @RequestBody String newPhoneNumber) {
        teacherService.editTeacherPhoneNumber(id, newPhoneNumber);
    }
}