package com.Mattheo992.schoolapplication.Repository;

import com.Mattheo992.schoolapplication.Model.Sex;
import com.Mattheo992.schoolapplication.Model.Student;
import com.Mattheo992.schoolapplication.Model.Teacher;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class TeacherRepository {
    private List<Teacher> teachers = new ArrayList<>();

    public List<Teacher> getTeachers() {
        return new ArrayList<>(teachers);
    }

    public List<Teacher> getTeachersBySex(Enum sex) {
        return teachers.stream()
                .filter(teacher -> teacher.getSex() != null && teacher.getSex().equals(sex))
                .toList();
    }

    public Optional<Teacher> getTeacherById(Long id) {
        return teachers.stream()
                .filter(teacher -> teacher.getId().equals(id))
                .findFirst();
    }

    public Teacher createTeacher(Teacher teacher) {
        teachers.add(teacher);
        return teacher;
    }

    public void deleteTeacher(Long id) {
        Teacher teacher = getTeacherById(id)
                .orElseThrow(() -> new IllegalArgumentException("Teacher with given id does not exist"));
        teachers.remove(teacher);
    }

    public Teacher editTeacher(Long id, Teacher newTeacher) {
        Teacher teacher = getTeacherById(id)
                .orElseThrow(() -> new IllegalArgumentException("Teacher with given id does not exist"));
        teacher.setPhoneNumber(newTeacher.getPhoneNumber());
        teacher.setFirstName(newTeacher.getFirstName());
        teacher.setLastName(newTeacher.getLastName());
        teacher.setBirthday(newTeacher.getBirthday());
        teacher.setPesel(newTeacher.getPesel());
        teacher.setSex(newTeacher.getSex());
        teacher.setSalary(newTeacher.getSalary());
        return teacher;
    }

    public Teacher editTeacherPhoneNumber(Long id, Teacher newTeacher) {
        Teacher teacher = getTeacherById(id)
                .orElseThrow(() -> new IllegalArgumentException("Teacher with given id does not exist"));

        teacher.setPhoneNumber(newTeacher.getPhoneNumber());
        return teacher;
    }


    public Teacher editTeacherBirthday(Long id, Teacher newTeacher) {
        Teacher teacher = getTeacherById(id)
                .orElseThrow(() -> new IllegalArgumentException("Teacher with given id does not exist"));

        teacher.setBirthday(newTeacher.getBirthday());
        return teacher;
    }
}