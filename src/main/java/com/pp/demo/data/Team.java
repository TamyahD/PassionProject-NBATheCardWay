package com.pp.demo.data;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Embeddable;

@Data
@AllArgsConstructor
@Embeddable
public class Team {
    private Integer id;
    private String abbreviation;
    private String city;
    private String conference;
    private String division;
    private String full_name;
    private String name;

    public Team() {}
}
