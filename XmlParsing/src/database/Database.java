package database;

import java.io.IOException;

import com.mongodb.BasicDBObject;
import com.mongodb.CommandResult;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;

import sandbox.ApacheFeedParser;


public class Database {
	
   private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(ApacheFeedParser.class);
   static String dbName = "test";

//	public static void insertDummyDocuments(DBCollection collection){
//		
//	
//	}

public static void main(String[] args) throws IOException {
	
	try{
		
		MongoClient mongoClient = new MongoClient("localhost", 27017);
//		Morphia morphia = new Morphia();
//		morphia.mapPackage("de.database");
//		morphia.map(QueryPOJO.class);

		DB db = mongoClient.getDB("test");
		System.out.println("connected to the mongoDB database " + db);
		DBCollection collection  = db.getCollection("feeds3");
//		BasicDBObject  testDocument = new BasicDBObject("Name","Rester")
//				.append("Age", 20)
//				.append("Nickname", "Waziri")
//				.append("Ethnicity","African");
//		
//		collection.insert(testDocument);
//		System.out.println("Documents successfully inserted !!");
//		
		
//		DBCursor cursor = collection.find({$text:{$search {"CVE"}}});
//		for (DBObject dbObject : cursor.limit(2)) {
//			int i = 1;
//			while (cursor.hasNext()) {
//				System.out.println("inserted document :" + i);
//				System.out.println(cursor.next());
//				i++;
//			}
//			
//		}
//		
//		System.out.println("The number of documents in the database is " + collection.count() + " , other useful statistics is " + collection.getStats());
			
		
		DBObject textSearchCommand = new BasicDBObject();
		textSearchCommand.put("text", collection);
		textSearchCommand.put("search", "CVE-2015-4525");
		CommandResult commandResult = db.command(textSearchCommand);
		
//		Datastore  datastore = morphia.createDatastore(mongo, dbName);
		
//		QueryPOJO queryPOJO = new QueryPOJO();
//		queryPOJO.setTitle("testing");
//		queryPOJO.setDescription("testDescribe");
//		queryPOJO.setLink("testLink");
//		queryPOJO.setGuid("testGuid");
//		queryPOJO.setPubDate("testPubDate");
		
//		Key<QueryPOJO> keySave = datastore.save(queryPOJO);
//		System.out.println("saved");
		
//		System.out.println(collection.findOne("feeds"));
		
//		DBCursor cursor = collection.find();
		
//		System.out.println(cursor);
		
		
				
	} catch (MongoException e){
		System.err.println(e.getClass().getName()+ " : " + e.getMessage());
		}
	}

 }

