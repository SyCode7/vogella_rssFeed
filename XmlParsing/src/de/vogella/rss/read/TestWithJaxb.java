package de.vogella.rss.read;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import de.vogella.rss.model.Feed;
import de.vogella.rss.model.FeedMessage;

public class TestWithJaxb {
	
	public static void main(String[] args) throws JAXBException, IOException {
		
		JAXBContext jc = JAXBContext.newInstance("de.vogella.rss.model");
		Unmarshaller unmarshaller  = jc.createUnmarshaller();
		URL url = new URL("http://www.vogella.com/article.rss");
		InputStream xml = url.openStream();
		JAXBElement<Feed> feed2 = unmarshaller.unmarshal(new StreamSource(xml),Feed.class);
		xml.close();
		
		Marshaller marshaller = jc.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(feed2, System.out);
//		RSSFeedParser parser = new RSSFeedParser("http://www.vogella.com/article.rss");
//		Feed feed = parser.readFeed();
//		System.out.println(feed);
//
//		for (FeedMessage message : feed.getMessages()) {
//			System.out.println(message);
//			
//		}
		
	}

}
