package com.Mattheo992.schoolapplication.Service;

import com.Mattheo992.schoolapplication.Model.Student;
import com.Mattheo992.schoolapplication.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> getStudents(String lastName) {
        return Optional.ofNullable(lastName)
                .map(studentRepository::getStudents)
                .orElseGet(studentRepository::getStudents);
    }

    public Student getStudentById(Long id) {
        return studentRepository.getStudentById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student with given email does not exist."));
    }

    public Student createStudent(Student student) {
        checkIfIdlIsAvailable(student.getId());
        return studentRepository.createStudent(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteStudent(id);
    }

    public Student editStudent(Long id, Student newStudent) {
        return studentRepository.editStudent(id, newStudent);
    }

    public Student editStudentPhoneNumber(Long id, Student newStudent) {
        return studentRepository.editStudentPhoneNumber(id, newStudent);
    }

    public Student editStudentBirthday(Long id, Student newStudent) {
        return studentRepository.editStudentBirthday(id, newStudent);
    }

    private void checkIfIdlIsAvailable(Long id) {
        if (studentRepository.getStudentById(id).isPresent()) {
            throw new IllegalArgumentException("Student with given id already exists");
        }
    }
}
