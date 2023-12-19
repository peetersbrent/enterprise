package com.example.competitie.service;

import com.example.competitie.dto.CompetitieRequest;
import com.example.competitie.dto.CompetitieResponse;
import com.example.competitie.model.Competitie;
import com.example.competitie.repository.CompetitieRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class CompetitieService {
    private final CompetitieRepository competitieRepository;

    public void createCompetitie(CompetitieRequest competitieRequest) {
        Competitie competitie = Competitie.builder().skuCode(competitieRequest.getSkuCode()).provincie(competitieRequest.getProvincie()).startDatum(competitieRequest.getStartDatum()).eindDatum(competitieRequest.getEindDatum()).competitieleider(competitieRequest.getCompetitieleider()).ploegen(competitieRequest.getPloegen()).build();
        this.competitieRepository.save(competitie);
    }

    public List<CompetitieResponse> getAllCompetitiesBySkuCode(List<String> skuCode) {
        List<Competitie> competities = this.competitieRepository.findBySkuCodeIn(skuCode);
        return competities.stream().map(this::mapToCompetitieResponse).toList();
    }

    private CompetitieResponse mapToCompetitieResponse(Competitie competitie) {
        return CompetitieResponse.builder().skuCode(competitie.getSkuCode()).provincie(competitie.getProvincie()).startDatum(competitie.getStartDatum()).eindDatum(competitie.getEindDatum()).competitieleider(competitie.getCompetitieleider()).ploegen(competitie.getPloegen()).build();
    }

    public List<CompetitieResponse> getAllCompetities() {
        List<Competitie> competities = this.competitieRepository.findAll();
        return competities.stream().map(this::mapToCompetitieResponse).toList();
    }

    public void delete(String skuCode) {
        List<String> comp = new ArrayList();
        comp.add(skuCode);
        List<Competitie> competities = this.competitieRepository.findBySkuCodeIn(comp);
        Iterator var4 = competities.iterator();

        while(var4.hasNext()) {
            Competitie competitie = (Competitie)var4.next();
            System.out.println(competitie.getCompetitieleider());
            this.competitieRepository.deleteById(competitie.getCompetitieId());
        }

    }

    public CompetitieService(final CompetitieRepository competitieRepository) {
        this.competitieRepository = competitieRepository;
    }
}
