package cloud.graphql.boundries;


import java.util.Set;

public class UnitBoundary {

    private String Id;
    private String type;
    private String creationDate;
    private EmployeeBoundary manager;
    private UnitBoundary parentUnit;
    private Set<EmployeeBoundary> employees;

    public UnitBoundary() {
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public EmployeeBoundary getManager() {
        return manager;
    }

    public void setManager(EmployeeBoundary manager) {
        this.manager = manager;
    }

    public UnitBoundary getParentUnit() {
        return parentUnit;
    }

    public void setParentUnit(UnitBoundary parentUnit) {
        this.parentUnit = parentUnit;
    }

    public Set<EmployeeBoundary> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<EmployeeBoundary> employees) {
        this.employees = employees;
    }
}
