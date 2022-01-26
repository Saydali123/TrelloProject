package uz.elmurodov.criterias;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserCriteria extends GenericCriteria {
    private Long organizationId;
}
