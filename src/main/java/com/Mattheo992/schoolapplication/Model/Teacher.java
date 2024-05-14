package com.Mattheo992.schoolapplication.Model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Teacher {
    private Long id;
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private LocalDateTime birthday;
    private String pesel;
    private Sex sex;
    private BigDecimal salary;
}
