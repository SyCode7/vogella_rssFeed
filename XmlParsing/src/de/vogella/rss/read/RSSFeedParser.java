package de.vogella.rss.read;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.XMLEvent;

import de.vogella.rss.model.Feed;
import de.vogella.rss.model.FeedMessage;

// this class reads the xml file 

public class RSSFeedParser {
	
	static final String TITLE = "title";
	static final String DESCRIPTION = "description";
	static final String CHANNEL = "channel";
	static final String LANGUAGE = "language";
	static final String COPYRIGHT = "copyright";
	static final String LINK = "link";
	static final String AUTHOR = "author";
	static final String ITEM = "item";
	static final String PUB_DATE = "pubDate";
	static final String GUID = "guid";
	
	 URL url = null;
	
	public RSSFeedParser(String feedUrl){
		try {
			this.url = new URL(feedUrl);
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
	}
	

	public Feed readFeed() {
		Feed feed = null;
		try {
			
			boolean isFeedHeader = true;
			
			
			String description = "";
			String title = "";
			String link = ""; 
			String language ="";
			String copyright = "";
			String author = "";
			String pubDate = "";
			String guid = "";
			
			XMLInputFactory inputFactory = XMLInputFactory.newInstance();// creates an XMLInputFactory
			InputStream in = read();
			XMLEventReader eventreader = inputFactory.createXMLEventReader(in);
			while (eventreader.hasNext()) {
				XMLEvent event = eventreader.nextEvent();
				if (event.isStartElement()) {
					String localPart = event.asStartElement().getName().getLocalPart();
					switch(localPart){
					case ITEM:
						if (isFeedHeader) {
							isFeedHeader = false;
							feed = new Feed(title, link, description, language, copyright, pubDate);
						}
						event = eventreader.nextEvent();
						break;
					case TITLE:
						title = getCharacterData(event, eventreader);
						break;
					
					case DESCRIPTION:
						title = getCharacterData(event, eventreader);
						break;
						
					case LINK:
						title = getCharacterData(event, eventreader);
						break;
					
					case GUID:
						title = getCharacterData(event, eventreader);
						break;
					
					case LANGUAGE:
						title = getCharacterData(event, eventreader);
						break;
					
					case AUTHOR:
						title = getCharacterData(event, eventreader);
						break;
						
					case PUB_DATE:
						title = getCharacterData(event, eventreader);
						break;
					
					case COPYRIGHT:
						title = getCharacterData(event, eventreader);
						break;
					}
					
				} else if (event.isEndElement()) {
					if (event.asEndElement().getName().getLocalPart() == (ITEM)) {
						FeedMessage message = new FeedMessage();
						message.setAuthor(author);
						message.setDescription(description);
						message.setGuid(guid);
						message.setLink(link);
						message.setTitle(title);
						feed.getMessages().add(message);
						event = eventreader.nextEvent();
						continue;
						
					}
				
				}
				
			}
		} catch (XMLStreamException e) {
			throw new RuntimeException(e);
		}
		return feed;
	}


	private String getCharacterData(XMLEvent event, XMLEventReader eventreader) throws XMLStreamException {
		String result = "";
		event = eventreader.nextEvent();
		if (event instanceof Characters) {
			result = event.asCharacters().getData();
		}
		return result;
		
	}


	private InputStream read() {
		try {
			return url.openStream();
		} catch (IOException e) {
			
		 throw new RuntimeException(e);
		}
	} 

}
				