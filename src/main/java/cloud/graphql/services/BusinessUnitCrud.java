package cloud.graphql.services;

import cloud.graphql.entites.UnitEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.Param;
import reactor.core.publisher.Flux;

public interface BusinessUnitCrud extends ReactiveMongoRepository<UnitEntity, String> {

        public Flux<UnitEntity> findByIdNot (@Param("id") String id);
}