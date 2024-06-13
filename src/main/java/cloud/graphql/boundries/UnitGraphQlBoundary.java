package cloud.graphql.boundries;


public class UnitGraphQlBoundary {

    private String Id;
    private String type;
    private String creationDate;
    private EmployeeBoundary manager;
    private UnitGraphQlBoundary parentUnit;

    public UnitGraphQlBoundary() {
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

    public UnitGraphQlBoundary getParentUnit() {
        return parentUnit;
    }

    public void setParentUnit(UnitGraphQlBoundary parentUnit) {
        this.parentUnit = parentUnit;
    }
}
