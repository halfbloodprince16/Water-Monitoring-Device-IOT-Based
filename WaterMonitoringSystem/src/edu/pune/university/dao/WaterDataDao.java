package edu.pune.university.dao;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

import edu.pune.university.data.WaterData;
import edu.pune.university.db.MongoDatabaseConnectionManager;
import edu.pune.university.exception.ApplicationException;

public class WaterDataDao extends _BaseDao{
	
	private static String COLLECTION = "Water_Data";
	
	
	private MongoCollection<Document> getMongoCollection() throws ApplicationException {
		try {
			return MongoDatabaseConnectionManager.getInstance().getMongoCollection(COLLECTION);
		} catch (UnknownHostException e) {
			throw new ApplicationException();
		}
	}

	
	
	public void createWaterData (WaterData waterData) throws ApplicationException {
		insertDocument(getMongoCollection(), waterData);
		MongoDatabaseConnectionManager.getInstance().closeDatabaseConnection();
	}
	
	public void createWaterData (List<WaterData> waterDatas) throws ApplicationException {
		insertDocument(getMongoCollection(), waterDatas);
	}
	
	public void updateWaterData (WaterData waterData) {
		
	}
	
	public void deleteWaterData (WaterData waterData) {
		
	}
	
	public List<WaterData> getAllWaterData () throws ApplicationException {
		List<WaterData> waterDatas = new ArrayList<>();
		MongoCursor<Document> cursor = getMongoCollection().find(Document.class).iterator();
		try {
			while (cursor.hasNext()) {
				WaterData waterData = (new Gson()).fromJson(cursor.next().toJson(), WaterData.class);
				waterDatas.add(waterData);
			}
		} finally {
			cursor.close();
		}
		return waterDatas;
	}
	
	public WaterData findWaterData (String id) {
		return null;
	}
}
