package com.Mattheo992.schoolapplication.Repository;

import com.Mattheo992.schoolapplication.Model.Student;
import org.springframework.stereotype.Repository;

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
                .filter(student -> id.equals(student.getId()))
                .findFirst();
    }

    public List<Student> getStudentsWithTheSameLastName(String lastName) {
        return students.stream()
                .filter(student -> lastName.equals(student.getLastName()))
                .collect(Collectors.toList());
    }

    public Student createStudent(Student student) {
        students.add(student);
        return student;
    }

    public void deleteStudent(Long id) {
        students.removeIf(student -> id.equals(student.getId()));
    }

    public void editStudent(Long id, Student newStudent) {
        Optional<Student> editedStudent = getStudentById(id);
        if (editedStudent.isPresent()) {
            Student studentToUpdate = editedStudent.get();
            studentToUpdate.setPhoneNumber(newStudent.getPhoneNumber());
            studentToUpdate.setFirstName(newStudent.getFirstName());
            studentToUpdate.setLastName(newStudent.getLastName());
            studentToUpdate.setBirthday(newStudent.getBirthday());
            studentToUpdate.setPesel(newStudent.getPesel());
            studentToUpdate.setSex(newStudent.getSex());
        }
    }

    public void editStudentPhoneNumber(Long id, String newPhoneNumber) {
        Optional<Student> editedStudent = getStudentById(id);
        if (editedStudent.isPresent()) {
            Student studentToUpdate = editedStudent.get();
            studentToUpdate.setPhoneNumber(newPhoneNumber);
        }
    }
}
