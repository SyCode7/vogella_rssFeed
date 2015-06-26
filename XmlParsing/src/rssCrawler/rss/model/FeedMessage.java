package rssCrawler.rss.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/*
 * Represents one RSS Message
 */
@Entity

public class FeedMessage {
	
	@Id@GeneratedValue
	int id;
	String title;
	String link;
	String description;
	String guid;
	String pubDate;
	
	@Column
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getGuid() {
		return guid;
	}
	
	public void setGuid(String guid) {
		this.guid = guid;
	}
	
	public String getPubDate() {
		return pubDate;
	}
	
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}
	
	
	public String toString(){
		return "FeedMessage [title=" + title + ", description = " + description + " , link = " + link + " ,  " + "  guid =  " + guid + " pubDate = " + pubDate + "]";
	}

	
	

}
