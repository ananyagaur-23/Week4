package problem;

import java.util.*;
import java.io.*;

public class FileReaderApp {
	public static void main(String[] args) {
		FileProcessor process = new FileProcessor();
		List<String> files = Arrays.asList("file1.txt","file2.txt","file3.txt");
		process.processFiles(files);
	}
}

class FileProcessor{
	public void processFiles(List<String> filePaths) {
		for(String path : filePaths) {
			System.out.println("Reading file: "+ path);
			try(BufferedReader reader = new BufferedReader (new FileReader(path))){
				String line;
				while((line=reader.readLine())!=null) {
					System.out.println(line);
				}
			}
			catch(IOException e) {
				System.out.println("Error reading file: "+path);
			}
		}
	}
}
