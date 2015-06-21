package de.vogella.rss.tests;

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
	
	private static final String PERSISTENCE_UNIT_NAME = "feedMessage";
	private static EntityManagerFactory factory;
	
	public static void main(String[] args){
		
//		RSSFeedParser parser = new RSSFeedParser("http://blogs.aws.amazon.com/security/blog/feed/recentPosts.rss"); //possible way for getting from the NVD ??
		
		
		RSSFeedParser parser = new RSSFeedParser("http://www.vogella.com/article.rss");
		Feed feed = parser.readFeed();
		System.out.println(feed);

		for (FeedMessage message : feed.getMessages()) {
			System.out.println(message);
			
		}
		
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		// read the existing entries and write to console
		
		Query q = em.createQuery("select f from Feed f");

		List <Feed> feedList = q.getResultList() ;

		for (Feed feed2 : feedList) {
			System.out.println(feed2);
			
		}
		System.out.println("Size:" + feedList.size());
	
		em.getTransaction().begin();
		FeedMessage feed2 = new FeedMessage();
		feed2.setAuthor(PERSISTENCE_UNIT_NAME);
		em.persist(feed2);
		feed2.setDescription("this is a test");
		em.persist(feed2);
		feed2.setGuid("this is a test");
		em.persist(feed2);
		feed2.setLink("this is a test");
		em.persist(feed2);
		feed2.setTitle("this is a test");
		em.persist(feed2);

		em.getTransaction().commit();
		
		em.close();
	}
	
}
