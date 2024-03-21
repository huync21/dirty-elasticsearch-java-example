package duc.ancuc.demoelasticsearch.services;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ElasticSearchService {
    ElasticsearchClient esClient;

    public IndexResponse createDocument(String indexName, String indexId, Object document) throws IOException {
        IndexResponse index = null;
        try {
            index = esClient.index(i -> i
                    .index(indexName)
                    .id(indexId)
                    .document(document)
            );
        }catch (Exception e){
            e.printStackTrace();
        }
        return index;
    }


    public SearchResponse fullTextSearch(List<String> indices, String searchText, List<String> searchFields,
                                         Object object) throws IOException {
        //create this query {
        //  "query": {
        //    "multi_match": {
        //      "query": "search term",
        //      "fields": ["title", "description"]
        //    }
        //  }
        //}

        return esClient.search(s -> s
                        .index(indices)
                        .query(q -> q
                                .multiMatch(m -> m
                                        .query(searchText)
                                        .fields(searchFields)
                                )
                        ),
                Object.class
        );
    }
}
