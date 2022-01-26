package uz.elmurodov.dtos.auth;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import uz.elmurodov.dtos.GenericBaseDto;
@AllArgsConstructor
@Data
public class UserCreateDto implements GenericBaseDto {
    private String password;
    private String phone;
    @SerializedName("organization_id")
    private int organizationId;
    @SerializedName("last_name")
    private String lastName;
    private String language;
    @SerializedName("first_name")
    private String firstName;
    private String email;
    private String username;
}