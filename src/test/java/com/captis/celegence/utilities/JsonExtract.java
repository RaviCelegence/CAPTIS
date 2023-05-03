package com.captis.celegence.utilities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonExtract {
	File file;
	JsonNode rootNode;
	ObjectMapper mapper;

	public JsonExtract(String jsonfilename) {
		file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\Json\\" + jsonfilename + ".json");
		mapper = new ObjectMapper();
		try {
			rootNode = mapper.readTree(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getValue(String parameter) {
		return rootNode.get(parameter).get(0).textValue();
	}

	public ArrayList<String> getValues(String parameter) {
		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < rootNode.get(parameter).size(); i++) {
			list.add(rootNode.get(parameter).get(i).textValue());
		}
		return list;
	}

	public LinkedHashMap<Integer, ArrayList<String>> getValueset(String parameter, int value) {
		LinkedHashMap<Integer, ArrayList<String>> map = new LinkedHashMap<>();
		for (int i = 1; i <= value; i++) {
			parameter = parameter.substring(0, parameter.length() - 1) + i;
			map.put(i, getValues(parameter));
		}
		return map;
	}
}
