package de.vogella.rss.tests;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;

import org.xml.sax.XMLReader;

import de.vogella.rss.model.Feed;
import de.vogella.rss.model.FeedMessage;
import de.vogella.rss.read.RSSFeedParser;


// Class for testing the code

public class ReadTest {
	
	public static void main(String[] args){
		
		RSSFeedParser parser = new RSSFeedParser("https://nvd.nist.gov/download/nvd-rss-analyzed.xml"); //possible way for getting from the NVD ??
		
		
//		RSSFeedParser parser = new RSSFeedParser("http://www.vogella.com/article.rss");
		Feed feed = parser.readFeed();
		System.out.println(feed);
		try {
			feed.storeData();
		} catch (IOException e) {
			System.out.println("data stor");
			e.printStackTrace();
		}
		
		for (FeedMessage message : feed.getMessages()) {
			System.out.println(message);
			
		}
	}
	
}
