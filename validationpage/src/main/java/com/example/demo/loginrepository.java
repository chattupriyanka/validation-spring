package com.example.demo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface loginrepository extends MongoRepository<Login, String> {


} 
//package com.example.demo;
//import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface validationRepository extends MongoRepository<validatepojo, String> {
//
//
//} 
