package de.vogella.rss.tests;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import de.vogella.rss.model.Feed;
import de.vogella.rss.model.FeedMessage;
import de.vogella.rss.read.RSSFeedParser;


// Class for testing the code

public class ReadTest {
	
	private static final String PERSISTENCE_UNIT_NAME = "feed";
	private static EntityManagerFactory factory;
	
	public static void main(String[] args) throws IOException{
		
//		RSSFeedParser parser = new RSSFeedParser("http://blogs.aws.amazon.com/security/blog/feed/recentPosts.rss"); //possible way for getting from the NVD ??
		
		
//		RSSFeedParser parser = new RSSFeedParser("http://www.vogella.com/article.rss");
//		RSSFeedParser parser = new RSSFeedParser("http://feeds.reuters.com/reuters/technologysectorNews");
//		RSSFeedParser parser = new RSSFeedParser("https://threatpost.com/category/vulnerabilities/feed");  -- not working 
//		RSSFeedParser parser = new RSSFeedParser("http://searchcloudsecurity.techtarget.com/rss/Cloud-Security-Briefing-News-and-Advice.xml");
		RSSFeedParser parser = new RSSFeedParser("https://www.exploit-db.com/rss.xml");

		PersistenceUtil util = new PersistenceUtil();
		Feed feed = parser.readFeed();
		System.out.println(feed);
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
		
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		// read the existing entries and write to console
		
		Query q = em.createQuery("select f from Feed f");

		List <Feed> feedList = q.getResultList();

//		List<Todo> todoList = q.getResultList();
		
		for (Feed feed2 : feedList) {
			System.out.println(feed2);
			
		}
		System.out.println("Size:" + feedList.size());
		
		//create new todo
		
		em.getTransaction().begin();
		FeedMessage feed2 = new FeedMessage();
		feed2.setTitle("title");
		em.persist(feed2);
		feed2.setLink("link");
		em.persist(feed2);
		feed2.setDescription("description");
		em.persist(feed2);
		feed2.setGuid("guid");
		em.persist(feed2);
		feed2.setPubDate("pubDate");
		em.persist(feed2);

		em.getTransaction().commit();
		
		em.close();
	}
	
}
