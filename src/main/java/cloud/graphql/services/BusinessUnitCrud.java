package cloud.graphql.services;

import cloud.graphql.entites.BusinessUnitEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.Param;
import reactor.core.publisher.Flux;

public interface BusinessUnitCrud extends ReactiveMongoRepository<BusinessUnitEntity, String> {

        public Flux<BusinessUnitEntity> findByIdNot (@Param("id") String id);
}
