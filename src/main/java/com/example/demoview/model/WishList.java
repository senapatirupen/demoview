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
public class WishList extends AuditLog {
    private static final long serialVersionUID=1L;
    private Long wiId;
    private String wishListStatus;
    private Collection<Product> products;
}
