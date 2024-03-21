package duc.ancuc.demoelasticsearch.repo.elasticsearch;
import duc.ancuc.demoelasticsearch.repo.elasticsearch.documents.ADocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface AElasticSearchRepo extends ElasticsearchRepository<ADocument, Long> {
}
