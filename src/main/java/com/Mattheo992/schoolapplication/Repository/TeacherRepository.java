package com.Mattheo992.schoolapplication.Repository;

import com.Mattheo992.schoolapplication.Model.Sex;
import com.Mattheo992.schoolapplication.Model.Student;
import com.Mattheo992.schoolapplication.Model.Teacher;
import org.springframework.stereotype.Repository;

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

    public List<Teacher> getTeachersBySex(Sex sex) {
        return teachers.stream()
                .filter(teacher -> sex.equals(teacher.getSex()))
                .collect(Collectors.toList());
    }

    public Optional<Teacher> getTeacherById(Long id) {
        return teachers.stream()
                .filter(teacher -> id.equals(teacher.getId()))
                .findFirst();
    }

    public Teacher createTeacher(Teacher teacher) {
        teachers.add(teacher);
        return teacher;
    }

    public void deleteTeacher(Long id) {
        teachers.removeIf(teacher -> id.equals(teacher.getId()));
    }

    public void editTeacher(Long id, Teacher newTeacher) {
        Optional<Teacher> editedTeacher = getTeacherById(id);
        if (editedTeacher.isPresent()) {
            Teacher teacherToUpdate = editedTeacher.get();
            teacherToUpdate.setPhoneNumber(newTeacher.getPhoneNumber());
            teacherToUpdate.setFirstName(newTeacher.getFirstName());
            teacherToUpdate.setLastName(newTeacher.getLastName());
            teacherToUpdate.setBirthday(newTeacher.getBirthday());
            teacherToUpdate.setPesel(newTeacher.getPesel());
            teacherToUpdate.setSex(newTeacher.getSex());
            teacherToUpdate.setSalary(newTeacher.getSalary());
        }
    }

    public void editTeacherPhoneNumber(Long id, String newPhoneNumber) {
        Optional<Teacher> editedTeacher = getTeacherById(id);
        if (editedTeacher.isPresent()) {
            Teacher teacherToUpdate = editedTeacher.get();
            teacherToUpdate.setPhoneNumber(newPhoneNumber);
        }
    }
}