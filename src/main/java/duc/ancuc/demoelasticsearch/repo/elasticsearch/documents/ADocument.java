package duc.ancuc.demoelasticsearch.repo.elasticsearch.documents;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "a")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ADocument {
    @Id
    private Long id;
    private String title;
}
