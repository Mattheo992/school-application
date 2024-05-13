package com.Mattheo992.schoolapplication.Service;

import com.Mattheo992.schoolapplication.Model.Student;
import com.Mattheo992.schoolapplication.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> getStudents() {
        return studentRepository.getStudents();
    }

    public Student getStudentById(Long id) {
        return studentRepository.getStudentById(id).orElse(null);
    }

    public List<Student> getStudentsWithTheSameLastName(String lastName) {
        return studentRepository.getStudentsWithTheSameLastName(lastName);
    }

    public void createStudent(Student student) {
        studentRepository.createStudent(student);
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
