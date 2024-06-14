package cloud.graphql.services;

import cloud.graphql.boundries.EmployeeBoundary;
import cloud.graphql.boundries.UnitBoundary;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BusinessUnitInitializer implements CommandLineRunner {

    private BusinessUnitRestService businessUnitRestService;

    public BusinessUnitInitializer(BusinessUnitRestService businessUnitRestService) {
        this.businessUnitRestService = businessUnitRestService;
    }

    @Override
    public void run(String... args) throws Exception {
        //check if org is exist and create if not
        //this.businessUnitRestService.getOrgById("org")
        //        .switchIfEmpty(this.businessUnitRestService.createOrg(null, new UnitBoundary("org", "org", "ceo@demo.org")));
        this.businessUnitRestService.createOrg(new UnitBoundary("org", "org",  "ceo@demo.org"), "").block();
    }
}
