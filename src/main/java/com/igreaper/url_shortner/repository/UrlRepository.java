package com.igreaper.url_shortner.repository;

import com.igreaper.url_shortner.entities.UrlEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UrlRepository extends MongoRepository<UrlEntity,String> {

}
