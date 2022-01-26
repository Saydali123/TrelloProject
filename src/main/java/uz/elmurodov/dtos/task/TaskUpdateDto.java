package uz.elmurodov.dtos.task;

import com.google.gson.annotations.SerializedName;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.elmurodov.dtos.GenericDto;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TaskUpdateDto extends GenericDto {
	private int level;

	@SerializedName("project_column_id")
	private Long projectColumnId;

	private String name;

	private String description;

	private String deadline;

	private int priority;

	private int order;

	private String message;
}