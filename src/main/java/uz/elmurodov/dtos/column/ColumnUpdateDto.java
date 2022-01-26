package uz.elmurodov.dtos.column;

import lombok.Data;
import uz.elmurodov.dtos.GenericDto;

@Data
public class ColumnUpdateDto extends GenericDto {

    private String emoji;

    private String name;

    private int order;
}