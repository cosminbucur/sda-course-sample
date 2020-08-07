package com.sda.mongo;

import com.mongodb.Block;
import com.mongodb.client.*;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.gt;
import static com.mongodb.client.model.Filters.gte;
import static com.mongodb.client.model.Filters.lt;
import static com.mongodb.client.model.Updates.inc;

// https://mongodb.github.io/mongo-java-driver/3.10/driver/getting-started/quick-start/
public class DemoMongoCrud {

    public static void main(String[] args) {

        MongoClient mongoClient = MongoClients.create();

        // if database doesn't exists, MongoDB will create it for you
        MongoDatabase database = mongoClient.getDatabase("nosql_tutorial");

        // access collection (if it doesn't exist it is created)
        MongoCollection<Document> collection = database.getCollection("patients");

        // create a document
        Document document = new Document("name", "MongoDB")
            .append("type", "database")
            .append("count", 1)
            .append("versions", Arrays.asList("v3.2", "v3.0", "v2.6"))
            .append("info", new Document("x", 203).append("y", 102));

        // insert one document
        collection.insertOne(document);

        // insert many
        List<Document> documents = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            documents.add(new Document("i", i));
        }
        collection.insertMany(documents);

        // count documents in a collection
        System.out.println(collection.countDocuments());

        // find first document
        Document myDoc = collection.find().first();
        System.out.println(myDoc.toJson());

        // find documents in collection
        MongoCursor<Document> cursor = collection.find().iterator();
        try {
            while (cursor.hasNext()) {
                System.out.println(cursor.next().toJson());
            }
        } finally {
            cursor.close();
        }

        // specify a query filter
        myDoc = collection.find(eq("i", 71)).first();
        System.out.println(myDoc.toJson());

        // get all documents that match a filter
        Block<Document> printBlock = doc ->
            System.out.println(doc.toJson());

        collection.find(gt("i", 50))
            .forEach(printBlock);

        // update a single document
        collection.updateOne(eq("i", 10), new Document("$set", new Document("i", 110)));

        // update multiple documents
        UpdateResult updateResult = collection.updateMany(lt("i", 100), inc("i", 100));
        System.out.println(updateResult.getModifiedCount());

        // delete a single document that match a filter
        collection.deleteOne(eq("i", 110));

        // delete all documents that match a filter
        DeleteResult deleteResult = collection.deleteMany(gte("i", 100));
        System.out.println(deleteResult.getDeletedCount());

        // create index
        collection.createIndex(new Document("i", 1));
    }
}
