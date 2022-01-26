package uz.elmurodov.ui.column;/*
package uz.elmurodov.ui.column;

import uz.elmurodov.enums.HttpStatus;
import uz.elmurodov.response.Data;
import uz.elmurodov.response.ResponseEntity;
import uz.elmurodov.security.column.Column;
import uz.elmurodov.security.column.TasksItem;
import uz.elmurodov.services.column.ColumnService;
import uz.elmurodov.ui.BaseUI;
import uz.jl.utils.Color;
import uz.jl.utils.Input;
import uz.jl.utils.Print;

import java.util.List;

import static org.apache.commons.lang3.StringUtils.isNumeric;

public class ColumnUI extends BaseUI<ColumnService> {

    public ColumnUI(ColumnService service) {
        super(service);
    }

    @Override
    public void create() {
        String columnName = Input.getStr("Name of column");
    }

    @Override
    public void block() {

    }

    @Override
    public void unblock() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void update() {

    }

    @Override
    public void get() {

    }

    @Override
    public void list() {
        String projectId = Input.getStr("Enter project id: ");
        if (!isNumeric(projectId)) {
            Print.println(Color.RED, "Wrong input");
        }
        ResponseEntity<Data<?>> response = service.list(Long.parseLong(projectId));
        if (!response.getStatus().equals(HttpStatus.HTTP_200.getCode())) {
            Print.println(Color.RED, response.getBody().getData());
            return;
        }
        List<Column> columns = (List<Column>) response.getBody().getData();

        for (int i = 0; i < columns.size(); i++) {
            Column column = columns.get(i);
            Print.println(Color.YELLOW, "--------------------------------------------------------------");
            Print.println(Color.BLUE, (i + 1) + ". " + column.getName());
            Print.println(Color.YELLOW, "--------------------------------------------------------------");
            List<TasksItem> tasks = column.getTasks();
            for (int j = 0; j < tasks.size(); j++) {
                TasksItem task = tasks.get(j);
                Print.println(Color.BLUE, (j + 1) + ". " + task.getName());
            }
        }
        Print.println(Color.YELLOW, "--------------------------------------------------------------");

    }

    public void memberList() {
    }

    public void memberDelete() {
    }

    public void updateMember() {
    }
}
*/
