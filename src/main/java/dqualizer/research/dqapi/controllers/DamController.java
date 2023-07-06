package dqualizer.research.dqapi.controllers;

import dqualizer.research.dqapi.dtos.CreateDamDto;
import dqualizer.research.dqapi.models.Domain;
import dqualizer.research.dqapi.models.dam.DomainArchitectureMapping;
import dqualizer.research.dqapi.services.DamService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/dam")
@AllArgsConstructor
public class DamController {

    private final DamService damService;
    @GetMapping("/")
    public ResponseEntity<List<DomainArchitectureMapping>> getAllDams() {
        return new ResponseEntity<>(damService.getAllDams(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<DomainArchitectureMapping> createDam(@RequestBody CreateDamDto createDamDto) {
        return new ResponseEntity<>(damService.createNewDam(createDamDto), HttpStatus.CREATED);
    }
}
