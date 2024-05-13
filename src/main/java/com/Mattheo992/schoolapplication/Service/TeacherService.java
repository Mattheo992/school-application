package com.Mattheo992.schoolapplication.Service;

import com.Mattheo992.schoolapplication.Model.Student;
import com.Mattheo992.schoolapplication.Model.Teacher;
import com.Mattheo992.schoolapplication.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public List<Teacher> getTeachers() {
        return teacherRepository.getTeachers();
    }
    public List<Teacher> getTeachersBySex(String sex){
        return teacherRepository.getTeachersBySex(sex);
    }

    public Teacher getTeacherById(Long id) {
        return teacherRepository.getTeacherById(id).orElse(null);
    }

    public void createTeacher (Teacher teacher) {
        teacherRepository.createTeacher(teacher);
    }

    public void deleteTeacher(Long id) {
        teacherRepository.deleteTeacher(id);
    }

    public void editTeacher(Long id, Teacher newTeacher) {
      teacherRepository.editTeacher(id, newTeacher);
    }

    public void editTeacherPhoneNumber(Long id, String newPhoneNumber) {
        teacherRepository.editTeacherPhoneNumber(id, newPhoneNumber);
    }
}
