package uz.Mongo.b3;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

import java.util.Objects;

@ToString
@Getter
@Setter
public class Student {

    @BsonProperty(value = "_id")
    private ObjectId id;
    private String name;
    private Long age;
    private Address address;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id.equals(student.id) && name.equals(student.name) && age.equals(student.age) && address.equals(student.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, address);
    }
}
