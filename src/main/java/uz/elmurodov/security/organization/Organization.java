package uz.elmurodov.security.organization;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import uz.elmurodov.security.Auditable;

@Data
public class Organization implements Auditable {
	private Object website;

	@SerializedName("reg_num")
	private String regNum;

	private String name;

	private Object logo;

	@SerializedName("created_at")
	private String createdAt;

	private String location;

	private Long id;

	@SerializedName("paid_for")
	private String paidFor;

	private Object email;
}