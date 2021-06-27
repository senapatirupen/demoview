package com.example.demoview.model;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetail extends AuditLog {
    private Long usId;
    private String firstName;
    private String lastName;
    private String username;
    private String emailId;
    private String phoneNumber;
    private String password;
    private String rePassword;
    private String dob;
    private LocalDateTime createDate;
}
