package com.example.demoview.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product extends AuditLog {
    private static final long serialVersionUID=1L;
    private Long prId;
    private Long odId;
    private Long caId;
    private Long peId;
    private String name;
    private String model;
    private Float MRP;
    private Float sellPrice;
    private Float discountOnMRP;
    private String productStatus;
    private Feedback feedback;
    private Boolean isStockAvailable;
}
