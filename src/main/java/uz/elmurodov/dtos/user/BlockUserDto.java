package uz.elmurodov.dtos.user;

import lombok.Getter;
import lombok.Setter;
import uz.elmurodov.dtos.GenericDto;

@Getter
@Setter
public class BlockUserDto extends GenericDto {
    private String blockedFor;
    private String blockedTill;

    public BlockUserDto(Long id, String blockedFor, String blockedTill) {
        super(id);
        this.blockedFor = blockedFor;
        this.blockedTill = blockedTill;
    }
}
