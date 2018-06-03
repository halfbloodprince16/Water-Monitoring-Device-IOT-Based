package edu.pune.university.dao;

import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoCollection;

public abstract class _BaseDao {

	protected void insertDocument(MongoCollection<Document> mongoCollection, Document document) {
		mongoCollection.insertOne(document);
	}

	protected void insertDocument(MongoCollection<Document> mongoCollection, List<? extends Document> documents) {
		mongoCollection.insertMany(documents);
	}

}
