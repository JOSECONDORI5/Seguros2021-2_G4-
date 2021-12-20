package segurosxy.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoDatabase;

import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.codecs.configuration.CodecRegistries;

import java.util.logging.Level;

public class Connection {

    private final MongoClient mongoClient;

    public Connection() {
        java.util.logging.Logger.getLogger("org.mongodb.driver").setLevel(Level.SEVERE);
        
        this.mongoClient = new MongoClient( "localhost" , 27017 );
        //this.mongoDB = this.mongoClient.getDatabase("SRP");
    }

    public MongoDatabase getDatabase() {
        CodecRegistry pojoCodecRegistry = CodecRegistries.fromRegistries(
                MongoClientSettings.getDefaultCodecRegistry(),
                CodecRegistries.fromProviders(
                        PojoCodecProvider.builder().automatic(true).build()
                )
        );
        MongoDatabase database = this.mongoClient.getDatabase("seguros").withCodecRegistry(pojoCodecRegistry);
        return database;
    }

    public void closeDatabase() {
        this.mongoClient.close();
    }

}