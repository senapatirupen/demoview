package com.example.demoview.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Poll implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String question;
    private List<Opt> opts;

    public List<Opt> getDefaultOptions() {
        if (this.opts == null) {
            this.opts = new ArrayList<Opt>();
        }
        return this.opts;
    }
}
