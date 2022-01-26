package uz.elmurodov.criterias;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ColumnCriteria extends GenericCriteria {
    private Long projectId;
}
