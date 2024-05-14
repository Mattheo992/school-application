package com.Mattheo992.schoolapplication.Service;

import com.Mattheo992.schoolapplication.Model.Student;
import com.Mattheo992.schoolapplication.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> getStudents() {
        return studentRepository.getStudents();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.getStudentById(id);
    }

    public List<Student> getStudentsWithTheSameLastName(String lastName) {
        return studentRepository.getStudentsWithTheSameLastName(lastName);
    }

    public Student createStudent(Student student) {
        return studentRepository.createStudent(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteStudent(id);
    }

    public void editStudent(Long id, Student newStudent) {
        studentRepository.editStudent(id, newStudent);
    }

    public void editStudentPhoneNumber(Long id, String phoneNumber) {
        studentRepository.editStudentPhoneNumber(id, phoneNumber);
    }
}
