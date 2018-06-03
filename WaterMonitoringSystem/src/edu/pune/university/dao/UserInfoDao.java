package edu.pune.university.dao;

import java.net.UnknownHostException;
import java.util.List;

import org.bson.Document;
import com.mongodb.client.MongoCollection;
import edu.pune.university.data.UserData;
import edu.pune.university.db.MongoDatabaseConnectionManager;
import edu.pune.university.exception.ApplicationException;

public class UserInfoDao extends _BaseDao {
private static String COLLECTION = "User_Info";
	
	
	private MongoCollection<Document> getMongoCollection() throws ApplicationException {
		try {
			return MongoDatabaseConnectionManager.getInstance().getMongoCollection(COLLECTION);
		} catch (UnknownHostException e) {
			throw new ApplicationException();
		}
	}

	
	
	public void createWaterData (UserData userData) throws ApplicationException {
		insertDocument(getMongoCollection(), userData);
		MongoDatabaseConnectionManager.getInstance().closeDatabaseConnection();
	}
	
	public void createWaterData (List<UserData> userDatas) throws ApplicationException {
		insertDocument(getMongoCollection(), userDatas);
	}
	
	public void updateUserData (UserData userData) {
		
	}
	
	public void deleteUserData (UserData userData) {
		
	}
	
	public List<UserData> getAllUserData () {
		return null;
	}
	
	public UserData findUserData (String id) {
		return null;
	}


}
