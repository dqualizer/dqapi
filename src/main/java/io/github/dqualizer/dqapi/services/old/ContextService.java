package io.github.dqualizer.dqapi.services.old;

import dqualizer.research.dqapi.models.Domain;
import dqualizer.research.dqapi.models.context.Context;
import io.github.dqualizer.dqapi.repositories.old.DomainRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ContextService {
    private final DomainRepository domainRepository;

    public Context createNewContext(String domainName, String contextName) {
        Domain domain = domainRepository.findByName(domainName).orElseThrow(() -> new IllegalStateException("Domain with name" + domainName + " does not exist."));

        if(domain.getContexts().stream().anyMatch(existingContext -> existingContext.getName().equals(contextName))) {
            throw new IllegalArgumentException("A Context with the name " + contextName + " already exists.");
        };

        Context newContext = new Context(contextName);
        domain.getContexts().add(newContext);
        domainRepository.save(domain);
        return newContext;
    }



}
