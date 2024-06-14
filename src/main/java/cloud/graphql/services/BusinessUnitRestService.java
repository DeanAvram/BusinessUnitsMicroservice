package cloud.graphql.services;

import cloud.graphql.boundries.EmployeeBoundary;
import cloud.graphql.boundries.UnitBoundary;
import cloud.graphql.entites.UnitEntity;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

public interface BusinessUnitRestService {

    public Mono<UnitBoundary> createOrg(UnitBoundary unitBoundary, String parentUnitId);
    public Mono<Void> cleanup();

    public Flux<UnitBoundary> gelAll();
    //public Mono<UnitBoundary> getOrgById(String id);

}
