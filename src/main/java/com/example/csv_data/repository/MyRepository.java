package com.example.csv_data.repository;

import com.example.csv_data.model.Model;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyRepository extends MongoRepository<Model,String> {
}
