package dqualizer.research.dqapi.services.dam;

import dqualizer.research.dqapi.repositories.dam.DomainArchitectureMappingRepository;
import io.github.dqualizer.dqlang.types.dam.DomainArchitectureMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class DomainArchitectureMappingService {

    @Autowired
    private DomainArchitectureMappingRepository repository;

    public Set<DomainArchitectureMapping> readAll() {
        return repository.findAll();
    }


}
