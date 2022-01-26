package uz.elmurodov.security.auth;

import 	java.util.List;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import uz.elmurodov.security.Auditable;
import uz.elmurodov.security.organization.Organization;

@Data
public class Session implements Auditable {
	private String code;

	@SerializedName("is_super_user")
	private boolean isSuperUser;

	private List<RolesItem> roles;

	@SerializedName("last_name")
	private String lastName;

	@SerializedName("created_at")
	private String createdAt;

	private String language;

	private String phone;

	private List<PermissionsItem> permissions;

	private Organization organization;

	private Long id;

	@SerializedName("first_name")
	private String firstName;

	private String email;

	private String username;
}