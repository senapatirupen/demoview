package com.example.demoview.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuditLog implements Serializable {
    private static final long serialVersionUID = 1L;
    protected String createdBy;
    protected Date createdDate;
    protected String lastModifiedBy;
    protected Date lastModifiedDate;
    protected Boolean isActive;
    protected String status;
}
