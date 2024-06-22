package cloud.graphql.cotrollers;

import cloud.graphql.boundries.UnitBoundary;
import cloud.graphql.services.BusinessUnitService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = {"/org"})
public class BusinessUnitRestController {


    private BusinessUnitService businessUnitService;

    public BusinessUnitRestController(BusinessUnitService businessUnitService) {
        this.businessUnitService = businessUnitService;
    }

    @GetMapping(
            produces = {MediaType.TEXT_EVENT_STREAM_VALUE}
    )
    public Flux<UnitBoundary> getAllUnits(){
        return this.businessUnitService.gelAll();
    }

    @PostMapping(
            path={"/{existingParentUnitId}"},
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Mono<UnitBoundary> create(
            @RequestBody UnitBoundary unitBoundary,
            @PathVariable(name = "existingParentUnitId") String existingParentUnitId){
        return this.businessUnitService.createOrg(unitBoundary, existingParentUnitId);
    }


    @DeleteMapping
    public Mono<Void> deleteAllUnits(){
        return this.businessUnitService.cleanup();
    }
}
