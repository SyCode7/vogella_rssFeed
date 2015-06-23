package de.jaxb.model;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.transform.stream.StreamSource;

import de.vogella.rss.model.Feed;
import de.vogella.rss.model.FeedMessage;


//@XmlElementWrapper( name = "channel" )
@XmlRootElement( name = "item" )
public class RSSReader {
	
	public static void main(String[] args) throws JAXBException, IOException {
		
		JAXBContext jc = JAXBContext.newInstance("de.jaxb.model");
		Unmarshaller unmarshaller  = jc.createUnmarshaller();
		URL url = new URL("http://www.vogella.com/article.rss");
		InputStream xml = url.openStream();
		JAXBElement<RSS_Data> feed = unmarshaller.unmarshal(new StreamSource(xml),RSS_Data.class);
		xml.close();
		
		Marshaller marshaller = jc.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(feed, System.out);
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
