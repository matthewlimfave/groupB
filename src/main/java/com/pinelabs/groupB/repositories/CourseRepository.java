package com.pinelabs.groupB.repositories;

import com.pinelabs.groupB.models.Class;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClassRepository extends MongoRepository<Class, Integer> {
}
