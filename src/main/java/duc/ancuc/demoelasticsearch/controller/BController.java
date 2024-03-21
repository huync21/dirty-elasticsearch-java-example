package duc.ancuc.demoelasticsearch.controller;

import duc.ancuc.demoelasticsearch.repo.database.BRepo;
import duc.ancuc.demoelasticsearch.repo.database.entities.B;
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
@RequestMapping("/B")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BController {
    BRepo bRepo;
    ElasticSearchService elasticSearchService;
    @PostMapping
    public ResponseEntity<B> createB(@RequestBody B b) throws IOException {
        B savedB = bRepo.save(b);
        elasticSearchService.createDocument("b", savedB.getId().toString(), savedB);
        return ResponseEntity.ok(b);
    }
}
