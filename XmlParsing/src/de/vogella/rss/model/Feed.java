package de.vogella.rss.model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*
 * Stores an RSS Message
 */


public class Feed {
	
	String title;
	String link;
	String description;
	String language;
	String copyright;
	String pubDate;
	
	final List<FeedMessage> entries = new ArrayList<FeedMessage>();
	
	public Feed (String title, String link, String description, String language, String copyright, String pubDate){
		
		this.title = title;
		this.link = link;
		this.description = description;
		this.language = language;
		this.copyright = copyright;
		this.pubDate = pubDate;
		
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

	public String getLanguage() {
		return language;
	}

	public String getCopyright() {
		return copyright;
	}

	public String getPubDate() {
		return pubDate;
	}

	public List<FeedMessage> getEntries() {
		return entries;
	}

	@Override
	public String toString() {
		return "Feed [copyright=" + copyright + ", description=" + description
				+ ", language=" + language + ", link=" + link + ", pubDate="
				+ pubDate + ", title=" + title + "]";
	}
}
	
//public void storeData() throws IOException{
//		
//		String URL = "jdbc:mysql://localhost:3306/standfast";
//		String user = "root";
//		String password = "tester";
//		String driver = "com.mysql.jdbc.Driver";
//		Connection connection = null;
//		
//		
//		try {
//			Class.forName(driver);
//			connection = DriverManager.getConnection(URL, user, password);
//			Statement stmt = connection.createStatement();
//			
//		
//			for (FeedMessage feed : entries) {
//				stmt.executeUpdate("INSERT INTO rss_vogella(author,title,description,link,guid) VALUES ('" + feed.getAuthor() + "', '" + feed.getTitle() + "', '" + feed.getDescription() + "','" + feed.getLink()+"', '" + feed.getGuid()+ "')");
////				stmt.executeUpdate(" INSERT INTO book_table(name, author, subject, release_date, language) VALUES (' " + book.getName() + " ','" + ",'" + book.getAuthor() + "' ,'"
////						+ "' ,'" + book.getSubject() + "',' " + book.getReleaseDate() + "','" + book.getLanguage()+ " ')");
//				
//			}
//		
//		
//		} catch (ClassNotFoundException e){
//			System.out.println(e.getMessage());
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//}
//
//}

			