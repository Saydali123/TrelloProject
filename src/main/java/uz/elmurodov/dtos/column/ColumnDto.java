package uz.elmurodov.dtos.column;

import uz.elmurodov.dtos.GenericDto;
import uz.elmurodov.dtos.task.TaskDto;

import java.util.List;

public class ColumnDto extends GenericDto {

    private String emoji;

    private String name;

    private int order;

    private List<TaskDto> tasks;
}