package uz.Mongo.b3;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class Todo extends Audit {
    String till;
    String aim;
    String title;
}