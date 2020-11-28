package com.mongodb;

import com.example.BaseTest;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class MongoConnectorTest extends BaseTest {

    //@Test
    public void testMongoConnector() {

        MongoProperties mongoProperties = new MongoProperties();
        mongoProperties.setHost("localhost");
        mongoProperties.setPort(27017);

        mongoProperties.setUserName("mydbUser");
        mongoProperties.setPassword("mydbPassword");

        mongoProperties.setDatabaseName("mydb");
        mongoProperties.setCollectionName("employee");

        MongoConnector mongoConnector = new MongoConnector(mongoProperties);
        mongoConnector.connect();

        System.out.println();
        mongoConnector.listDatabaseNames();

        System.out.println();
        mongoConnector.createCollection();

        System.out.println();
        mongoConnector.listDatabaseNames();

        System.out.println();
        mongoConnector.listCollectionNames();

        System.out.println();
        MongoCollection<Document> collection = mongoConnector.getCollection();

        System.out.println();
        Document document = new Document("name", "Scott Tiger").append("id", 1);
        mongoConnector.createDocument(collection, document);

        System.out.println();
        mongoConnector.getAllDocuments(collection);

        System.out.println();
        List<Document> documents = Arrays.asList(new Document("name", "Scott Tigress").append("id", 2), new Document("name", "Scott Tiger Cub").append("id", 3));
        mongoConnector.createManyDocument(collection, documents);

        System.out.println();
        mongoConnector.getAllDocuments(collection);

        System.out.println();
        mongoConnector.updateDocument(collection, Filters.eq("id", 3), Updates.set("name", "Scott Tiger Cubs and Bulbuls"));

        System.out.println();
        mongoConnector.getDocument(collection, Filters.eq("id", 3));

        System.out.println();
        mongoConnector.deleteDocument(collection, Filters.eq("id", 3));

        System.out.println();
        mongoConnector.getAllDocuments(collection);

        System.out.println();
        mongoConnector.listCollectionNames();

        System.out.println();
        mongoConnector.dropCollection(collection);

        System.out.println();
        mongoConnector.dropDatabase();

        System.out.println();
        mongoConnector.disconnect();
    }
}
