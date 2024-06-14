package cloud.graphql.services;


import cloud.graphql.boundries.EmployeeBoundary;
import cloud.graphql.boundries.EmployeeGraphQlBoundary;
import cloud.graphql.boundries.UnitBoundary;
import cloud.graphql.boundries.UnitGraphQlBoundary;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BusinessUnitGraphQlService {

    public Mono<UnitGraphQlBoundary> getSpecificUnit(String id);
    public Mono<EmployeeGraphQlBoundary> getSpecifEmployee(String email);

    public Flux<UnitGraphQlBoundary> getAllUnits(int page, int size);
}
