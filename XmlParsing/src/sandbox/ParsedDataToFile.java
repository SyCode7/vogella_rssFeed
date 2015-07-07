package sandbox;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import rssCrawler.rss.model.Feed;
import rssCrawler.rss.read.RSSFeedParser;


public class ParsedDataToFile {
	
//	 public void dataToFile() {
	

	public static void main(String[] args) throws IOException {
		try{
		
		RSSFeedParser parser = new RSSFeedParser("https://feeds.feedburner.com/ZDI-Published-Advisories");
		Feed feed = parser.readFeed();
	
		String input = "E:\\testFiles\\demo1.txt";
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
