package dqualizer.research.dqapi.services.old;

import dqualizer.research.dqapi.models.Domain;
import dqualizer.research.dqapi.models.SubDomain;
import dqualizer.research.dqapi.repositories.old.DomainRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DomainService {

    private final DomainRepository domainRepository;
    public Domain createNewDomain(String domainName) {
        Domain domain = new Domain(domainName);
        domainRepository.insert(domain);
        return domain;
    }


    public void deleteAllDomains() {
        domainRepository.deleteAll();
    }

    public List<Domain> getAllDomains() {
        return domainRepository.findAll();
    }

    public Domain getDomainById(String domainName) {
        return domainRepository.findByName(domainName).orElseThrow(() -> new IllegalStateException("Domain with name" + domainName + " not found"));
    }

    public Domain createSubDomain(String domainName, String subdomainName) {
        domainRepository.findByName(domainName).ifPresentOrElse((value) -> {
        value.getSubdomains().add(new SubDomain(subdomainName));
        domainRepository.save(value);
        }, () -> { throw new IllegalStateException("Couldn´´ find Domain " + domainName);});
    return  domainRepository.findByName(domainName).get();
    }

    public List<Domain> deleteDomainByName(String domainName) {
        domainRepository.findByName(domainName)
                .ifPresentOrElse((domain)-> domainRepository.delete(domain), ()-> new IllegalStateException("Domain doesn´´ exist"));
        return domainRepository.findAll();
    }

    public Domain deleteSubDomainByName(String domainName, String subDomainName) {
        Domain domain = domainRepository.findByName(domainName).orElseThrow(()->new IllegalStateException("Domain not found"));
        List<SubDomain> subdomains = domain.getSubdomains();
        SubDomain subDomain = subdomains.stream().filter((item) ->
            item.getName().equals(subDomainName)).findFirst().orElseThrow(()-> new IllegalArgumentException("Domain doesnt exist"));
        domain.getSubdomains().remove(subDomain);
        domainRepository.save(domain);
        return domain;
    }
}