package uz.Mongo.simpleCrud;

import lombok.*;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProjectColumns {

    @BsonProperty(value = "_id")
    private ObjectId id;

    private String name;

    public ProjectColumns(String name) {
        this.id = new ObjectId();
        this.name = name;
    }
}
