package com.example.demoview.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReturnProduct extends AuditLog {
    private static final long serialVersionUID=1L;
    private Long reId;
    private String prIds;
    private Long shId;
    private Date startDate;
    private Date endDate;
    private Date expectedDate;
    private String returnStatus;
    private Boolean isReturned;
    private ReturnAddress returnAddress;
}
