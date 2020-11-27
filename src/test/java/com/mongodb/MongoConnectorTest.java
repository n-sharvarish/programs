package com.mongodb;

import com.example.TestUtils;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class MongoConnectorTest {

    @BeforeClass
    public void setUp() {
        TestUtils.setUpMessage(this.getClass());
    }

    @AfterClass
    public void tearDown() {
        TestUtils.tearDownMessage(this.getClass());
    }

    @Test
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

        System.out.println("Listing Databases");
        mongoConnector.listDatabaseNames();

        System.out.println("Creating Collection");
        mongoConnector.createCollection();

        System.out.println("Listing Databases");
        mongoConnector.listDatabaseNames();

        System.out.println("Listing Collections");
        mongoConnector.listCollectionNames();

        System.out.println("Listing Collection");
        MongoCollection<Document> collection = mongoConnector.getCollection();

        System.out.println("Creating Document");
        Document document = new Document("name", "Scott Tiger").append("id", 1);
        mongoConnector.createDocument(collection, document);

        System.out.println("Listing All Documents");
        mongoConnector.getAllDocuments(collection);

        System.out.println("Creating Documents");
        List<Document> documents = Arrays.asList(new Document("name", "Scott Tigress").append("id", 2), new Document("name", "Scott Tiger Cub").append("id", 3));
        mongoConnector.createManyDocument(collection, documents);

        System.out.println("Listing All Documents");
        mongoConnector.getAllDocuments(collection);

        System.out.println("Updating Document");
        mongoConnector.updateDocument(collection, Filters.eq("id", 3), Updates.set("name", "Scott Tiger Cubs and Bulbuls"));

        System.out.println("Listing Updated Document");
        mongoConnector.getDocument(collection, Filters.eq("id", 3));

        System.out.println("Deleting Updated Document");
        mongoConnector.deleteDocument(collection, Filters.eq("id", 3));

        System.out.println("Listing All Documents");
        mongoConnector.getAllDocuments(collection);

        System.out.println("Listing Collections");
        mongoConnector.listCollectionNames();

        System.out.println("Dropping Collection");
        mongoConnector.dropCollection(collection);

        System.out.println("Dropping Database");
        mongoConnector.dropDatabase();

        System.out.println("Disconnecting the database");
        mongoConnector.disconnect();
    }
}
