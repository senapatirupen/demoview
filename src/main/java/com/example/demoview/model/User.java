package com.example.demoview.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends AuditLog {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String admin;
}
