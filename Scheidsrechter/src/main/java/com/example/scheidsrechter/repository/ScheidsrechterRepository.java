package com.example.scheidsrechter.repository;

import com.example.scheidsrechter.model.Scheidsrechter;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface ScheidsrechterRepository extends JpaRepository<Scheidsrechter, Long> {
    List<Scheidsrechter> findScheidsrechterBySkuCodeIn(List<String> skuCode);

    Scheidsrechter findScheidsrechterBySkuCode(String skuCode);
}