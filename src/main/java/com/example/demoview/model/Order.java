package com.example.demoview.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Order extends AuditLog {
    private static final long serialVersionUID=1L;
    private Long odId;
    private Long peId;
    private String orderStatus;
    private Boolean isDelivered;
    private Date startDate;
    private Date endDate;
    private Date expectedDate;
    private Collection<Product> products;
    private Collection<Shipping> shipping;
    @JsonIgnore
    private Payment payment;
    @JsonIgnore
    private BillingAddress billingAddress;
}
