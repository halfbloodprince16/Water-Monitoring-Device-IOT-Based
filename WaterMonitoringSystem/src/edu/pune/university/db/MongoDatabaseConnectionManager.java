package edu.pune.university.db;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class MongoDatabaseConnectionManager {
	
	private static MongoDatabaseConnectionManager instance = null;
	private static String USER = "Maya";
	private static String PASSWORD = "root";
	private static String HOST = "ds241699.mlab.com";
	private static String PORT_NUMBER = "41699";
	private static String DATABASE_NAME = "water";
	private static MongoClient client = null;
	private static MongoDatabase mongoDatabase = null;
	private static MongoClientURI MONGO_CLIENT_URL = new MongoClientURI(
			"mongodb://" + USER + ":" + PASSWORD + "@" + HOST + ":" + PORT_NUMBER + "/" + DATABASE_NAME);

	private MongoDatabaseConnectionManager() {

	}
	
	public static MongoDatabaseConnectionManager getInstance () {
		if(instance == null) {
			instance = new MongoDatabaseConnectionManager();
			return instance;
		}
		return instance;
	}

	public MongoDatabase getDatabaseConnection() throws UnknownHostException {
		if (mongoDatabase == null) {
			client = new MongoClient(MONGO_CLIENT_URL);
			mongoDatabase = client.getDatabase(MONGO_CLIENT_URL.getDatabase());
		}
		return mongoDatabase;
	}

	public void closeDatabaseConnection() {
		if (client != null) {
			client.close();
		}
	}

	public MongoCollection<Document> getMongoCollection(String collectionName) throws UnknownHostException {
		return getDatabaseConnection().getCollection(collectionName);
	}

	public static void main(String[] args) throws UnknownHostException {

		MongoDatabaseConnectionManager manager = new MongoDatabaseConnectionManager();
		// Create seed data

		List<Document> seedData = new ArrayList<Document>();

		seedData.add(new Document("decade", "1970s").append("artist", "Debby Boone")
				.append("song", "You Light Up My Life").append("weeksAtOne", 10));

		seedData.add(new Document("decade", "1980s").append("artist", "Olivia Newton-John").append("song", "Physical")
				.append("weeksAtOne", 10));

		seedData.add(new Document("decade", "1990s").append("artist", "Mariah Carey").append("song", "One Sweet Day")
				.append("weeksAtOne", 16));

		/*
		 * First we'll add a few songs. Nothing is required to create the songs
		 * collection; it is created automatically when we insert.
		 */

		MongoCollection<Document> songs = manager.getMongoCollection("water_data");

		// Note that the insert method can take either an array or a document.
		songs.insertMany(seedData);


		/*
		 * Then we need to give Boyz II Men credit for their contribution to the hit
		 * "One Sweet Day".
		 */

		Document updateQuery = new Document("song", "One Sweet Day");
		songs.updateOne(updateQuery, new Document("$set", new Document("artist", "Mariah Carey ft. Boyz II Men")));

		/*
		 * Finally we run a query which returns all the hits that spent 10 or more weeks
		 * at number 1.
		 */

		Document findQuery = new Document("weeksAtOne", new Document("$gte", 10));
		Document orderBy = new Document("decade", 1);

		MongoCursor<Document> cursor = songs.find(findQuery).sort(orderBy).iterator();

		try {
			while (cursor.hasNext()) {
				Document doc = cursor.next();
				System.out.println("In the " + doc.get("decade") + ", " + doc.get("song") + " by " + doc.get("artist")
						+ " topped the charts for " + doc.get("weeksAtOne") + " straight weeks.");
			}
		} finally {
			cursor.close();
		}

		// Since this is an example, we'll clean up after ourselves.

		// songs.drop();

		// Only close the connection when your app is terminating

		// client.close();
	}

}
