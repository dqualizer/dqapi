package io.github.dqualizer.dqapi.controllers.dam.old;

import io.github.dqualizer.dqapi.dtos.old.CreateDamDto;

import io.github.dqualizer.dqapi.services.old.DamService;
import io.github.dqualizer.dqlang.types.dam.DomainArchitectureMapping;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/dam")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class DamController {

    private final DamService damService;
    @GetMapping("/")
    public ResponseEntity<List<DomainArchitectureMapping>> getAllDams() {
        return new ResponseEntity<>(damService.getAllDams(), HttpStatus.OK);
    }

    @GetMapping("/{damId}")
    public ResponseEntity<DomainArchitectureMapping> getDamById(@PathVariable String damId) {
        return new ResponseEntity<>(damService.getDamById(damId), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<DomainArchitectureMapping> createDam(@RequestBody CreateDamDto createDamDto) {
        System.out.println(createDamDto.getActors());
        return new ResponseEntity<>(damService.createNewDam(createDamDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/")
    public ResponseEntity<List<DomainArchitectureMapping>> deleteAllDams() {
        return new ResponseEntity<>(damService.deleteAllDams(), HttpStatus.OK);
    }
}
