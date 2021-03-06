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
public class Shipping extends AuditLog {
    private static final long serialVersionUID = 1L;
    private Long shId;
    private String prIds;
    private Long odId;
    private String shippingStatus;
    private String productHealthStatus;
    private Float packagingCharge;
    private Date startDate;
    private Date endDate;
    private Date expectedDate;
    private String courierPerson;
    private ShippingAddress shippingAddress;
    private Delivery delivery;
    private ReturnProduct areturn;
}
