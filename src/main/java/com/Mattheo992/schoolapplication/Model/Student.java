package com.Mattheo992.schoolapplication.Model;

import lombok.Data;

@Data
public class Student {
    private Long id;
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private String birthday;
    private String pesel;
    private String sex;
}
