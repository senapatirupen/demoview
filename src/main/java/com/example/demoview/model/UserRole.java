package com.example.demoview.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRole extends AuditLog {
    private static final long serialVersionUID = 1L;
    private Long urId;
    private String role;
}
