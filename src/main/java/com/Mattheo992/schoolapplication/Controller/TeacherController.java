package com.Mattheo992.schoolapplication.Controller;

import com.Mattheo992.schoolapplication.Model.Sex;
import com.Mattheo992.schoolapplication.Model.Student;
import com.Mattheo992.schoolapplication.Model.Teacher;
import com.Mattheo992.schoolapplication.Service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    public Teacher getTeacherById(@RequestParam Long id) {
        return teacherService.getTeacherById(id);
    }

    @GetMapping("/{sex}")
    public List<Teacher> getTeachersBySex(@RequestParam Sex sex) {
        return teacherService.getTeachersBySex(sex);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping
    public Teacher createTeacher(@RequestBody Teacher teacher) {
        return teacherService.createTeacher(teacher);
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
