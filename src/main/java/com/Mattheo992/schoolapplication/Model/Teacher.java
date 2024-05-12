package com.Mattheo992.schoolapplication.Model;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class Teacher {
    private Long id;
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private String birthday;
    private String pesel;
    private String sex;
    private BigDecimal salary;
}
