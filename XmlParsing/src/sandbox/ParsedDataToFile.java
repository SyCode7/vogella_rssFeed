package sandbox;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import rssCrawler.rss.model.Feed;
import rssCrawler.rss.model.FeedMessage;
import rssCrawler.rss.read.RSSFeedParser;
import rssCrawler.*;


public class ParsedDataToFile {
	
	public static void main(String[] args) throws IOException {
		try {
		
		RSSFeedParser parser = new RSSFeedParser("http://searchcloudsecurity.techtarget.com/rss/Cloud-Security-Briefing-News-and-Advice.xml");
		Feed feed = parser.readFeed();

	
		String input = "C:\\Users\\Kennedy\\workspace\\demo.txt";
		File newFile = new File(input);
		
		if (!newFile.exists()){
			newFile.createNewFile();
		}
		
			FileWriter writer = new FileWriter(newFile.getAbsoluteFile());
			PrintWriter out  = new PrintWriter(new BufferedWriter(writer));
//			FeedMessage str = new FeedMessage();
			FeedMessage message1 = new FeedMessage();
			String [] saver = message1.getMessage();

			for (FeedMessage message : feed.getMessages()) {
//				System.out.println(message);
				String appender = "";
				for(String s : message){
					
				}
				writer.write("Attempt One");
			}
				writer.close();
			
			
//			FeedMessage saver = new FeedMessage();
//			for (int i = 0; i < saver.length; i++) {
//				
//					out.write(Integer.toString()(saver);
//			}
//				System.out.println(saver);
			
						

//				System.out.println(saver);
//				out.close();
				
			
			
//			System.out.println("File successfully written to at " + input );
				
		} catch (IOException e) {
			System.out.println("File writing operation failed ");
			e.printStackTrace();
		}
		
		
	} 
	
	 
}