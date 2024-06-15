package cloud.graphql.services;

import cloud.graphql.boundries.EmployeeBoundary;
import cloud.graphql.boundries.UnitBoundary;
import io.micrometer.observation.ObservationFilter;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

public interface BusinessUnitService {

    public Mono<UnitBoundary> initOrg(UnitBoundary unitBoundary);
    public Mono<UnitBoundary> createOrg(UnitBoundary unitBoundary, String parentUnitId);
    public Mono<Void> cleanup();

    public Flux<UnitBoundary> gelAll();
    public Mono<UnitBoundary> getOrgById(String id);
    public Flux<UnitBoundary> getSubUnits(String id, int page, int size);

    public Flux<EmployeeBoundary> getEmployees(String id, int page, int size);
}
