package rssCrawler.rss.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
 * Stores an RSS Message
 */

//@Entity(name="Feed")

public class Feed implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Long id;
//	
	String title;
	String description;
	String link;
	String guid;
	String pubDate;
	
	final ArrayList<FeedMessage> entries = new ArrayList<FeedMessage>();
	
	public Feed (String title, String description, String link, String guid, String pubDate){
//		public Feed (String title, String description, String link){

		
		this.title = title;
		this.description = description;
		this.link = link;
		this.guid = guid;
		this.pubDate = pubDate;
		
		}
		
	public Feed() {
		
	}

	public ArrayList<FeedMessage> getMessages(){
		return entries;
		
	}
	public String getTitle() {
		return title;
	}


	public String getDescription() {
		return description;
	}
	
	public String getLink() {
		return link;
	}
	public String getGuid() {
		return guid;
	}
	
	public String getPubDate() {
		return pubDate;
	}

	public List<FeedMessage> getEntries() {
		return entries;
	}

//	@Override
//	public String toString() {
//		return "Feed [title=" + title + ",  description="
//				+ description + ", link=" + link + ", guid=" + guid + ", pubDate=" + pubDate + "]";
//	}
	
	@Override
	public String toString() {
		return  title + ","	+ description + "," + link + "," + guid + "," + pubDate;
	}
	
//	@Override
//	public String toString() {
//		return  title + ";"	+ description + ";" + link ;
//	}
	
}
	

			