package com.pinelabs.groupB.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Document
public class Course {

    @Transient
    public static final String SEQUENCE_NAME = "course_sequence";

    @Id
    private long id;
    private String name;
    private String status;
    private LocalDateTime createdOn;
    private LocalDateTime modifiedOn;
    @DocumentReference(lazy = true, lookup = "{ 'id' : ?#{#target} }")
    @ReadOnlyProperty
    private List<Student> students;

}
