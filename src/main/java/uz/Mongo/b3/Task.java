package uz.Mongo.b3;

import lombok.*;
import org.bson.types.ObjectId;

import java.util.List;

@Getter
@Setter
@ToString(callSuper = true)
public class Task extends Audit {
    private String title;
    private boolean deleted;
    private List<Member> members;

    public Task() {
    }

    public Task(String title, boolean deleted, List<Member> members) {
        this.title = title;
        this.deleted = deleted;
        this.members = members;
    }

    public Task( String title, List<Member> members) {
        this.title = title;
        this.members = members;
    }
}
