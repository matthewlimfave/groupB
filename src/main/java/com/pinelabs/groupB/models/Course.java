package com.pinelabs.groupB.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

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
}
