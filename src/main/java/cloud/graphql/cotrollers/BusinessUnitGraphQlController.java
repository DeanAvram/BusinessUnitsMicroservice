package cloud.graphql.cotrollers;

import cloud.graphql.boundries.*;
import cloud.graphql.services.BusinessUnitService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Controller
public class BusinessUnitGraphQlController {

    private BusinessUnitService businessUnitService;

    public BusinessUnitGraphQlController(BusinessUnitService businessUnitService) {
        this.businessUnitService = businessUnitService;
    }

    @QueryMapping
    public Mono<UnitGraphQlBoundary> unit(
            @Argument String id){
        return this.businessUnitService
                .getOrgById(id)
                .map(this::toUnitGraphBoundary);
    }

    @QueryMapping
    public Mono<EmployeeGraphQlBoundary> employee(
            @Argument String email){

        return this.businessUnitService
                .getSpecifEmployee(email)
                .map(this::toEmployeeGraphQlBoundary);

    }

    @SchemaMapping
    public Flux<UnitGraphQlBoundary> subUnits (
            UnitGraphQlBoundary unit,
            @Argument int page,
            @Argument int size){
        return this.businessUnitService
                .getSubUnits(unit.getId(), page, size)
                .map(this::toUnitGraphBoundary);
    }

    @SchemaMapping
    public Flux<EmployeeGraphQlBoundary> employees(
            UnitGraphQlBoundary unit,
            @Argument int page,
            @Argument int size){
        return this.businessUnitService
                .getEmployees(unit.getId(), page, size)
                .map(this::toEmployeeGraphQlBoundary);

    }


    @SchemaMapping
    public Flux<UnitGraphQlBoundary> units(
            EmployeeGraphQlBoundary employee,
            @Argument int page,
            @Argument int size){
        return this.businessUnitService
                .getUnitsOfEmployee(employee.getEmail(), page, size)
                .map(this::toUnitGraphBoundary);
    }

    @SchemaMapping
    public Flux<UnitGraphQlBoundary> manages(
            EmployeeGraphQlBoundary employee,
            @Argument int page,
            @Argument int size){
        return this.businessUnitService
                .getUnitsOfManager(employee.getEmail(), page, size)
                .map(this::toUnitGraphBoundary);
    }

    @MutationMapping
    public Mono<UnitGraphQlBoundary> addUnit(
            @Argument String parentUnitId,
            @Argument String newUnitId,
            @Argument String newUnitType,
            @Argument String managerEmail){
        UnitBoundary boundary = new UnitBoundary();
        boundary.setId(newUnitId);
        boundary.setType(newUnitType);
        boundary.setManager(managerEmail);
        return this.businessUnitService
                .createOrg(boundary, parentUnitId)
                .map(this::toUnitGraphBoundary);
    }

    @MutationMapping
    public Mono<EmployeeGraphQlBoundary> addEmployee(
            @Argument String unitId,
            @Argument String email){
        EmployeeBoundary boundary = new EmployeeBoundary();
        boundary.setEmail(email);
        return this.businessUnitService
                .addEmployeeToUnit(unitId, boundary)
                .map(this::toEmployeeGraphQlBoundary);
    }


    private EmployeeGraphQlBoundary toEmployeeGraphQlBoundary(EmployeeBoundary employeeBoundary) {
        EmployeeGraphQlBoundary rv = new EmployeeGraphQlBoundary();

        rv.setEmail(employeeBoundary.getEmail());

        return rv;
    }

    private UnitGraphQlBoundary toUnitGraphBoundary(UnitBoundary unitBoundary) {
        UnitGraphQlBoundary rv = new UnitGraphQlBoundary();

        rv.setId(unitBoundary.getId());
        rv.setType(unitBoundary.getType());
        rv.setManager(unitBoundary.getManager());
        rv.setCreatedDate(unitBoundary.getCreatedDate());
        rv.setParentUnit(unitBoundary.getParentUnit());

        return rv;
    }


}
