package uz.elmurodov.dtos.organization;

import lombok.Data;
import uz.elmurodov.dtos.GenericDto;

@Data
public class OrganizationUpdateDto extends GenericDto {
	private String website;
	private String name;
	private String logo;
	private String  location;
	private String email;
}