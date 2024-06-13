package cloud.graphql.services;

import cloud.graphql.boundries.UnitBoundary;
import reactor.core.publisher.Mono;

public interface BusinessUnitRestService {

    public Mono<UnitBoundary> createOrg(String parentUnitId, UnitBoundary unitBoundary);
    public Mono<Void> cleanup();
}
