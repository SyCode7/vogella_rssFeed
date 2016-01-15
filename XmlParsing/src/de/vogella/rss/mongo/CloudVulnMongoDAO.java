package de.vogella.rss.mongo;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import de.vogella.rss.model.FeedMessage;

public class CloudVulnMongoDAO {
	
	public static void main(String[] args) {
		
//	public CloudVulnMongoDAO(MongoClient mongoClient){
//		this.col = mongoClient.getDB().getCollection();
//	}
		
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase db = mongoClient.getDatabase("CloudVuln");
		MongoCollection<Document>  coll =  db.getCollection("hpi_vdb");

		FeedMessage feedMessage = new FeedMessage();
//	DB db2 = mongoClient.getDB("tester");
//	MongoCollection collection = mongoClient.getDa
//		MongoCollection<Document>  coll =  db.getCollection("hpi_vdb");
//		FeedMessage feedMessage = new FeedMessage();()
//		DBObject doc = FeedMessageConverter.toDBObject(feedMessage);
//		doc.put(key, v)
		
		BasicDBObject doc = new BasicDBObject().append("title", feedMessage.getTitle())
				.append("description", feedMessage.getDescription())
				.append("author", feedMessage.getAuthor())
				.append("guid", feedMessage.getGuid())
				.append("link", feedMessage.getLink());
		
	
//	coll.insertMany(doc);
}
	
	

}
