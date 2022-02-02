package angelozero.webfluxapp.repository;

import angelozero.webfluxapp.repository.entity.DataEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository extends ReactiveCrudRepository<DataEntity, String> {
}
