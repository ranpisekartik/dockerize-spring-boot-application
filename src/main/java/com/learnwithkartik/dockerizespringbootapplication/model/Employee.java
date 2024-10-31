package com.learnwithkartik.dockerizespringbootapplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@ToString
@Document("Employee")
public class Employee {

    @Id
    private String id;
    private String name;


}
