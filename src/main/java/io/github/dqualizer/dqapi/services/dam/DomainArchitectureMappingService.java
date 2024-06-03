package io.github.dqualizer.dqapi.services.dam;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.dqualizer.dqapi.exceptions.NotFoundException;
import io.github.dqualizer.dqapi.repositories.dam.DomainArchitectureMappingRepository;
import io.github.dqualizer.dqlang.types.dam.DomainArchitectureMapping;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class DomainArchitectureMappingService {

    @Autowired
    private DomainArchitectureMappingRepository repository;
    @Autowired
    private ObjectMapper mapper;

    public List<DomainArchitectureMapping> readAll() {
        return repository.findAll();
    }

    public DomainArchitectureMapping readById(String id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Could not find Domain-Architecture-Mapping with id: " + id + "."));
    }

    public DomainArchitectureMapping create(DomainArchitectureMapping entity) {
        return repository.insert(entity);
    }

    /**
     * Insert DAM into Mongo repository at application start
     */
    @PostConstruct
    public void createInitialDam() {
        DomainArchitectureMapping dam = loadDAM();
        repository.insert(dam);
    }

    /**
     * Load local DAM json and convert to java object
     */
    public DomainArchitectureMapping loadDAM() {
        String file = "/src/main/resources/werkstatt-dam.json";
        Path damPath = Paths.get(System.getProperty("user.dir") + file);
        String damString;

        try {
            damString = Files.readString(damPath);
        } catch (IOException e) {
            System.out.println("Could not load local DAM json file");
            throw new RuntimeException(e);
        }

        DomainArchitectureMapping dam;
        try {
            dam = mapper.readValue(damString, DomainArchitectureMapping.class);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        return dam;
    }
}