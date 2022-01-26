package uz.Mongo.b3;

import lombok.*;

import java.util.List;


@Getter
@Setter
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class Project extends Audit {

    private String name;

    private String description;

    private String path;

    private boolean closed;

    private boolean deleted;

    private List<Task> tasks;
}
