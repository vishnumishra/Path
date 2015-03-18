package src.com.company;

import java.io.*;

public class MyReader{
	public static String readFile(String path)throws Exception {
		FileReader fr = null;
		File myFile = new File(path);
		fr = new FileReader(myFile);
		BufferedReader br = new BufferedReader(fr);
		int len = (int)myFile.length();
		char file[] = new char[len];
		br.read(file,0,len);
		String fileData = new String(file);
		return fileData;
	}
}



