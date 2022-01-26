package uz.elmurodov.ui.task;/*
package uz.elmurodov.ui.task;

import uz.elmurodov.container.UNIContainer;
import uz.elmurodov.dtos.task.TaskCreateDto;
import uz.elmurodov.dtos.task.TaskUpdateDto;
import uz.elmurodov.enums.HttpStatus;
import uz.elmurodov.response.Data;
import uz.elmurodov.response.ResponseEntity;
import uz.elmurodov.security.auth.Session;
import uz.elmurodov.security.task.Task;
import uz.elmurodov.services.project.ProjectService;
import uz.elmurodov.services.task.TaskService;
import uz.elmurodov.ui.BaseUI;
import uz.elmurodov.ui.project.ProjectUI;
import uz.jl.utils.Color;
import uz.jl.utils.Input;
import uz.jl.utils.Print;

import java.util.List;

import static org.apache.commons.lang3.StringUtils.isNumeric;

public class TaskUI extends BaseUI<TaskService> {

    public TaskUI(TaskService service) {
        super(service);
    }

    @Override
    public void create() {
        String columnID = Input.getStr("Column id: ");
        if (!isNumeric(columnID)) {
            Print.println(Color.RED, "Wrong input");
            return;
        }
        String name = Input.getStr("Enter name: ");
        String description = Input.getStr("Enter description: ");
        String deadline = Input.getStr("Enter deadline\n(2012-12-12 12:12:12)\n: ");
        int priority = Input.getNum("Enter priority: ");
        int level = Input.getNum("Enter level\n(HARD/MEDIUM/EASY)\n: ");
        TaskCreateDto dto = new TaskCreateDto(level, Long.valueOf(columnID), name, description, deadline, priority);

        ResponseEntity<Data<?>> response = service.create(dto);
        if (!response.getStatus().equals(HttpStatus.HTTP_200.getCode())) {
            Print.println(Color.RED, response.getBody().getData());
        } else {
            Print.println(Color.GREEN, "Created task");
        }
    }

    @Override
    public void block() {
    }

    @Override
    public void unblock() {
    }

    @Override
    public void delete() {
        String taskId = Input.getStr("Enter task id: ");
        if (!isNumeric(taskId)) {
            Print.println(Color.RED, "Wrong input");
            return;
        }
        ResponseEntity<Data<?>> response = service.delete(Long.valueOf(taskId));
        if (!response.getStatus().equals(HttpStatus.HTTP_200.getCode())) {
            Print.println(Color.RED, response.getBody().getData());
        } else {
            Print.println(Color.GREEN, "Successfully deleted");
        }
    }

    @Override
    public void update() {
        String taskId = Input.getStr("Enter task id: ");
        if (!isNumeric(taskId)) {
            Print.println(Color.RED, "Wrong input");
            return;
        }
        String columnId = Input.getStr("Enter column id: ");
        if (!isNumeric(columnId)) {
            Print.println(Color.RED, "Wrong input");
            return;
        }
        String name = Input.getStr("Enter name: ");
        String description = Input.getStr("Enter description: ");
        String deadline = Input.getStr("Enter deadline\n(2012-12-12 12:12:12)\n: ");
        int priority = Input.getNum("Enter priority: ");
        int level = Input.getNum("Enter level\n(3=HARD/2=MEDIUM/1=EASY)\n: ");
        int order = Input.getNum("Enter order: ");
        String message = Input.getStr("Enter message: ");
        TaskUpdateDto dto = new TaskUpdateDto(level, Long.valueOf(columnId), name, description, deadline, priority, order, message);
        ResponseEntity<Data<?>> response = service.update(dto);
        if (!response.getStatus().equals(HttpStatus.HTTP_200.getCode())) {
            Print.println(Color.RED, response.getBody().getData());
        } else {
            Print.println(Color.GREEN, "Updated");
        }
    }

    @Override
    public void get() {
        String taskId = Input.getStr("Enter task id: ");
        if (!isNumeric(taskId)) {
            Print.println(Color.RED, "Wrong input");
            return;
        }
        ResponseEntity<Data<?>> response = service.get(Long.valueOf(taskId));
        if (!response.getStatus().equals(HttpStatus.HTTP_200.getCode())) {
            Print.println(Color.RED, response.getBody().getData());
        } else Print.println(Color.BLUE, response.getBody().getData());
    }

    @Override
    public void list() {
        ResponseEntity<Data<?>> response = service.list();
        if (!response.getStatus().equals(HttpStatus.HTTP_200.getCode())) {
            Print.println(Color.RED, response.getBody().getData());
        } else {
            List<Task> tasks = (List<Task>) response.getBody().getData();
            int i = 1;
            for (Task task : tasks) {
                Print.println(Color.BLUE, i++ + ". " + task.getName());
            }
        }
//        Print.println(service.list());
//        ResponseEntity<Data<?>> response =  service.list();
//        List<Task> taskList = (List<Task>) response.getBody().getData();
//        for (int i = 0; i < taskList.size(); i++) {
//            Print.println(Color.BLUE, (i+1) + ". " + taskList.get(i).getName());
//        }
    }

    public void get(Long taskId) {
        ResponseEntity<Data<?>> response = service.get(taskId);
        if (!response.getStatus().equals(HttpStatus.HTTP_200.getCode())) {
            Print.println(Color.RED, response.getBody().getData());
        } else Print.println(Color.BLUE, response.getBody().getData());
    }

    public void addMember() {
        ProjectUI projectUI = UNIContainer.getBean(ProjectUI.class);
        ProjectService projectService = UNIContainer.getBean(ProjectService.class);
        String projectId = Input.getStr("Enter project id: ");
        if (!isNumeric(projectId)) {
            Print.println(Color.RED, "Wrong inpuit");
            return;
        }
        ResponseEntity<Data<?>> response = projectService.getMembers(Long.valueOf(projectId));
        List<Session> authUsers = (List<Session>) response.getBody().getData();
        for (Session authUser : authUsers) {
            Print.println(Color.BLUE, authUser.getUsername());
        }
        String memberId = Input.getStr("Enter user id: ");

    }

    public void removeMember() {

    }

    public void addComment() {
        String yourComment = Input.getStr("Add a comment : ");
        TaskUpdateDto dto = new TaskUpdateDto();
        dto.setMessage(yourComment);
        ResponseEntity<Data<?>> response = service.addComment(dto);
        if (!response.getStatus().equals(HttpStatus.HTTP_200.getCode())) {
            Print.println(Color.RED, response.getBody().getData());
        } else Print.println(Color.BLUE, "Your comment Successfully added");

    }
}
*/
