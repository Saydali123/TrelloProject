package uz.elmurodov.dtos.project;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import uz.elmurodov.dtos.GenericBaseDto;

@Data
public class ProjectCreateDto implements GenericBaseDto {
	private String tz;
	private String background;
	@SerializedName("organization_id")
	private long organizationId;
	private String name;
	private String description;
}