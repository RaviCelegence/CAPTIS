package com.captis.celegence.utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {

	public static Properties loadFile(String filePath) {
		Properties prop = new Properties();
		BufferedReader reader;

		try {
			reader = new BufferedReader(new FileReader(filePath));
			try {
				prop.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException("properties file failed to load " + filePath);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("properties file not found at " + filePath);
		}
		return prop;
	}
}
