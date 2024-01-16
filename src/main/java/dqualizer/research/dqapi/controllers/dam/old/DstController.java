package dqualizer.research.dqapi.controllers.dam.old;

import dqualizer.research.dqapi.dtos.old.CreateDstDto;
import dqualizer.research.dqapi.models.dst.DomainStory;
import dqualizer.research.dqapi.services.old.DstService;
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
