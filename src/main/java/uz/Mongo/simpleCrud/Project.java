package uz.Mongo.simpleCrud;

import lombok.*;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Project {

    @BsonProperty(value = "_id")
    private ObjectId id;

    private String name;

    private List<ProjectColumns> projectColumns;


    public Project(String name, List<ProjectColumns> projectColumns) {
        this.name = name;
        this.projectColumns = projectColumns;
    }
}
