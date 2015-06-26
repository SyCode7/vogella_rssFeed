package sandbox;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ArrayChecker {

	
	public static void main(String[] args) throws IOException {
		
		File file = new File("C:\\Users\\Kennedy\\workspace\\demo.txt");
		BufferedWriter bw = null;
		
		ArrayList<String> brave = new ArrayList<String>();
		brave.add("The boys are good");
		brave.add("trying again");
		brave.add("\nhope youare in the next line");
		FileWriter writer = new FileWriter(file);
					
			
				for (String str: brave){
					writer.write(str);
				}
					writer.close();
//				bw = new BufferedWriter(new FileWriter(file));
//				bw.write(brave);
			
				
		}
		
	
}
