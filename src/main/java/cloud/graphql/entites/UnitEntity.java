package cloud.graphql.entites;

import cloud.graphql.boundries.EmployeeBoundary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Document(collection = "BUSINESS_UNIT")
public class UnitEntity {

    @Id
    private String id;
    private String type;
    private String creationDate;
    private String manager;
    private String parentUnit;
    private Set<EmployeeBoundary> employees;

    public UnitEntity() {
        this.employees =  new HashSet<>();
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

    @Override
    public String toString() {
        return "UnitEntity{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", creationDate='" + creationDate + '\'' +
                ", manager='" + manager + '\'' +
                ", parentUnit='" + parentUnit + '\'' +
                ", employees=" + employees +
                '}';
    }
}
