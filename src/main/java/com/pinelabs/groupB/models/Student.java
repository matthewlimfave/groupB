package com.pinelabs.groupB.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor

@Document
public class Student {

    @Id
    private int id;
    private String name;
    private String status;
    private byte age;
    private String address;
    private LocalDateTime createdOn;
    private LocalDateTime modifiedOn;
}
