package database;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.slf4j.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.bson.Document;

import sandbox.ApacheFeedParser;

import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.Morphia;


public class Database {
	
   private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(ApacheFeedParser.class);
   static String dbName = "test";

	public static void insertDummyDocuments(DBCollection collection){
		
	
	}

public static void main(String[] args) throws IOException {
	
	try{
		
		MongoClient mongo = new MongoClient("localhost", 27017);
		Morphia morphia = new Morphia();
		morphia.mapPackage("de.database");
		morphia.map(QueryPOJO.class);

		DB db = mongo.getDB("test");
		DBCollection collection  = db.getCollection("feeds");
		BasicDBObject basicObj; 
		insertDummyDocuments(collection);
		Datastore  datastore = morphia.createDatastore(mongo, dbName);
		
		QueryPOJO queryPOJO = new QueryPOJO();
//		queryPOJO.setTitle("testing");
		queryPOJO.setDescription("testDescribe");
		queryPOJO.setLink("testLink");
		queryPOJO.setGuid("testGuid");
		queryPOJO.setPubDate("testPubDate");
		
		Key<QueryPOJO> keySave = datastore.save(queryPOJO);
		System.out.println("saved");
		
		System.out.println(collection.findOne("feeds"));

		
				
	} catch (MongoException e){
		e.printStackTrace();
	}
}

}

