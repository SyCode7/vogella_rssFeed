package rssCrawler.rss.tests;

import java.io.IOException;
import javax.persistence.EntityManagerFactory;
import rssCrawler.rss.model.Feed;
import rssCrawler.rss.model.FeedMessage;
import rssCrawler.rss.read.RSSFeedParser;


// Class for testing the code


public class ReadTest {
	
	
	public static void main(String[] args) throws IOException{
		
//		RSSFeedParser parser = new RSSFeedParser("http://blogs.aws.amazon.com/security/blog/feed/recentPosts.rss"); //possible way for getting from the NVD ??
		
		
//		RSSFeedParser parser = new RSSFeedParser("http://www.vogella.com/article.rss");
//		RSSFeedParser parser = new RSSFeedParser("http://feeds.reuters.com/reuters/technologysectorNews");
//		RSSFeedParser parser = new RSSFeedParser("https://threatpost.com/category/vulnerabilities/feed");  -- not working 
		RSSFeedParser parser = new RSSFeedParser("http://tools.cisco.com/security/center/psirtrss20/CiscoSecurityAdvisory.xml");
//		RSSFeedParser parser = new RSSFeedParser("https://www.exploit-db.com/rss.xml");
//		RSSFeedParser2  parser = new RSSFeedParser2("http://cyber.law.harvard.edu/rss/examples/rss2sample.xml");

		Feed feed = parser.readFeed();
		
		System.out.println("PRINTING OUT THE FEED !!!!");	
		System.out.println(feed);
		System.out.println();

		
		for (FeedMessage message : feed.getMessages()) {
			System.out.println(message);
			
		}
		
//		System.out.println();

//		ParsedDataToFile saveIntoFile = new ParsedDataToFile();
//		saveIntoFile.dataToFile();
	}
	
}
