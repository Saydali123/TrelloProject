package uz.elmurodov.dtos.task;

import com.google.gson.annotations.SerializedName;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.elmurodov.dtos.GenericBaseDto;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskCreateDto implements GenericBaseDto {
    private int level;

    @SerializedName("project_column_id")
    private Long projectColumnId;

    private String name;

    private String description;

    private String deadline;

    private int priority;

}