package uz.Mongo.b3;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

@ToString
@Getter
@Setter
public class Audit {
    @BsonProperty(value = "_id")
    private ObjectId id;

    public Audit() {
        this.id = new ObjectId();
    }

    public Audit(ObjectId id) {
        this.id = id;
    }
}
