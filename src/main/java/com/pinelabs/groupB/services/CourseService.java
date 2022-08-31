package com.pinelabs.groupB.services;

import com.pinelabs.groupB.repositories.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassService {

    @Autowired
    private ClassRepository classRepository;

    public void addClass (Class _class) {

    }
}
