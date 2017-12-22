package sw.gmit.ie;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class DictionaryServiceImpl implements DictonaryService {

	private Scanner in;

	//Use this for Looking up a Value in the HashMap
	@Override
	public String lookup(String s) throws Exception {
		
		openFile();
		String res = readFile(s);
		closeFile();
		return res;
		
	}

	@Override
	public void openFile() {
		try {
			in = new Scanner(new File("dic.txt"));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("dic.txt Hasn't been found");
		}
	}

	@Override
	public String readFile(String s) {
		System.out.println("Reading in the File");
		String line;
		
		HashMap<String,String> dicMap= new HashMap<String,String>();
		
		while(in.hasNext()){
			line =in.nextLine();
			String KeyValues[] = line.split(",",2);
			//Used for Debugging
			//System.out.println(line);
			KeyValues[1] = KeyValues[1].trim();
			dicMap.put(KeyValues[0].toLowerCase(), KeyValues[1]);
		
		}
		//Hash map working?
		
		String res = dicMap.get(s);
		System.out.println(res);
		
		//Error Handleing
		if(res == null || res =="")
			res = " Sorry String NOT FOUND!";
			
		return res;
	}

	@Override
	public void closeFile() {
		in.close();
		System.out.println("dic.txt has been closed");
	}

	/*
	@Override
	public void doFileStuff() {
		openFile();
		readFile();
		closeFile();
		
	}
	*/
	
	




}
