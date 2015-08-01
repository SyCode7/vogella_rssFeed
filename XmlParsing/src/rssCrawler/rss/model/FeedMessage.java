package rssCrawler.rss.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * Represents one RSS Message
 */
@Entity
@Table(name="feeds3")
public class FeedMessage implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6439415026671395512L;
	
	@Id@GeneratedValue
	int id;
	String title;
	String description;
	String link;
	String guid;
	String pubDate;
	
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
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
	
	
//	public String toString(){
//		return "FeedMessage [title=" + title + ", description = " + description + " , link = " + link + " ,  " + "  guid =  " + guid + " pubDate = " + pubDate + "]";
//	}
//	
//	@Override
//	public String toString(){
//		return "Title =" + title + ", Description =" + description + ", Link =" + link ;
//	}

	@Override
	public String toString(){
		return   title + "," + description + "," + link + "," + guid + "," + pubDate ;
	}

//	@Override
//	public String toString(){
//		return   title + "," + description + "," + link ;
//	}

	
	

}
