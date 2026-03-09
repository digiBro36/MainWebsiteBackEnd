package com.digitalmarketing.repository;

import com.digitalmarketing.model.Lead;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeadRepository extends MongoRepository<Lead, String> {
}
