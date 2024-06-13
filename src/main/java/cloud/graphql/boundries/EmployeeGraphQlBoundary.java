package cloud.graphql.boundries;

import java.util.Set;

public class EmployeeGraphQlBoundary {

    private String email;
    private Set<UnitBoundary> units;

    public EmployeeGraphQlBoundary() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<UnitBoundary> getUnits() {
        return units;
    }

    public void setUnits(Set<UnitBoundary> units) {
        this.units = units;
    }

}
