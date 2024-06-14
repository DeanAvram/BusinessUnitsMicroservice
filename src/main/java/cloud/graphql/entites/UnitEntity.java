package cloud.graphql.entites;

import cloud.graphql.boundries.EmployeeBoundary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "BUSINESS_UNIT")
public class UnitEntity {

    @Id private String id;
    private String type;
    private String creationDate;
    private EmployeeBoundary manager;

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

    public EmployeeBoundary getManager() {
        return manager;
    }

    public void setManager(EmployeeBoundary manager) {
        this.manager = manager;
    }
}
