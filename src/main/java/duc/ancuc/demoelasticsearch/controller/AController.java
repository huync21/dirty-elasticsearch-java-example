package duc.ancuc.demoelasticsearch.controller;

import duc.ancuc.demoelasticsearch.repo.ARepo;
import duc.ancuc.demoelasticsearch.repo.entities.A;
import duc.ancuc.demoelasticsearch.services.ElasticSearchService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/A")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AController {
    ARepo aRepo;
    ElasticSearchService elasticSearchService;

    @PostMapping
    public ResponseEntity<A> createA(@RequestBody A a) throws IOException {
        A savedA = aRepo.save(a);
        elasticSearchService.createDocument("a", savedA.getId().toString(), savedA);
        return ResponseEntity.ok(a);
    }
}
