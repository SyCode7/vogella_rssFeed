package sandbox;


import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.apache.commons.feedparser.DefaultFeedParserListener;
import org.apache.commons.feedparser.FeedParser;
import org.apache.commons.feedparser.FeedParserException;
import org.apache.commons.feedparser.FeedParserFactory;
import org.apache.commons.feedparser.FeedParserListener;
import org.apache.commons.feedparser.FeedParserState;
import org.apache.commons.feedparser.MetaFeedParser;
import org.apache.commons.feedparser.network.ResourceRequest;
import org.apache.commons.feedparser.network.ResourceRequestFactory;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger.*;

public class ApacheFeedParser {
	
   private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(ApacheFeedParser.class);
	
	public static void main(String[] args) throws FeedParserException, IOException {
		PropertyConfigurator.configure ("E:\\git\\vogella_rss\\XmlParsing\\resources\\log4j.properties");    
		
		//creates a new feed parser
		FeedParser feedParser = FeedParserFactory.newFeedParser();
//		MetaFeedParser metaFeed = new MetaFeedParser();
//		metaFeed.parse(listener, state);
//		metaFeed.parseDate(null, null, null, null);
//		
       // creates a listener for handling call-backs		
		FeedParserListener listner = new DefaultFeedParserListener(){
			
			public  void onChannel (FeedParserState state,
									String title,
									String link,
									String description
									) throws FeedParserException {
				System.out.println("Title: " + title);
				System.out.println("link: " + link);
				System.out.println("description: " + description);
//				System.out.println("guid: " + guid);
							
//				LOGGER.info("sddd");
//				LOGGER.debug("ffff");
				
			}
			
			public  void onItem (FeedParserState state,
					String title,
					String link,
					String description,
					String permalink) throws FeedParserException {
				
				System.out.println("NEW CHANNEL: " + title);
				System.out.println("link: " + link);
				System.out.println("description: " + description);

						
		}
			
			void onRelation(FeedParserState state,
	                String security)
	                throws FeedParserException {
				
				System.out.println("NEW CHANNEL Security realtionship: " + security);
			}
			
			void onLink(FeedParserState state,
		            String rel,
		            String type,
		            String href,
		            String title,
		            long length) throws FeedParserException{
				
				System.out.println("Printing from onLink, Title: " + title);
				System.out.println("rel: " + rel);
				System.out.println("type: " + type);
			}
			
			
//			public void onSubject(FeedParserState state,
//					String title,
//					String link,
//					String description) throws FeedParserException {
//				System.out.println("Found a new channel: " + title);
//				System.out.println("link: " + link);
//				System.out.println("description: " + description);
//
//			}
			
			public void onLink(FeedParserState state, Date date) throws FeedParserException {
				System.out.println("pubDate : " + date);

			}
	};
	
	// Specifying the feed to be fetched
	
	String resource = "https://www-304.ibm.com/connections/blogs/roller-ui/rendering/feed/PSIRT/entries/atom?lang=en_us";
	System.out.println(resource);
//	if (args.length == 1) {
//		resource = args[0];
//	}
		
		System.out.println("Fetching resources: " + resource);
		
	//use the network IO to fetch the resources URL
		
		ResourceRequest request = ResourceRequestFactory.getResourceRequest(resource);
		
   // grab our input stream
		
		InputStream is = request.getInputStream();
		
   //start parsing the feed and have the above onItem methods called
		
		feedParser.parse(listner, is, resource);
//		feedParser.parse(listner, is);
//		System.out.println();

	}
}
	

		

