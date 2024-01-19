package io.github.dqualizer.dqapi.controllers.dam.old;

import dqualizer.research.dqapi.models.Domain;
import io.github.dqualizer.dqapi.services.old.DomainService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class DomainController {
    private final DomainService domainService;
    @PostMapping("{domainName}")
    public Domain createNewDomain(@PathVariable String domainName) {
        return domainService.createNewDomain(domainName);
    }
    @PutMapping("{domainName}/{subdomainName}")
    public Domain createNewSubDomain(@PathVariable String domainName, @PathVariable String subdomainName) {
        return domainService.createSubDomain(domainName, subdomainName);
    }
    @DeleteMapping()
    public void deleteAllDomains() {
        domainService.deleteAllDomains();
    }

    @DeleteMapping("{domainName}")
    public List<Domain> deleteDomainByName(@PathVariable String domainName ) {
        return domainService.deleteDomainByName(domainName);
    }
    @DeleteMapping("{domainName}/{subDomainName}")
    public Domain deleteSubDomainByName(@PathVariable String domainName, @PathVariable String subDomainName) {
        return domainService.deleteSubDomainByName(domainName, subDomainName);
    }
    @GetMapping
    public List<Domain> getAllDomains() {
       return domainService.getAllDomains();
    }

    @GetMapping("{domainName}")
    public Domain getDomainByName(@PathVariable String domainName) {
        return domainService.getDomainById(domainName);
    }

}
