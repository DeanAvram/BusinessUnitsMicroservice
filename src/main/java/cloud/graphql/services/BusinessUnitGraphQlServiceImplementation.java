package cloud.graphql.services;

import cloud.graphql.boundries.EmployeeBoundary;
import cloud.graphql.boundries.UnitBoundary;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BusinessUnitGraphQlServiceImplementation implements BusinessUnitGraphQlService{

    private BusinessUnitCrud units;

    public BusinessUnitGraphQlServiceImplementation(BusinessUnitCrud units) {
        this.units = units;
    }

    @Override
    public Mono<UnitBoundary> getSpecificUnit(String id) {
        return null;
    }

    @Override
    public Mono<EmployeeBoundary> getSpecifEmployee(String email) {
        return null;
    }

    @Override
    public Flux<UnitBoundary> getUnits(String id, int page, int size) {
        return null;
    }
}
