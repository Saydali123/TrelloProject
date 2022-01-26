package uz.elmurodov.dtos.column;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import uz.elmurodov.dtos.GenericBaseDto;

@Data
public class ColumnCreateDto implements GenericBaseDto {
    private String emoji;
    @SerializedName("project_id")
    private long projectId;

    private String name;

    private int order;
}