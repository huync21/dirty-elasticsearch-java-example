package duc.ancuc.demoelasticsearch.controller;

import duc.ancuc.demoelasticsearch.repo.database.ARepo;
import duc.ancuc.demoelasticsearch.repo.database.entities.A;
import duc.ancuc.demoelasticsearch.repo.elasticsearch.AElasticSearchRepo;
import duc.ancuc.demoelasticsearch.repo.elasticsearch.documents.ADocument;
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
//    ElasticSearchService elasticSearchService;
    AElasticSearchRepo aElasticSearchRepo;

    @PostMapping
    public ResponseEntity<A> createA(@RequestBody A a) throws IOException {
        A savedA = aRepo.save(a);
//        elasticSearchService.createDocument("a", savedA.getId().toString(), savedA);
        ADocument aDocument = ADocument.builder()
                .id(savedA.getId())
                .title(savedA.getTitle())
                .build();
        aElasticSearchRepo.save(aDocument);
        return ResponseEntity.ok(a);
    }
}
