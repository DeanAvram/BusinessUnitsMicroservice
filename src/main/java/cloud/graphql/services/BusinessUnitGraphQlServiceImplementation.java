package cloud.graphql.services;

import cloud.graphql.boundries.EmployeeBoundary;
import cloud.graphql.boundries.EmployeeGraphQlBoundary;
import cloud.graphql.boundries.UnitBoundary;
import cloud.graphql.boundries.UnitGraphQlBoundary;
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
    public Mono<UnitGraphQlBoundary> getSpecificUnit(String id) {
        return null;
    }

    @Override
    public Mono<EmployeeGraphQlBoundary> getSpecifEmployee(String email) {
        return null;
    }

    @Override
    public Flux<UnitGraphQlBoundary> getAllUnits(int page, int size) {
        return null;
    }

    private EmployeeGraphQlBoundary toEmployeeGraphQlyBoundary(EmployeeBoundary employeeBoundary) {
        EmployeeGraphQlBoundary rv = new EmployeeGraphQlBoundary();
        rv.setEmail(employeeBoundary.getEmail());
        rv.setUnits(employeeBoundary.getUnits());
        return rv;
    }


    private UnitGraphQlBoundary toGraphBoundary(UnitBoundary unitBoundary) {
        UnitGraphQlBoundary rv = new UnitGraphQlBoundary();
        rv.setId(unitBoundary.getId());
        rv.setManager(unitBoundary.getManager());
        rv.setType(unitBoundary.getType());
        //rv.setParentUnit(unitBoundary.getParentUnit);
        //rv.setCreationDate(this.formatter.format(unitBoundary.getCreationDate()));
        return rv;
    }
}
