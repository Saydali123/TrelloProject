package uz.elmurodov.dtos.auth;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import uz.elmurodov.dtos.GenericDto;

@Data
public class UserUpdateDto extends GenericDto {
	private String phone;

	@SerializedName("last_name")
	private String lastName;

	private String language;

	private Long id;

	@SerializedName("first_name")
	private String firstName;

	private String email;

	private String username;
}