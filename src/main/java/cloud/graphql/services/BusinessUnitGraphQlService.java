package cloud.graphql.services;


import cloud.graphql.boundries.EmployeeBoundary;
import cloud.graphql.boundries.UnitBoundary;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BusinessUnitGraphQlService {

    public Mono<UnitBoundary> getSpecificUnit(String id);
    public Mono<EmployeeBoundary> getSpecifEmployee(String email);

    public Flux<UnitBoundary> getUnits(String id, int page, int size);
}
