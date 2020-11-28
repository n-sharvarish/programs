package com.mongodb;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.List;
import java.util.stream.StreamSupport;

public class MongoConnector {

    private final MongoProperties mongoProperties;

    private MongoClient mongo;
    private MongoDatabase database;

    public MongoConnector(MongoProperties mongoProperties) {
        this.mongoProperties = mongoProperties;
    }

    public void connect() {

        this.mongo = new MongoClient(this.mongoProperties.getHost(), this.mongoProperties.getPort());

        //MongoCredential credential = MongoCredential.createCredential(this.mongoProperties.getUserName(),
        //        this.mongoProperties.getDatabaseName(), this.mongoProperties.getPassword().toCharArray());
        System.out.println("Connected to the database successfully");

        this.database = this.mongo.getDatabase(this.mongoProperties.getDatabaseName());
    }

    public void disconnect() {

        this.mongo.close();
        System.out.println("Disconnected the database successfully");
    }

    public void listDatabaseNames() {

        MongoIterable<String> databases = this.mongo.listDatabaseNames();
        StreamSupport.stream(databases.spliterator(), false).forEach(System.out::println);
    }

    public void dropDatabase() {

        this.mongo.dropDatabase(this.mongoProperties.getDatabaseName());
        System.out.println("Database dropped successfully");

        this.database.drop();
        System.out.println("Database dropped successfully");
    }

    public void createCollection() {

        this.database.createCollection(this.mongoProperties.getCollectionName());
        System.out.println("Collection created successfully");
    }

    public void listCollectionNames() {

        MongoIterable<String> collections = this.database.listCollectionNames();
        StreamSupport.stream(collections.spliterator(), false).forEach(System.out::println);
    }

    public MongoCollection<Document> getCollection() {

        MongoCollection<Document> collection = this.database.getCollection(this.mongoProperties.getCollectionName());
        System.out.println("Collection selected successfully");
        return collection;
    }

    public void dropCollection(MongoCollection<Document> collection) {

        collection.drop();
        System.out.println("Collection dropped successfully");
    }

    public void createDocument(MongoCollection<Document> collection, Document document) {

        collection.insertOne(document);
        System.out.println("Document created successfully");
    }

    public void createManyDocument(MongoCollection<Document> collection, List<Document> documents) {

        collection.insertMany(documents);
        System.out.println("Documents created successfully");
    }

    public void getAllDocuments(MongoCollection<Document> collection) {

        FindIterable<Document> iterDoc = collection.find();
        StreamSupport.stream(iterDoc.spliterator(), false).forEach(System.out::println);
    }

    public void getDocument(MongoCollection<Document> collection, Bson bson) {

        FindIterable<Document> iterDoc = collection.find(bson);
        StreamSupport.stream(iterDoc.spliterator(), false).forEach(System.out::println);
    }

    public void updateDocument(MongoCollection<Document> collection, Bson original, Bson updated) {

        collection.updateOne(original, updated);
        System.out.println("Document updated successfully");
    }

    public void deleteDocument(MongoCollection<Document> collection, Bson bson) {

        collection.deleteOne(bson);
        System.out.println("Document deleted successfully");
    }
}
