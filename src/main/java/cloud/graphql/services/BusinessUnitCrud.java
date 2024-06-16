package cloud.graphql.services;

import cloud.graphql.boundries.EmployeeGraphQlBoundary;
import cloud.graphql.entites.UnitEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.Param;
import reactor.core.publisher.Flux;

public interface BusinessUnitCrud extends ReactiveMongoRepository<UnitEntity, String> {

        public Flux<UnitEntity> findByIdNot (@Param("id") String id, Pageable pageable);
        public Flux<UnitEntity> findAllByParentUnit(@Param("parentUnit") String parentUnit, Pageable pageable);
        public Flux<UnitEntity> findAllByEmployees_Email(@Param("email") String email, Pageable pageable);
        public Flux<UnitEntity> findAllByManager(@Param("manager") String email, Pageable pageable);
}
