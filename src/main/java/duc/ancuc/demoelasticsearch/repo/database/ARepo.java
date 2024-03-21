package duc.ancuc.demoelasticsearch.repo.database;

import duc.ancuc.demoelasticsearch.repo.database.entities.A;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ARepo extends JpaRepository<A, Long> {
}
