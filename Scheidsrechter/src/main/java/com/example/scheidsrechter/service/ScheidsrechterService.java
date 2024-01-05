package com.example.scheidsrechter.service;

import com.example.scheidsrechter.dto.ScheidsrechterRequest;
import com.example.scheidsrechter.dto.ScheidsrechterResponse;
import com.example.scheidsrechter.model.Scheidsrechter;
import com.example.scheidsrechter.repository.ScheidsrechterRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ScheidsrechterService {
    private final ScheidsrechterRepository scheidsrechterRepository;

    public void createScheidsrechter(ScheidsrechterRequest scheidsrechterRequest) {
        Scheidsrechter scheidsrechter = Scheidsrechter.builder()
                .skuCode(scheidsrechterRequest.getSkuCode())
                .naam(scheidsrechterRequest.getNaam())
                .mail(scheidsrechterRequest.getMail())
                .geboortedatum(scheidsrechterRequest.getGeboortedatum())
                .niveau(scheidsrechterRequest.getNiveau())
                .isAssistent(scheidsrechterRequest.getIsAssistent())
                .scheidsrechterID(scheidsrechterRequest.getScheidsrechterID()).build();
        this.scheidsrechterRepository.save(scheidsrechter);
    }

    public List<ScheidsrechterResponse> get(List<String> skuCode) {
        return this.scheidsrechterRepository.findScheidsrechterBySkuCodeIn(skuCode).stream().map((scheidsrechter) -> {
            return ScheidsrechterResponse.builder()
                    .skuCode(scheidsrechter.getSkuCode())
                    .naam(scheidsrechter.getNaam())
                    .mail(scheidsrechter.getMail())
                    .geboortedatum(scheidsrechter.getGeboortedatum())
                    .niveau(scheidsrechter.getNiveau())
                    .isAssistent(scheidsrechter.getIsAssistent())
                    .scheidsrechterID(scheidsrechter.getScheidsrechterID()).build();
        }).toList();
    }

    private ScheidsrechterResponse mapToScheidsrechterResponse(Scheidsrechter scheidsrechter) {
        return ScheidsrechterResponse.builder()
                .skuCode(scheidsrechter.getSkuCode())
                .naam(scheidsrechter.getNaam())
                .mail(scheidsrechter.getMail())
                .geboortedatum(scheidsrechter.getGeboortedatum())
                .niveau(scheidsrechter.getNiveau())
                .isAssistent(scheidsrechter.getIsAssistent())
                .scheidsrechterID(scheidsrechter.getScheidsrechterID()).build();
    }

    public List<ScheidsrechterResponse> getAllScheidsrechters() {
        List<Scheidsrechter> scheidsrechters = this.scheidsrechterRepository.findAll();
        return scheidsrechters.stream().map(this::mapToScheidsrechterResponse).toList();
    }

    public ScheidsrechterResponse update(ScheidsrechterRequest scheidsrechterRequest) {
        Scheidsrechter scheidsrechter = this.scheidsrechterRepository.findScheidsrechterBySkuCode(scheidsrechterRequest.getSkuCode());
        scheidsrechter.setNaam(scheidsrechterRequest.getNaam());
        scheidsrechter.setMail(scheidsrechterRequest.getMail());
        scheidsrechter.setNiveau(scheidsrechterRequest.getNiveau());
        scheidsrechter.setIsAssistent(scheidsrechterRequest.getIsAssistent());
        scheidsrechter.setGeboortedatum(scheidsrechterRequest.getGeboortedatum());
        scheidsrechter.setScheidsrechterID(scheidsrechterRequest.getScheidsrechterID());
        this.scheidsrechterRepository.save(scheidsrechter);
        return ScheidsrechterResponse.builder()
                .skuCode(scheidsrechter.getSkuCode())
                .naam(scheidsrechter.getNaam())
                .niveau(scheidsrechter.getNiveau())
                .isAssistent(scheidsrechter.getIsAssistent())
                .geboortedatum(scheidsrechter.getGeboortedatum())
                .mail(scheidsrechter.getMail())
                .scheidsrechterID(scheidsrechter.getScheidsrechterID())
                .build();
    }

    public void delete(String skuCode) {
        Long scheidsrechterCode = this.scheidsrechterRepository.findScheidsrechterBySkuCode(skuCode).getScheidsrechterID();
        this.scheidsrechterRepository.deleteById(scheidsrechterCode);
    }

    public ScheidsrechterService(final ScheidsrechterRepository scheidsrechterRepository) {
        this.scheidsrechterRepository = scheidsrechterRepository;
    }
}
