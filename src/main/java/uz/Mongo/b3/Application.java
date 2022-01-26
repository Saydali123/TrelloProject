package uz.Mongo.b3;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.types.ObjectId;

import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class Application {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger("org.mongodb.driver");
        logger.setLevel(Level.SEVERE);
        ConnectionString connectionString =
                new ConnectionString("mongodb://localhost:27017");
        CodecRegistry pojoCodecRegistry =
                fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry =
                fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);

        MongoClientSettings clientSettings = MongoClientSettings.builder().
                applyConnectionString(connectionString).codecRegistry(codecRegistry).build();


        try (MongoClient client = MongoClients.create(clientSettings);) {
            MongoDatabase db = client.getDatabase("test");
            MongoCollection<Project> projectCollection =
                    db.getCollection("projects", Project.class);
//            createProject(projectCollection);
            Project project = projectCollection.find(Filters.eq("_id",
                    new ObjectId("61ef79806104bff139b92198"))).first();
            if (project != null) {
                project.getTasks().add(
                        new Task("Nimadir", Collections.singletonList(
                                new Member("Najmiddin", "11"))));
                projectCollection.updateOne(
                        Filters.eq("_id", new ObjectId("61ef79806104bff139b92198")),
                        Updates.addEachToSet("tasks", project.getTasks()));
            }

            /*for (Project project : projectCollection.find()) {
                System.out.println(project);
            }*/
        }
    }

    private static void createProject(MongoCollection<Project> projectCollection) {
        Project project = new Project();

        List<Member> members1 = List.of(new Member("Choxista", "14"), new Member("Maman", "21"), new Member("Asliddin", "18"));

        List<Member> members2 = List.of(new Member("Choxista", "14"));

        List<Task> tasks = List.of(new Task("Imtihonga tayyorlanish", members1), new Task("Yakshanba kun choyxona", members2));
        project.setTasks(tasks);
        projectCollection.insertOne(project);
    }
}
