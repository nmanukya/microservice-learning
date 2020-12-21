package nlm.springframework.microservicelearning.repositories;

import nlm.springframework.microservicelearning.domain.Beer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {

}
