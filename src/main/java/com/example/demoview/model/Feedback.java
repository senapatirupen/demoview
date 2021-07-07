package com.example.demoview.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Feedback extends AuditLog {
    private static final long serialVersionUID=1L;
    private Long feId;
    private String orIds;
    private Long prId;
    private String rating;
    private String review;
    private String feedback;
}
