package com.example.competitie.repository;

import com.example.competitie.model.Competitie;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CompetitieRepository extends MongoRepository<Competitie, String> {
    List<Competitie> findBySkuCodeIn(List<String> skuCode);

    Competitie findBySkuCode(String skuCode);
}
