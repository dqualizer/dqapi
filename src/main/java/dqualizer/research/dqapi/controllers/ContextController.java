package dqualizer.research.dqapi.controllers;

import dqualizer.research.dqapi.models.context.Context;
import dqualizer.research.dqapi.services.ContextService;
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
