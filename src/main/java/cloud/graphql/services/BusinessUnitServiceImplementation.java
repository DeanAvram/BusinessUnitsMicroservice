package cloud.graphql.services;

import cloud.graphql.boundries.EmployeeBoundary;
import cloud.graphql.boundries.UnitBoundary;
import cloud.graphql.entites.UnitEntity;
import cloud.graphql.exception.BadRequestException;
import cloud.graphql.exception.NotFoundException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.regex.Pattern;

@Service
public class BusinessUnitServiceImplementation implements BusinessUnitService {

    private BusinessUnitCrud units;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");


    public BusinessUnitServiceImplementation(BusinessUnitCrud units) {
        this.units = units;
    }

    public Mono<UnitBoundary> initOrg(UnitBoundary unitBoundary) {
        return Mono.just(unitBoundary)
                .map(this::toEntity)
                .flatMap(this.units::save)
                .map(this::toBoundary);
    }


    public Mono<UnitBoundary> createOrg(UnitBoundary unitBoundary, String parentUnitId) {
        if(unitBoundary.getId() == null || unitBoundary.getId().isBlank())
            throw new BadRequestException("must fill id");
        return this.units.findById(unitBoundary.getId())
                .hasElement().flatMap(
                        exist -> {
                            if (exist)
                                return Mono.error(new BadRequestException("Unit " + unitBoundary.getId() + " already exists"));
                            else
                                return this.units.findById(parentUnitId)
                                        .switchIfEmpty(Mono.error(new NotFoundException("Parent unit " + parentUnitId + " not found")))
                                        .map(parentUnit -> {
                                            unitBoundary.setParentUnit(parentUnit.getId());
                                            return this.toEntity(unitBoundary);
                                        })
                                        .flatMap(entity -> this.units.save(entity).map(this::toBoundary));
                        }

                );
    }


    @Override
    public Mono<Void> cleanup() {
        return units.findByIdNot("org")
               .flatMap(units::delete)
              .then();
    }

    @Override
    public Flux<UnitBoundary> gelAll() {
        return units.findAll()
                .map(this::toBoundary);
    }

    @Override
    public Flux<UnitBoundary> getAllPageSize(int page, int size){
        return units.findAll()
                .skip(page * size)
                .take(size)
                .map(this::toBoundary);
    }

    public Mono<UnitBoundary> getOrgById(String id){
        return this.units.findById(id)
                .map(this::toBoundary)
                .switchIfEmpty(Mono.error(new NotFoundException("Unit " + id + " not found")));
    }

    @Override
    public Flux<UnitBoundary> getSubUnits(String id, int page, int size) {
        return this.units.findAllByParentUnit(id, PageRequest.of(page, size))
                .map(this::toBoundary);
    }

    @Override
    public Flux<EmployeeBoundary> getEmployees(String id, int page, int size) {
        return this.units.findById(id)
                .map(UnitEntity::getEmployees)
                .flatMapMany(Flux::fromIterable)
                .skip(page * size)
                .take(size);
    }

    public Mono<EmployeeBoundary> getSpecifEmployee(String email){
        return this.units.findAll()
                .map(UnitEntity::getEmployees)
                .flatMap(Flux::fromIterable)
                .filter(employeeBoundary -> employeeBoundary.getEmail().equals(email))
                .next();
    }

    public Flux<UnitBoundary> getUnitsOfEmployee(String email, int page, int size){
        return this.units.findAllByEmployees_Email(email, PageRequest.of(page, size))
                .map(this::toBoundary);
    }

    public Flux<UnitBoundary> getUnitsOfManager(String email, int page, int size){
        return this.units.findAllByManager(email, PageRequest.of(page, size))
                .map(this::toBoundary);
    }

    public Mono<EmployeeBoundary> addEmployeeToUnit(String unitId, EmployeeBoundary employeeBoundary){
            return this.units.findById(unitId)
                    .flatMap(unitEntity -> {
                        Set<EmployeeBoundary> employees = unitEntity.getEmployees();
                        employees.add(employeeBoundary);
                        unitEntity.setEmployees(employees);
                        return this.units.save(unitEntity).thenReturn(employeeBoundary);
                    });
        }



    private UnitBoundary toBoundary(UnitEntity unitEntity) {
        UnitBoundary rv = new UnitBoundary();

        rv.setId(unitEntity.getId());
        rv.setType(unitEntity.getType());
        rv.setManager(unitEntity.getManager());
        rv.setCreatedDate(unitEntity.getCreationDate());
        rv.setParentUnit(unitEntity.getParentUnit());
        rv.setEmployees(unitEntity.getEmployees());
        return rv;
    }

    private UnitEntity toEntity(UnitBoundary unitBoundary) {
        UnitEntity rv = new UnitEntity();
        rv.setId(unitBoundary.getId());
        rv.setType(unitBoundary.getType());
        if (unitBoundary.getManager().isEmpty())
            throw new BadRequestException("Manager cannot be empty");
        if (!isValidEmail(unitBoundary.getManager()))
            throw new BadRequestException("Invalid email format.");
        rv.setManager(unitBoundary.getManager());
        rv.setCreationDate(formatter.format(LocalDate.now()));
        rv.setParentUnit(unitBoundary.getParentUnit());
        for(EmployeeBoundary employeeBoundary : unitBoundary.getEmployees()){
            if (!isValidEmail(employeeBoundary.getEmail()))
                throw new BadRequestException("Invalid email format.");
        rv.setEmployees(unitBoundary.getEmployees());
        }
        return rv;
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}(\\.[A-Za-z]{2,})?$";
        Pattern pattern = Pattern.compile(emailRegex);
        return email != null && pattern.matcher(email).matches();
    }


}
