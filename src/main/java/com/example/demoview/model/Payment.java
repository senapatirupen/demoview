package com.example.demoview.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Payment extends AuditLog {
    private static final long serialVersionUID=1L;
    private Long paId;
    private Long odId;
    private String name;
    private Float price;
    private Float offerPercentage;
    private String paymentStatus;
    private String type;
}
