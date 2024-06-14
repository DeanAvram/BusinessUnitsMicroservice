package cloud.graphql.entites;

import cloud.graphql.boundries.EmployeeBoundary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document(collection = "BUSINESS_UNIT")
public class UnitEntity {

    @Id
    private String id;
    private String type;
    private String creationDate;
    private String manager;
    private String parentUnit;
    private Set<String> employees;

    public UnitEntity() {
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

    public Set<String> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<String> employees) {
        this.employees = employees;
    }
}
