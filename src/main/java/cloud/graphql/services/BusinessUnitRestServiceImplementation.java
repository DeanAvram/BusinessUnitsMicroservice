package cloud.graphql.services;

import cloud.graphql.boundries.EmployeeBoundary;
import cloud.graphql.boundries.UnitBoundary;
import cloud.graphql.entites.UnitEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class BusinessUnitRestServiceImplementation implements BusinessUnitRestService{

    private BusinessUnitCrud units;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");


    public BusinessUnitRestServiceImplementation(BusinessUnitCrud units) {
        this.units = units;
    }


    @Override
    public Mono<UnitBoundary> createOrg(UnitBoundary unitBoundary, String parentUnitId) {
        return Mono.just(unitBoundary)
                .map(this::toEntity)
                .flatMap(this.units::save)
                .map(this::toBoundary);
    }


    @Override
    public Mono<Void> cleanup() {
        /*return units.findByIdNot("org")
                .flatMap(units::delete)
                .then();*/
        return units.deleteAll();
    }

    @Override
    public Flux<UnitBoundary> gelAll() {
        return units.findAll()
                .map(this::toBoundary);
    }


    private UnitBoundary toBoundary(UnitEntity unitEntity) {
        UnitBoundary rv = new UnitBoundary();

        rv.setId(unitEntity.getId());
        rv.setType(unitEntity.getType());
        rv.setManager(unitEntity.getManager());
        rv.setCreationDate(unitEntity.getCreationDate());

        return rv;
    }

    private UnitEntity toEntity(UnitBoundary unitBoundary) {
        UnitEntity rv = new UnitEntity();

        rv.setId(unitBoundary.getId());
        rv.setType(unitBoundary.getType());
        rv.setManager(unitBoundary.getManager());
        rv.setCreationDate(formatter.format(LocalDate.now()));

        return rv;
    }


}
