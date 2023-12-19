package com.example.wedstrijd.controller;

import com.example.wedstrijd.dto.WedstrijdRequest;
import com.example.wedstrijd.dto.WedstrijdResponse;
import com.example.wedstrijd.service.WedstrijdService;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/wedstrijd"})
public class WedstrijdController {
    private final WedstrijdService wedstrijdService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<WedstrijdResponse> get(@RequestParam List<String> skuCode) {
        return this.wedstrijdService.get(skuCode);
    }

    @GetMapping({"/all"})
    @ResponseStatus(HttpStatus.OK)
    public List<WedstrijdResponse> getAllWedstrijden() {
        return this.wedstrijdService.getAllWedstrijden();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void createWedstrijd(@RequestBody WedstrijdRequest wedstrijdRequest) {
        this.wedstrijdService.createWedstrijd(wedstrijdRequest);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public WedstrijdResponse update(@RequestBody WedstrijdRequest wedstrijdRequest) {
        return this.wedstrijdService.update(wedstrijdRequest);
    }

    @DeleteMapping({"/{skuCode}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String skuCode) {
        this.wedstrijdService.delete(skuCode);
    }

    public WedstrijdController(final WedstrijdService wedstrijdService) {
        this.wedstrijdService = wedstrijdService;
    }
}
