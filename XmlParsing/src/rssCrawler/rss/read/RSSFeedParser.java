package rssCrawler.rss.read;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.XMLEvent;

import rssCrawler.rss.model.Feed;
import rssCrawler.rss.model.FeedMessage;

// this class reads the xml file 


public class RSSFeedParser {
	
	static final String TITLE = "title";
	static final String DESCRIPTION = "description";
	static final String LINK = "link";
	static final String GUID = "guid";
	static final String PUB_DATE = "pubDate";
//	static final String CHANNEL = "channel";
//	static final String LANGUAGE = "language";
//	static final String COPYRIGHT = "copyright";
//	static final String AUTHOR = "author";
//	static final String ITEM = "item";
	
	 URL url = null;
	
	public RSSFeedParser(String feedUrl) throws IOException{
		try {
			this.url = new URL(feedUrl);
			

//			url.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");

		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
	}
	

	public Feed readFeed(){
		Feed feed = null;
		try {
			
			boolean isFeedHeader = true;
			
			
			String title = "";
			String description = "";
			String link = ""; 
			String guid = "";
			String pubDate = "";
//			String language ="";
//			String copyright = "";
//			String author = "";
			
			XMLInputFactory inputFactory = XMLInputFactory.newInstance();// creates an XMLInputFactory
			InputStream in = read();
			XMLEventReader eventreader = inputFactory.createXMLEventReader(in);
			//read the xml document		
			while (eventreader.hasNext()) {
				XMLEvent event = eventreader.nextEvent();
				if (event.isStartElement()) {
					String localPart = event.asStartElement().getName().getLocalPart();
					
					switch(localPart){
					case TITLE:
						if (isFeedHeader) {
							isFeedHeader = false;
							feed = new Feed(title, description, link, guid, pubDate);
						}
						event = eventreader.nextEvent();
						break;
																
					case DESCRIPTION:
						description = getCharacterData(event, eventreader);
						break;
					
					case LINK:
						link = getCharacterData(event, eventreader);
						break;
						
					case GUID:
						guid = getCharacterData(event, eventreader);
						break;
					
					
					case PUB_DATE:
						pubDate = getCharacterData(event, eventreader);
						break;
						
//					case TITLE:
//						title = getCharacterData(event, eventreader);
//						break;
						
//					case LANGUAGE:
//						title = getCharacterData(event, eventreader);
//						break;
						
//					case AUTHOR:
//						author = getCharacterData(event, eventreader);
//						break;
						
					
//					case COPYRIGHT:
//						title = getCharacterData(event, eventreader);
//						break;
					}
					
				} else if (event.isEndElement()) {
					if (event.asEndElement().getName().getLocalPart() == (TITLE)) {
						FeedMessage message = new FeedMessage();
						message.setTitle(title);
						message.setDescription(description);
						message.setLink(link);
						message.setGuid(guid);
						message.setPubDate(pubDate);
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


	private String 	getCharacterData(XMLEvent event, XMLEventReader eventreader) throws XMLStreamException {
		String result = "";
		event = eventreader.nextEvent();	
		if (event instanceof Characters) {
			result = event.asCharacters().getData();
		}
		return result;
		
	}


	private InputStream read() {
		try {
			
			URLConnection openconnection = url.openConnection();
			openconnection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
			
			return url.openStream();
			
		} catch (IOException e) {
			
		 throw new RuntimeException(e);
		}
	} 
	
	
//	private void writeToFile(){
//		
//		String file = "E:\\git\\vogella_rss\\XmlParsing\\target\\output.txt";
//		File outfile = new File(file);
//		
//		XMLOutputFactory outputfactory = XMLOutputFactory.newInstance();
//		try {
//			BufferedOutputStream outStream = new BufferedOutputStream(new FileOutputStream(file));
//		} catch (FileNotFoundException e) {
//			System.out.println("File not found !!");
//			e.printStackTrace();
//		}
//	}

}
				