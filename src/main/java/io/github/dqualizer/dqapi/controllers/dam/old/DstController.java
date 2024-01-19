package io.github.dqualizer.dqapi.controllers.dam.old;

import io.github.dqualizer.dqapi.dtos.old.CreateDstDto;
import dqualizer.research.dqapi.models.dst.DomainStory;
import io.github.dqualizer.dqapi.services.old.DstService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/dst")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class DstController {
    private final DstService dstService;

    @PostMapping("/")
    public DomainStory createDomainStory(@RequestBody CreateDstDto createDstDto) {
        return dstService.createNewDst(createDstDto);
    }

    @GetMapping("/")
    public List<DomainStory> getAllDomainStories() {
        return  dstService.getAllDsts();
    }
}
