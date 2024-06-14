package cloud.graphql.cotrollers;

import cloud.graphql.boundries.EmployeeGraphQlBoundary;
import cloud.graphql.boundries.UnitGraphQlBoundary;
import cloud.graphql.services.BusinessUnitGraphQlService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Controller
public class BusinessUnitGraphQlController {

    private BusinessUnitGraphQlService businessUnitGraphQlService;

    public BusinessUnitGraphQlController(BusinessUnitGraphQlService businessUnitGraphQlService) {
        this.businessUnitGraphQlService = businessUnitGraphQlService;
    }

    @QueryMapping
    public Mono<UnitGraphQlBoundary> getUnitById(
            @Argument String id){
        return this.businessUnitGraphQlService
                .getSpecificUnit(id);
    }

    @QueryMapping
    public Mono<EmployeeGraphQlBoundary> getEmployeeByEmail(
            @Argument String email){
        return this.businessUnitGraphQlService
                .getSpecifEmployee(email);

    }

    @SchemaMapping
    public Flux<UnitGraphQlBoundary> getAllUnits(
            @Argument int page,
            @Argument int size){
        return this.businessUnitGraphQlService
                .getAllUnits(page,size);


    }



}
