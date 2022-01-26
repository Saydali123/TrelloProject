package uz.elmurodov.dtos.permission;

import lombok.Data;
import uz.elmurodov.dtos.GenericDto;

@Data
public class PermissionSetDto extends GenericDto {
	private int permission;
}