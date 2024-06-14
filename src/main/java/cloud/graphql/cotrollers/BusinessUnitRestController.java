package cloud.graphql.cotrollers;

import cloud.graphql.boundries.UnitBoundary;
import cloud.graphql.services.BusinessUnitRestService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = {"/org"})
public class BusinessUnitRestController {


    private BusinessUnitRestService businessUnitService;

    public BusinessUnitRestController(BusinessUnitRestService businessUnitService) {
        this.businessUnitService = businessUnitService;
    }

    @GetMapping(
            produces = {MediaType.TEXT_EVENT_STREAM_VALUE}
    )
    public Flux<UnitBoundary> getAllUnits(){
        return this.businessUnitService.gelAll();
    }

    @DeleteMapping
    public Mono<Void> deleteAllUnits(){
        return this.businessUnitService.cleanup();
    }
}
