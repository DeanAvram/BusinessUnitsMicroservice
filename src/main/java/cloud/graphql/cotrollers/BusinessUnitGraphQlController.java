package cloud.graphql.cotrollers;

import cloud.graphql.boundries.EmployeeBoundary;
import cloud.graphql.boundries.EmployeeGraphQlBoundary;
import cloud.graphql.boundries.UnitBoundary;
import cloud.graphql.boundries.UnitGraphQlBoundary;
import cloud.graphql.services.BusinessUnitGraphQlService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.text.SimpleDateFormat;

@Controller
public class BusinessUnitGraphQlController {
    private BusinessUnitGraphQlService businessUnitGraphQlService;
    private SimpleDateFormat formatter;

    public BusinessUnitGraphQlController(BusinessUnitGraphQlService businessUnitGraphQlService) {
        this.businessUnitGraphQlService = businessUnitGraphQlService;
        this.formatter = new SimpleDateFormat("dd-MM-yyyy");
    }

    @QueryMapping
    public Mono<UnitGraphQlBoundary> getUnitById(
            @Argument String id){
        return this.businessUnitGraphQlService
                .getSpecificUnit(id)
                .map(this::toGraphBoundary)
                .log();
    }

    @QueryMapping
    public Mono<EmployeeGraphQlBoundary> getEmployeeByEmail(
            @Argument String email){
        return this.businessUnitGraphQlService
                .getSpecifEmployee(email)
                .map(this::toEmployeeGraphQlyBoundary)
                .log();
    }

    @SchemaMapping
    public Flux<UnitGraphQlBoundary> getUnits(
            UnitGraphQlBoundary unit,
            @Argument int page,
            @Argument int size){
        return this.businessUnitGraphQlService
                .getUnits(unit.getId(),page,size)
                .map(this::toGraphBoundary)
                .log();

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
        rv.setCreationDate(this.formatter.format(unitBoundary.getCreationDate()));
        return rv;
    }

}
