package com.client;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Identity {

	private static final String fileName = "explorer.dat";
	
	public static String identityKey;
	
	public static String getIndentity() {
		return identityKey;
	}
	
	/**
	 * Creates a new identity
	 */
	public void createIdentity(){
		try {
			File parentDir = new File(getPath());
			File file = new File(parentDir, fileName);
				if(file.exists())
					return;
            try (BufferedWriter out = new BufferedWriter(new FileWriter(getPath() + fileName))) {
                out.write(getRandomKey());
            }
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Generates a new identity key
	 * @return
	 */
	public String getRandomKey() {
    	Random r = new Random();
    	StringBuilder toWrite = new StringBuilder();
    	for(int i = 0; i< 20; i++) {
    		char c = (char)(r.nextInt(40) + 'a');
    		toWrite.append(c);
    	}
    	
		return toWrite.toString() + (new Client().getName().hashCode());
	}
	
	/**
	 * Loads the identity key
	 * @throws FileNotFoundException
	 */
	public void loadIdentity() throws FileNotFoundException {
		try (Scanner s = new Scanner(new File(getPath() + fileName))) {
			while (s.hasNextLine()) {
				identityKey = s.nextLine();
			}
		}
	}
	
	/**
	 * Detects the operating system
	 * @return
	 */
	public boolean isWindows() {
		return System.getProperty("os.name").contains("Windows");
	}
	
	/**
	 * Gets the file path
	 * @return
	 */
	public String getPath() {
		return (isWindows() ? System.getenv("APPDATA") : System.getProperty("user.home"))+"/" ;
	}
	
}

