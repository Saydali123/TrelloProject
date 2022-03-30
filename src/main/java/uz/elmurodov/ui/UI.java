package uz.elmurodov.ui;

import com.google.gson.Gson;
import uz.elmurodov.container.UNIContainer;
import uz.elmurodov.criterias.GenericCriteria;
import uz.elmurodov.dtos.column.ColumnCreateDto;
import uz.elmurodov.dtos.organization.OrganizationCreateDto;
import uz.elmurodov.dtos.organization.OrganizationUpdateDto;
import uz.elmurodov.dtos.project.ProjectCreateDto;
import uz.elmurodov.dtos.user.BlockUserDto;
import uz.elmurodov.exception.ApiRuntimeException;
import uz.elmurodov.response.Data;
import uz.elmurodov.response.ResponseEntity;
import uz.elmurodov.security.SecurityHolder;
import uz.elmurodov.security.organization.Point;
import uz.elmurodov.services.auth.AuthUserService;
import uz.elmurodov.services.column.ColumnService;
import uz.elmurodov.services.organization.OrganizationService;
import uz.elmurodov.services.project.ProjectService;
import uz.elmurodov.services.user.UserService;
import uz.elmurodov.utils.Color;
import uz.elmurodov.utils.Input;
import uz.elmurodov.utils.Print;

public class UI {
    private final AuthUserService authUserService;
    private final UserService userService;
    private final OrganizationService organizationService;
    private final ProjectService projectService = UNIContainer.getBean(ProjectService.class);
    private final ColumnService columnService = UNIContainer.getBean(ColumnService.class);


    public UI(AuthUserService authUserService, UserService userService, OrganizationService organizationService) {
        this.authUserService = authUserService;
        this.userService = userService;
        this.organizationService = organizationService;
    }

    /**
     * auth ui
     */
    public void login() {
        try {
            String username = Input.getStr("username ");
            String password = Input.getStr("password ");
            authUserService.login(username, password);
        } catch (ApiRuntimeException e) {
            showResponse(e.getMessage());
        }
    }

    public void userCreate() {
        try {
            String username = Input.getStr("username ");
            String password = Input.getStr("password ");
            authUserService.login(username, password);
        } catch (ApiRuntimeException e) {
            showResponse(e.getMessage());
        }
    }

    public void userBlock() {
        Long userId = (long) Input.getNum("User Id : ");
        String blockedFor = Input.getStr("Reason : ");
        String blockedTill = Input.getStr("Blocked Till () : ");
        BlockUserDto blockDto = new BlockUserDto(userId, blockedFor, blockedTill);
        userService.block(blockDto);
    }

    public void userDelete() {
        try {
            Long userid = (long) Input.getNum("UserID: ");
            userService.delete(userid);
        } catch (ApiRuntimeException e) {
            showResponse(e.getMessage());
        }
    }

    public void userList() {

    }

    public void userDetails() {

    }

    public void userUnblock() {

    }


    public void organizationCreate() {
        try {
            String name = Input.getStr("Enter name: ");
            String website = Input.getStr("Enter website: ");
            String logo = Input.getStr("Enter logo: ");
            String reg_number = Input.getStr("Enter reg_number: ");
            double latitude = Double.parseDouble(Input.getStr("Latitude: "));
            double longitude = Double.parseDouble(Input.getStr("Longitude: "));
            Point point = new Point(latitude, longitude);
            String email = Input.getStr("Enter email: ");
            OrganizationCreateDto dto = new OrganizationCreateDto(reg_number, name);
            ResponseEntity<Data<Long>> response = organizationService.create(dto);
            showResponse(Color.GREEN, response.getBody());
        } catch (ApiRuntimeException e) {
            showResponse(e.getMessage());
        }
    }

    public void deleteOrganization() {
        try {
            long orgId = (long) Input.getNum("Organization ID : ");
            organizationService.delete(orgId);
            showResponse(Color.GREEN, "Success");
        } catch (ApiRuntimeException e) {
            showResponse(e.getMessage());
        }
    }

    public void organizationUpdate() {
        try {
            OrganizationUpdateDto dto = new OrganizationUpdateDto();
            long organizationId = (long) Input.getNum("Organization Id : ");
            String email = Input.getStr("Email : ");
            String website = Input.getStr("Website : ");
            String logo = Input.getStr("Logo : ");
            String location = Input.getStr("Location : ");
            dto.setEmail(email);
            dto.setLocation(location);
            dto.setWebsite(website);
            dto.setLogo(logo);
            dto.setId(organizationId);
            organizationService.update(dto);
            showResponse(Color.GREEN, "Success");
        } catch (ApiRuntimeException e) {
            showResponse(e.getMessage());
        }
    }

    public void organizationBlock() {

    }

    public void organizationUnblock() {
    }

    public void organizationDelete() {
    }

    public void organizationGet() {

    }

    public void organizationList() {
        try {
            showResponse(Color.GREEN, UNIContainer.getBean(Gson.class).toJson(organizationService.list(new GenericCriteria()).getBody()));
        } catch (ApiRuntimeException e) {
            showResponse(e.getMessage());
        }
    }


    private <T> void showResponse(String color, T response) {
        Print.println(color, response);
    }

    private <T> void showResponse(T response) {
        showResponse(Color.RED, response);
    }

    public void loginAsSuper() {
        String username = "hello";
        String password = "@helloHello007_";
        authUserService.login(username, password);
    }

    public void loginAsAdmin() {

    }

    public void loginAsHr() {

    }

    public void loginAsEmp() {

    }


    public void projectCreate() {
        ProjectCreateDto dto = new ProjectCreateDto();
        String name = Input.getStr("Name : ");
        String tz = Input.getStr("Tz : ");
        String description = Input.getStr("Desctiption : ");
        dto.setName(name);
        dto.setDescription(description);
        dto.setTz(tz);
        dto.setBackground("grey");
        dto.setOrganizationId(SecurityHolder.authUserSession.getOrganization().getId());
        ResponseEntity<Data<Long>> response = projectService.create(dto);
        showResponse(response);
    }


    public void columnCreate() {
        try {
            ColumnCreateDto dto = new ColumnCreateDto();
            String name = Input.getStr("Name : ");
            String emoji = Input.getStr("Emoji : ");
            long project_id = (long) Input.getNum("Project ID: ");
            dto.setEmoji(emoji);
            dto.setName(name);
            dto.setProjectId(project_id);
            ResponseEntity<Data<Long>> response = columnService.create(dto);
            showResponse(Color.GREEN, response);
        } catch (ApiRuntimeException e) {
            showResponse(e.getMessage());
        }
    }

    public void projectDetails() {

    }

    public void logout() {
        authUserService.logout();
        Print.println(Color.BLUE, "Bye...");
    }
}
