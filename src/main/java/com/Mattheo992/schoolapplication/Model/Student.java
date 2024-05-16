package com.Mattheo992.schoolapplication.Model;

import lombok.Data;

import java.time.LocalDate;


@Data
public class Student {
    private Long id;
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private String pesel;
    private Sex sex;
}
