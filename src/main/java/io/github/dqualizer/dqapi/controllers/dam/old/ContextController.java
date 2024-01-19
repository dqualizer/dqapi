package io.github.dqualizer.dqapi.controllers.dam.old;

import dqualizer.research.dqapi.models.context.Context;
import io.github.dqualizer.dqapi.services.old.ContextService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/{domainName}")
@AllArgsConstructor
public class ContextController {
    private final ContextService contextService;
    @PostMapping("/{contextName}")
    public Context createContextForDomain(@PathVariable String domainName, @PathVariable String contextName ) {
        return contextService.createNewContext(domainName, contextName);
    }

}
