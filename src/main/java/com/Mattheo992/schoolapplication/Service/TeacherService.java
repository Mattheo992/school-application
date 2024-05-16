package com.Mattheo992.schoolapplication.Service;

import com.Mattheo992.schoolapplication.Model.Sex;
import com.Mattheo992.schoolapplication.Model.Student;
import com.Mattheo992.schoolapplication.Model.Teacher;
import com.Mattheo992.schoolapplication.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public List<Teacher> getTeachers(Sex sex) {
        return Optional.ofNullable(sex)
                .map(teacherRepository::getTeachersBySex)
                .orElseGet(teacherRepository::getTeachers);
    }


    public Teacher getTeacherById(Long id) {
        return teacherRepository.getTeacherById(id)
                .orElseThrow(() -> new IllegalArgumentException("Teacher with given id does not exist!"));
    }

    public Teacher createTeacher(Teacher teacher) {
        checkIfIdIsAvailable(teacher.getId());
        return teacherRepository.createTeacher(teacher);
    }

    public void deleteTeacher(Long id) {
        teacherRepository.deleteTeacher(id);
    }

    public Teacher editTeacher(Long id, Teacher newTeacher) {
       return teacherRepository.editTeacher(id, newTeacher);
    }

    public Teacher editTeacherPhoneNumber(Long id, Teacher newTeacher) {
      return  teacherRepository.editTeacherPhoneNumber(id, newTeacher);
    }

    public Teacher editTeacherBirthday(Long id, Teacher newTeacher) {
        return teacherRepository.editTeacherBirthday(id, newTeacher);
    }

    private void checkIfIdIsAvailable(Long id) {
        if (teacherRepository.getTeacherById(id).isPresent())
            throw new IllegalArgumentException("Teacher with given id already exist!");
    }
}