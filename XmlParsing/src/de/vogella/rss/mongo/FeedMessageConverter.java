package de.vogella.rss.mongo;

import org.bson.Document;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import de.vogella.rss.model.FeedMessage;

public class FeedMessageConverter {
	
	//convert FeedMessage object to DBObject
	
	public static void main(String[] args) {
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase db = mongoClient.getDatabase("CloudVuln");
		
		MongoCollection<Document>  coll =  db.getCollection("hpi_vdb");
		
	}
	
	public static DBObject toDBObject(FeedMessage feedMessage){
		
		BasicDBObjectBuilder builder = BasicDBObjectBuilder.start()
				.append("title", feedMessage.getTitle())
				.append("description", feedMessage.getDescription())
				.append("author", feedMessage.getAuthor())
				.append("guid", feedMessage.getGuid())
				.append("link", feedMessage.getLink());
		
		return builder.get();

		
		//convert DBOject to FeedMassage object
		
//		public static FeedMessage toFeedMessage(DBObject doc){
//			FeedMessage feedMessage2 = new FeedMessage();
//			feedMessage2.setTitle((String)doc.get("title"));
//			feedMessage2.setDescription((String)doc.get("description"));
//			feedMessage2.setAuthor((String)doc.get("author"));
//			feedMessage2.setLink((String)doc.get("link"));
//			feedMessage2.setGuid((String)doc.get("guid"));
//			return feedMessage2;

	
	}

}
