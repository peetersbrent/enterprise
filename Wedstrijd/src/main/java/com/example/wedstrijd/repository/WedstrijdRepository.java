package com.example.wedstrijd.repository;

import com.example.wedstrijd.model.Wedstrijd;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface WedstrijdRepository extends JpaRepository<Wedstrijd, Long> {
    List<Wedstrijd> findWedstrijdBySkuCodeIn(List<String> skuCode);

    Wedstrijd findWedstrijdBySkuCode(String skuCode);
}
