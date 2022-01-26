package uz.Mongo.b3.crud;

import lombok.*;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

/**
 * @author Saydali Murodullayev, Tue 11:29 AM. 1/25/2022
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Todo {
    @BsonProperty(value = "_id")
    private ObjectId id;
    private String title;
    private String description;
}