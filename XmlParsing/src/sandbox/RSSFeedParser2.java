package sandbox;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Iterator;

import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class RSSFeedParser2 {
	
	public static void main(String[] args) throws XMLStreamException, IOException {
		
		
	
//	static final String TITLE = "title";
//	static final String DESCRIPTION = "description";
//	static final String LINK = "link";
//	static final String GUID = "guid";
//	static final String PUB_DATE = "pubDate";
	
	boolean title = false;
	boolean description = false;
	boolean link = false;
	boolean guid = false;
	boolean pubDate = false;

	
	
	
	 	
			InputStream in = read();
			XMLInputFactory factory  = XMLInputFactory.newInstance();
			XMLEventReader eventReader = factory.createXMLEventReader(in);
			
			while (eventReader.hasNext()) 
			try {
				
				XMLEvent event = eventReader.nextEvent();
				switch(event.getEventType()){
				
				case XMLStreamConstants.START_ELEMENT:
					
					StartElement startElement = event.asStartElement();
					String qName = startElement.getName().getLocalPart();
					if (qName.equalsIgnoreCase("channel")) {
						System.out.println("Start Element: channel" );
						Iterator<Attribute> attributes = startElement.getAttributes();
						 title =attributes.next().getValue() != null;
//						System.out.println("Roll No: " + rollNo);
					} else if (qName.equalsIgnoreCase("description")){
						description = true;
					} else if (qName.equalsIgnoreCase("link")) {
						link = true;
					} else if (qName.equalsIgnoreCase("guid")) {
						guid = true;
					} else if (qName.equalsIgnoreCase("pubDate")) {
						pubDate = true;
					}
					
					break;
					
				case XMLStreamConstants.CHARACTERS:
					Characters characters = event.asCharacters();
					if (title) {
						System.out.println("title:"
						+ characters.getData());
						title = false;
					}
					if (description) {
						System.out.println("description:"
						+ characters.getData());
						description = false; 
					}
					if (link) {
						System.out.println("link:"
						+ characters.getData());
						link = false; 
					
					}					
					if (guid) {
						System.out.println("guid:"
						+ characters.getData());
						guid = false; 
						
					}
					
					break;
				case XMLStreamConstants.END_ELEMENT:
					EndElement endElement  = event.asEndElement();
					if (endElement.getName().getLocalPart().equalsIgnoreCase("channel")) {
						System.out.println("End Element: channel");
						System.out.println();
					}
					
					break;
				}						
		
		} catch (XMLStreamException e){
		e.printStackTrace();
	}
		
}
		

			private static InputStream read() throws IOException {
				
				URL url = new URL("http://cyber.law.harvard.edu/rss/examples/rss2sample.xml");
				try {

					URLConnection openconnection = url.openConnection();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return url.openStream();		
				
			}
			
			
			
			TrustManager[] trustallCerts = new TrustManager[]{
					new X509TrustManager() {
						
				    public X509Certificate[] getAcceptedIssuers() {
					return null;
					}
						
						
					public void checkServerTrusted(X509Certificate[] certs, String authType){
					}
						
					public void checkClientTrusted(X509Certificate[] certs, String authType) {							
					}
			}
					
		};
	
}
