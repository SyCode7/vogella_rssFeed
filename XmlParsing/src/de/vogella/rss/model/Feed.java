package de.vogella.rss.model;

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

@Entity(name="Feed")
public class Feed implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	String title;
	String link;
	String description;
	String guid;
	String pubDate;
	
	final List<FeedMessage> entries = new ArrayList<FeedMessage>();
	
	public Feed (String title, String link, String description, String guid, String pubDate){
		
		this.title = title;
		this.link = link;
		this.description = description;
		this.guid = guid;
		this.pubDate = pubDate;
		
		}
		
	public Feed() {
		
	}

	public List<FeedMessage> getMessages(){
		return entries;
		
	}
	public String getTitle() {
		return title;
	}

	public String getLink() {
		return link;
	}

	public String getDescription() {
		return description;
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

	@Override
	public String toString() {
		return "Feed [title=" + title + ", link=" + link + ", description="
				+ description + ", guid=" + guid + ", pubDate=" + pubDate + "]";
	}
	

	
}
	

			