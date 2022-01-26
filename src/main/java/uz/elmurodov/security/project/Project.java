package uz.elmurodov.security.project;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import uz.elmurodov.security.Auditable;

@Data
public class Project implements Auditable {
    private Long id;

    private String code;

    private String tz;

    private String description;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("created_by")
    private Integer createdBy;

    @SerializedName("is_deleted")
    private Boolean isDeleted;

    @SerializedName("is_archived")
    private Boolean isArchived;

    @SerializedName("updated_at")
    private String updatedAt;

    private String background;

    @SerializedName("organization_id")
    private Integer organizationId;

    private String name;

    @SerializedName("updated_by")
    private Integer updatedBy;

    private Integer status;
}
