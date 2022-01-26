package uz.Mongo.simpleCrud;

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
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class Application {
    public static void main(String[] args) {


        Logger logger = Logger.getLogger("org.mongodb.driver");
        logger.setLevel(Level.OFF);

        ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017");

        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());

        CodecRegistry codecRegistry = fromRegistries(
                MongoClientSettings.getDefaultCodecRegistry(),
                pojoCodecRegistry);

        MongoClientSettings clientSettings = MongoClientSettings
                .builder()
                .applyConnectionString(connectionString)
                .codecRegistry(codecRegistry)
                .build();

        MongoClient mongoClient = MongoClients.create(clientSettings);
        MongoDatabase b4test = mongoClient.getDatabase("b4test");
        MongoCollection<Project> projectCollection = b4test.getCollection("project", Project.class);

        Bson filter = Filters.and(Filters.or(Filters.eq("name", "ETM"), Filters.eq("name", "ETM")));


        Project first = projectCollection.find(Filters.eq("_id", new ObjectId("61f131e230a39e7253c88012"))).first();
        Objects.requireNonNull(first).getProjectColumns().add(new ProjectColumns("FerFer"));
        projectCollection.updateOne(Filters.eq("_id", new ObjectId("61f131e230a39e7253c88012")), Updates.set("projectColumns", first.getProjectColumns()));
        for (Project project1 : projectCollection.find()) {
            System.out.println(project1);
        }
//
//        List<ProjectColumns> projectColumns = List.of(
//                new ProjectColumns("Todo"),
//                new ProjectColumns("In process"),
//                new ProjectColumns("Done"),
//                new ProjectColumns("QA")
//        );
//
//
//        Project newProject = new Project("ETM", projectColumns);
//        projectCollection.insertOne(newProject);


    }
}
