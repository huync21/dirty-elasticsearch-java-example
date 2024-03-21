package duc.ancuc.demoelasticsearch.controller;

import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import duc.ancuc.demoelasticsearch.services.ElasticSearchService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/search")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SearchController {
    ElasticSearchService elasticSearchService;
    @GetMapping("/full-text-search")
    public ResponseEntity<List<Object>> fullTextSearch(@RequestParam String searchText) throws IOException {
        SearchResponse searchResponse = elasticSearchService.fullTextSearch(Arrays.asList("a", "b"), searchText, Arrays.asList("title", "description"), Object.class);
        List<Hit<Object>> hits = searchResponse.hits().hits();
        List<Object> resutls = hits.stream().map(Hit::source).collect(Collectors.toList());
        return ResponseEntity.ok(resutls);
    }

}
