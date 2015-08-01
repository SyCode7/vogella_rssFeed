package sandbox;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;

import rssCrawler.rss.model.Feed;
import rssCrawler.rss.read.RSSFeedParser;


public class ParsedDataToFile {
	
//	 public void dataToFile() {

	public static void main(String[] args) throws IOException {
		String header = "title,description,link,guid,pubDate";
		String newLineSeperator = "\n";
		try{
		
		RSSFeedParser parser = new RSSFeedParser("https://aws.amazon.com/security/security-bulletins/feed/");
		Feed feed = parser.readFeed();
	
		String outputFile = "E:\\testFiles\\demo1.csv";
		File newFile = new File(outputFile);
		
		if (!newFile.exists()){
			newFile.createNewFile();
		}
		
			FileWriter writer = new FileWriter(newFile.getAbsoluteFile());
//			PrintWriter out  = new PrintWriter(new BufferedWriter(writer));
//			FeedMessage message1 = new FeedMessage();
		
//			CSVWriter writer = new CSVWriter(new FileWriter(outputFile));
			int sx = feed.getMessages().size();
			writer.append(header);
			writer.append(newLineSeperator);

			for (int i = 0; i < sx; i++) {
				
				writer.write(feed.getMessages().get(i).toString());
				writer.append(newLineSeperator);
			}
			writer.flush();
			writer.close();

			System.out.println("File successfully written into "  + outputFile);
	
		} catch (IOException e) {
			System.out.println("File writing operation failed ");
			e.printStackTrace();
		}
				
	} 
	
 }
