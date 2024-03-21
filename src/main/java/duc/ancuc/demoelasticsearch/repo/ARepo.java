package duc.ancuc.demoelasticsearch.repo;

import duc.ancuc.demoelasticsearch.repo.entities.A;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ARepo extends JpaRepository<A, Long> {
}
