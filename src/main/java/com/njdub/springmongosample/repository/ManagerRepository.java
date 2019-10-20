package com.njdub.springmongosample.repository;

import com.njdub.springmongosample.domain.Manager;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;

public interface ManagerRepository extends MongoRepository<Manager, BigInteger> {

}