package uz.elmurodov.ui.organization;/*
package uz.elmurodov.ui.organization;

import uz.elmurodov.container.UNIContainer;
import uz.elmurodov.dtos.organization.OrganizationUpdateDto;
import uz.elmurodov.enums.HttpStatus;
import uz.elmurodov.response.Data;
import uz.elmurodov.response.ResponseEntity;
import uz.elmurodov.security.SecurityHolder;
import uz.elmurodov.services.organization.OrganizationService;
import uz.elmurodov.ui.BaseUI;
import uz.elmurodov.utils.BaseUtils;
import uz.jl.utils.Color;
import uz.jl.utils.Input;
import uz.jl.utils.Print;

public class OrganizationUI extends BaseUI<OrganizationService> {
    private static final OrganizationService organizationService = UNIContainer.getBean(OrganizationService.class);

    public OrganizationUI(OrganizationService service) {
        super(service);
    }

    @Override
    public void create() {

    }

    @Override
    public void block() {

    }

    @Override
    public void unblock() {

    }

    @Override
    public void delete() {
        Long organizationId = SecurityHolder.authUserSession.getOrganization().getId();
        ResponseEntity<Data<?>> response = organizationService.delete(organizationId);
        if (!response.getStatus().equals(HttpStatus.HTTP_200.getCode())) {
            Print.println(Color.RED, response.getBody().getData());
        } else {
            Print.println(Color.GREEN, "Successfully deleted");
        }
    }

    @Override
    public void update() {
        OrganizationUpdateDto dto = new OrganizationUpdateDto();
        int organizationId = Input.getNum("Organization Id : ");
        String email = Input.getStr("Email : ");
        String website = Input.getStr("Website : ");
        String logo = Input.getStr("Logo : ");
        String location = Input.getStr("Location : ");
        dto.setEmail(email);
        dto.setLocation(location);
        dto.setWebsite(website);
        dto.setLogo(logo);
        dto.setId((long) organizationId);
        ResponseEntity<Data<?>> response = organizationService.update(dto);
        if (!response.getStatus().equals(HttpStatus.HTTP_200.getCode())) {
            Print.println(Color.RED, response.getBody().getData());
        } else {
            Print.println(Color.GREEN, "Successfully blocked project");
        }
    }

    @Override
    public void get() {
        Long organizationId = SecurityHolder.authUserSession.getOrganization().getId();
        ResponseEntity<Data<?>> response = service.get(organizationId);
        if (!response.getStatus().equals(HttpStatus.HTTP_200.getCode())) {
            Print.println(Color.RED, response.getBody().getData());

        } else Print.println(Color.BLUE, response.getBody().getData());
    }

    @Override
    public void list() {
        ResponseEntity<Data<?>> response = service.list();
        if (!response.getStatus().equals(HttpStatus.HTTP_200.getCode())) {
            Print.println(response.getBody());
        } else {
            Print.println(BaseUtils.gson.toJson(response.getBody()));
        }
    }
}
*/
