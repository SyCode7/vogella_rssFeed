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
		
		RSSFeedParser parser = new RSSFeedParser("https://www-304.ibm.com/connections/blogs/roller-ui/rendering/feed/PSIRT/entries/atom?lang=en_us");
		Feed feed = parser.readFeed();
	
		String input = "C:\\Users\\Kennedy\\workspace\\demo1.txt";
		File newFile = new File(input);
		
		if (!newFile.exists()){
			newFile.createNewFile();
		}
		
			FileWriter writer = new FileWriter(newFile.getAbsoluteFile());
//			PrintWriter out  = new PrintWriter(new BufferedWriter(writer));
//			FeedMessage message1 = new FeedMessage();
			int sx = feed.getMessages().size();
			for (int i = 0; i < sx; i++) {
				
				writer.write(feed.getMessages().get(i).toString() + "\n");
			}
			writer.close();

			System.out.println("File successfully written into "  + input);
	
		} catch (IOException e) {
			System.out.println("File writing operation failed ");
			e.printStackTrace();
		}
		
		
	} 
	
	 
}