package cloud.graphql.cotrollers;

import cloud.graphql.boundries.EmployeeGraphQlBoundary;
import cloud.graphql.boundries.UnitBoundary;
import cloud.graphql.boundries.UnitGraphQlBoundary;
import cloud.graphql.services.BusinessUnitService;
import org.springframework.graphql.data.method.annotation.Argument;
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
    public Mono<UnitGraphQlBoundary> getUnitById(
            @Argument String id){
        return this.businessUnitService
                .getOrgById(id)
                .map(this::toUnitGraphBoundary);
    }

    @QueryMapping
    public Mono<EmployeeGraphQlBoundary> getEmployeeByEmail(
            @Argument String email){
        return null;
        //return this.businessUnitService
        //.getSpecifEmployee(email);

    }

    @SchemaMapping
    public Flux<UnitGraphQlBoundary> subUnits (
            UnitGraphQlBoundary unit,
            @Argument int page,
            @Argument int size){
        return this.businessUnitService
                .getSubUnits(unit.getId(), size, page)
                .map(this::toUnitGraphBoundary);
    }


    /*@SchemaMapping
    public Flux<UnitGraphQlBoundary> getAllUnits(
            @Argument int page,
            @Argument int size){
        return this.businessUnitGraphQlService
                .getAllUnits(page,size);


    }*/

    private UnitGraphQlBoundary toUnitGraphBoundary(UnitBoundary unitBoundary) {
        UnitGraphQlBoundary rv = new UnitGraphQlBoundary();

        rv.setId(unitBoundary.getId());
        rv.setType(unitBoundary.getType());
        rv.setManager(unitBoundary.getManager());
        rv.setCreationDate(unitBoundary.getCreationDate());

        return rv;
    }



}
