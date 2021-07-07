package com.example.demoview.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Person extends AuditLog {
    private static final long serialVersionUID=1L;
    private Long peId;
    @JsonIgnore
    private UserDetail userDetail;
    @JsonIgnore
    private Cart cart;
    private Collection<Product> products;
    private Collection<Order> orders;
    private Collection<Address> addresses;
}
