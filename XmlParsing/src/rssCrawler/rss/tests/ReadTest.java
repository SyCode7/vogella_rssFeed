package rssCrawler.rss.tests;

import java.io.IOException;
import javax.persistence.EntityManagerFactory;
import rssCrawler.rss.model.Feed;
import rssCrawler.rss.model.FeedMessage;
import rssCrawler.rss.read.RSSFeedParser;


// Class for testing the code


public class ReadTest {
	
	private static final String PERSISTENCE_UNIT_NAME = "feed";
	private static EntityManagerFactory factory;
	
	public static void main(String[] args) throws IOException{
		
//		RSSFeedParser parser = new RSSFeedParser("http://blogs.aws.amazon.com/security/blog/feed/recentPosts.rss"); //possible way for getting from the NVD ??
		
		
//		RSSFeedParser parser = new RSSFeedParser("http://www.vogella.com/article.rss");http://www.securityfocus.com/rss/vulnerabilities.xml
//		RSSFeedParser parser = new RSSFeedParser("http://feeds.reuters.com/reuters/technologysectorNews");
//		RSSFeedParser parser = new RSSFeedParser("https://threatpost.com/category/vulnerabilities/feed");  -- not working 
		RSSFeedParser parser = new RSSFeedParser("http://feeds.trendmicro.com/Anti-MalwareBlog?format=xml");
//		RSSFeedParser parser = new RSSFeedParser("https://www.exploit-db.com/rss.xml");
//		RSSFeedParser2  parser = new RSSFeedParser2("http://cyber.law.harvard.edu/rss/examples/rss2sample.xml");

		PersistenceUtil util = new PersistenceUtil();
		Feed feed = parser.readFeed();
		
		System.out.println("PRINTING OUT THE FEED !!!!");	
		System.out.println(feed);
		System.out.println();


//		try {
//			feed.storeData();
//		} catch (IOException e) {
//			System.out.println("data stor");
//			e.printStackTrace();
//		}
//		
		for (FeedMessage message : feed.getMessages()) {
			System.out.println(message);
			
		}
		
//		System.out.println();

//		ParsedDataToFile saveIntoFile = new ParsedDataToFile();
//		saveIntoFile.dataToFile();
	}
	
}
