package com.pinelabs.groupB.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor

@Document
public class Course {

    @Id
    private int id;
    private String name;
    private String status;
    private LocalDateTime createdOn;
    private LocalDateTime modifiedOn;
    @DocumentReference(lazy = true)
    private List<Student> students;

}
