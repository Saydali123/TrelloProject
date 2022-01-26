package uz.elmurodov.security.task;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import uz.elmurodov.security.Auditable;


@Data
public class Task implements Auditable {
    private Long id;

    private String level;

    private int projectColumnId;

    private String description;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("created_by")
    private Integer createdBy;

    private String priority;

    private boolean isDeleted;

    @SerializedName("updated_at")
    private String updatedAt;

    private String name;

    @SerializedName("updated_by")
    private Integer updatedBy;

    private String deadline;

    private int order;
}
