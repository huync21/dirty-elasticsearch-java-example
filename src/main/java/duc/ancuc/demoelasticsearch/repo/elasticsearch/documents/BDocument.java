package duc.ancuc.demoelasticsearch.repo.elasticsearch.documents;

import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "b")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BDocument {
    @Id
    private Long id;
    private String title;
    private String description;
}
