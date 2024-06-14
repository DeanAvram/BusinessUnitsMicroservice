package cloud.graphql.boundries;


public class UnitBoundary {

    private String id;
    private String type;
    private String creationDate;
    private EmployeeBoundary manager;
    private UnitBoundary parentUnit;
    //private Set<EmployeeBoundary> employees;

    public UnitBoundary() {
    }

    public UnitBoundary(String id, String type, EmployeeBoundary manager){
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

}
