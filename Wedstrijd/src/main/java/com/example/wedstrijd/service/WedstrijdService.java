package com.example.wedstrijd.service;

import com.example.wedstrijd.dto.WedstrijdRequest;
import com.example.wedstrijd.dto.WedstrijdResponse;
import com.example.wedstrijd.model.Wedstrijd;
import com.example.wedstrijd.repository.WedstrijdRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class WedstrijdService {
    private final WedstrijdRepository wedstrijdRepository;

    public void createWedstrijd(WedstrijdRequest wedstrijdRequest) {
        Wedstrijd wedstrijd = Wedstrijd.builder()
                .skuCode(wedstrijdRequest.getSkuCode())
                .thuisTeam(wedstrijdRequest.getThuisTeam())
                .uitTeam(wedstrijdRequest.getUitTeam())
                .datum(wedstrijdRequest.getDatum())
                .ScheidsrechterID(wedstrijdRequest.getScheidsrechterID())
                .score(wedstrijdRequest.getScore())
                .build();
        System.out.println(wedstrijd.getScore());
        this.wedstrijdRepository.save(wedstrijd);
    }

    private WedstrijdResponse mapToWedstrijdResponse(Wedstrijd wedstrijd) {
        return WedstrijdResponse.builder().skuCode(wedstrijd.getSkuCode()).thuisTeam(wedstrijd.getThuisTeam()).uitTeam(wedstrijd.getUitTeam()).datum(wedstrijd.getDatum()).ScheidsrechterID(wedstrijd.getScheidsrechterID()).score(wedstrijd.getScore()).build();
    }

    public List<WedstrijdResponse> getAllWedstrijden() {
        List<Wedstrijd> wedstrijden = this.wedstrijdRepository.findAll();
        return wedstrijden.stream().map(this::mapToWedstrijdResponse).toList();
    }

    public List<WedstrijdResponse> get(List<String> skuCode) {
        return this.wedstrijdRepository.findWedstrijdBySkuCodeIn(skuCode).stream().map((wedstrijd) -> {
            return WedstrijdResponse.builder().skuCode(wedstrijd.getSkuCode())
                    .thuisTeam(wedstrijd.getThuisTeam())
                    .uitTeam(wedstrijd.getUitTeam())
                    .datum(wedstrijd.getDatum())
                    .ScheidsrechterID(wedstrijd.getScheidsrechterID())
                    .score(wedstrijd.getScore()).build();
        }).toList();
    }

    public WedstrijdResponse update(WedstrijdRequest wedstrijdRequest) {
        Wedstrijd wedstrijd = this.wedstrijdRepository.findWedstrijdBySkuCode(wedstrijdRequest.getSkuCode());
        wedstrijd.setDatum(wedstrijdRequest.getDatum());
        wedstrijd.setScheidsrechterID(wedstrijdRequest.getScheidsrechterID());
        wedstrijd.setThuisTeam(wedstrijdRequest.getThuisTeam());
        wedstrijd.setUitTeam(wedstrijdRequest.getUitTeam());
        wedstrijd.setScore(wedstrijdRequest.getScore());
        this.wedstrijdRepository.save(wedstrijd);
        return WedstrijdResponse.builder().skuCode(wedstrijd.getSkuCode())
                .datum(wedstrijd.getDatum())
                .ScheidsrechterID(wedstrijd.getScheidsrechterID())
                .thuisTeam(wedstrijd.getThuisTeam())
                .uitTeam(wedstrijd.getUitTeam())
                .score(wedstrijd.getScore()).build();
    }

    public void delete(String skuCode) {
        Long wedstrijdCode = this.wedstrijdRepository.findWedstrijdBySkuCode(skuCode).getWedstrijdID();
        this.wedstrijdRepository.deleteById(wedstrijdCode);
    }

    public WedstrijdService(final WedstrijdRepository wedstrijdRepository) {
        this.wedstrijdRepository = wedstrijdRepository;
    }
}
