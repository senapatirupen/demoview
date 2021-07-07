package com.example.demoview.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Cart extends AuditLog {
    private static final long serialVersionUID = 1L;
    private Long caId;
    private String cartStatus;
    private Long peId;
    private Collection<Product> products;
}
