package com.example.scheidsrechter.controller;

import com.example.scheidsrechter.dto.ScheidsrechterRequest;
import com.example.scheidsrechter.dto.ScheidsrechterResponse;
import com.example.scheidsrechter.service.ScheidsrechterService;
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
@RequestMapping({"/api/scheidsrechter"})
public class ScheidsrechterController {
    private final ScheidsrechterService scheidsrechterService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ScheidsrechterResponse> get(@RequestParam List<String> skuCode) {
        return this.scheidsrechterService.get(skuCode);
    }

    @GetMapping({"/all"})
    @ResponseStatus(HttpStatus.OK)
    public List<ScheidsrechterResponse> getAllScheidsrechters() {
        return this.scheidsrechterService.getAllScheidsrechters();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void createScheidsrechter(@RequestBody ScheidsrechterRequest scheidsrechterRequest) {
        this.scheidsrechterService.createScheidsrechter(scheidsrechterRequest);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ScheidsrechterResponse update(@RequestBody ScheidsrechterRequest scheidsrechterRequest) {
        return this.scheidsrechterService.update(scheidsrechterRequest);
    }

    @DeleteMapping({"/{skuCode}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteScheidsrechter(@PathVariable String skuCode) {
        this.scheidsrechterService.delete(skuCode);
    }

    public ScheidsrechterController(final ScheidsrechterService scheidsrechterService) {
        this.scheidsrechterService = scheidsrechterService;
    }
}
