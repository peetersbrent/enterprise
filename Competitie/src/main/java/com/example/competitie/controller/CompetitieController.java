package com.example.competitie.controller;

import java.util.List;

import com.example.competitie.dto.CompetitieRequest;
import com.example.competitie.dto.CompetitieResponse;
import com.example.competitie.service.CompetitieService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/competitie"})
public class CompetitieController {
    private final CompetitieService competitieService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void createCompetitie(@RequestBody CompetitieRequest competitieRequest) {
        this.competitieService.createCompetitie(competitieRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CompetitieResponse> getAllCompetitiesBySkuCode(@RequestParam List<String> skuCode) {
        return this.competitieService.getAllCompetitiesBySkuCode(skuCode);
    }

    @GetMapping({"/all"})
    @ResponseStatus(HttpStatus.OK)
    public List<CompetitieResponse> getAllCompetities() {
        return this.competitieService.getAllCompetities();
    }

    @DeleteMapping({"/{skuCode}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String skuCode) {
        this.competitieService.delete(skuCode);
    }

    public CompetitieController(final CompetitieService competitieService) {
        this.competitieService = competitieService;
    }
}

