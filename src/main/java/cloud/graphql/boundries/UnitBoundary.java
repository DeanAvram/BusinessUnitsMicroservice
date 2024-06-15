package cloud.graphql.boundries;


import java.util.HashSet;
import java.util.Set;

public class UnitBoundary {

    private String id;
    private String type;
    private String creationDate;
    private String manager;
    private String parentUnit;
    private Set<EmployeeBoundary> employees;

    public UnitBoundary() {
        this.employees = new HashSet<>();
    }

    public UnitBoundary(String id, String type, String manager) {
        this();
        this.id = id;
        this.type = type;
        this.manager = manager;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getParentUnit() {
        return parentUnit;
    }

    public void setParentUnit(String parentUnit) {
        this.parentUnit = parentUnit;
    }

    public Set<EmployeeBoundary> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<EmployeeBoundary> employees) {
        this.employees = employees;
    }

}
