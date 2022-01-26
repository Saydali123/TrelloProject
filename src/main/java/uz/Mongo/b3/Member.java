package uz.Mongo.b3;

import org.bson.types.ObjectId;

public class Member extends Audit {
    private String username;
    private String age;

    public Member() {
    }

    public Member(String username, String age) {
        super(new ObjectId());
        this.username = username;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
