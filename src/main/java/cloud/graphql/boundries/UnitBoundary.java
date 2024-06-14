package cloud.graphql.boundries;


import java.util.Set;

public class UnitBoundary {

    private String id;
    private String type;
    private String creationDate;
    private String manager;
    //private UnitBoundary parentUnit;
    //private Set<EmployeeBoundary> employees;

    public UnitBoundary() {
    }

    public UnitBoundary(String id, String type, String manager){
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

    /*public UnitBoundary getParentUnit() {
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

    @Override
    public String toString() {
        return "UnitBoundary{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", creationDate='" + creationDate + '\'' +
                ", manager='" + manager + '\'' +
                ", parentUnit=" + parentUnit +
                ", employees=" + employees +
                '}';
    }*/

    @Override
    public String toString() {
        return "UnitBoundary{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", creationDate='" + creationDate + '\'' +
                ", manager='" + manager + '\'' +
                '}';
    }
}
