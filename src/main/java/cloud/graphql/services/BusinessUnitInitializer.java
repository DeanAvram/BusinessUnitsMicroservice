package cloud.graphql.services;

import cloud.graphql.boundries.UnitBoundary;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BusinessUnitInitializer implements CommandLineRunner {

    private BusinessUnitService businessUnitRestService;

    public BusinessUnitInitializer(BusinessUnitService businessUnitRestService) {
        this.businessUnitRestService = businessUnitRestService;
    }

    @Override
    public void run(String... args){
        this.businessUnitRestService.cleanup().block();
        this.businessUnitRestService.initOrg(new UnitBoundary("org", "org",  "ceo@demo.org")).block();
        this.businessUnitRestService.createOrg(new UnitBoundary("Core_Division", "Core_Division",  "manager@rnd.demo.org"), "org").block();
        this.businessUnitRestService.createOrg(new UnitBoundary("Cloud_Team", "Cloud_Team",  "team.leader@rnd.demo.org"), "Core_Division").block();
        this.businessUnitRestService.createOrg(new UnitBoundary("DevOps_Team", "DevOps_Team",  "team.leader@devops.demo.org"), "Core_Division").block();
        this.businessUnitRestService.createOrg(new UnitBoundary("Logistics", "Logistics",  "manager@logistics.demo.org"), "org").block();
        this.businessUnitRestService.createOrg(new UnitBoundary("Marketing", "Marketing",  "manager@marteting.demo.org"), "org").block();
        this.businessUnitRestService.createOrg(new UnitBoundary("Sales", "Sales",  "manager@sales.demo.org"), "org").block();
        this.businessUnitRestService.createOrg(new UnitBoundary("Support", "Support",  "manager@support.demo.org"), "org").block();
        this.businessUnitRestService.createOrg(new UnitBoundary("Third_Level_Support", "Third_Level_Support",  "manager@support.demo.org"), "Support").block();
        this.businessUnitRestService.createOrg(new UnitBoundary("Post_Sale", "Post_Sale",  "manager@support.demo.org"), "Support").block();
        this.businessUnitRestService.createOrg(new UnitBoundary("Finance", "Finance",  "manager@fin.demo.org"), "org").block();
        this.businessUnitRestService.createOrg(new UnitBoundary("HR", "HR",  "manager@hr.demo.org"), "org").block();
    }
}
