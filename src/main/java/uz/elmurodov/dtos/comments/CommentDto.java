package uz.elmurodov.dtos.comments;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.elmurodov.dtos.GenericDto;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto extends GenericDto {
    private String text;
    private Date createdAt;
    private Long createdBy;
}
