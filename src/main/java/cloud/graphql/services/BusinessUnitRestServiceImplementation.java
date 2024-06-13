package cloud.graphql.services;

import cloud.graphql.boundries.UnitBoundary;
import reactor.core.publisher.Mono;

public class BusinessUnitRestServiceImplementation implements BusinessUnitRestService{

    private BusinessUnitCrud units;

    public BusinessUnitRestServiceImplementation(BusinessUnitCrud units) {
        this.units = units;
    }

    @Override
    public Mono<UnitBoundary> createOrg(String parentUnitId, UnitBoundary unitBoundary) {
        return null;
    }

    @Override
    public Mono<Void> cleanup() {
        return units.findByIdNot("org")
                .flatMap(units::delete)
                .then();
    }
}
