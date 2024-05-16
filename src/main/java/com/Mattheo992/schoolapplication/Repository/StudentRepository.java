package com.Mattheo992.schoolapplication.Repository;

import com.Mattheo992.schoolapplication.Model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {
    private List<Student> students = new ArrayList<>();

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }

    public Optional<Student> getStudentById(Long id) {
        return students.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst();
    }

    public List<Student> getStudents(String lastName) {
        return students.stream()
                .filter(student -> student.getLastName() != null && student.getLastName().equalsIgnoreCase(lastName))
                .toList();
    }

    public Student createStudent(Student student) {
        students.add(student);
        return student;
    }

    public void deleteStudent(Long id) {
        Student student = getStudentById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student with given id does not exist!"));
        students.remove(student);
    }

    public Student editStudent(Long id, Student newStudent) {
        Student student = getStudentById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student with given id does not exist"));
        student.setId(newStudent.getId());
        student.setPhoneNumber(newStudent.getPhoneNumber());
        student.setFirstName(newStudent.getFirstName());
        student.setLastName(newStudent.getLastName());
        student.setBirthday(newStudent.getBirthday());
        student.setPesel(newStudent.getPesel());
        student.setSex(newStudent.getSex());
        return student;
    }


    public Student editStudentPhoneNumber(Long id, Student newStudent) {
        Student student = getStudentById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student with given id does not exist"));
        student.setPhoneNumber(newStudent.getPhoneNumber());
        return student;
    }

    public Student editStudentBirthday(Long id, Student newStudent) {
        Student student = getStudentById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student with given id does not exist!"));
        student.setBirthday(newStudent.getBirthday());
        return student;
    }
}