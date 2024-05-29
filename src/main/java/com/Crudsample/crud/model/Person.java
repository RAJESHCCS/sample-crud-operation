package com.Crudsample.crud.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityScan
public class Person {
    private int person_id;
    private String person_name;
    private  String person_location;


}
