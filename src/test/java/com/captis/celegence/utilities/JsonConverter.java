package com.captis.celegence.utilities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonConverter {
	public void convertToJson(String excelPath, String excelSheetName) {
		ExcelReader readExcel = new ExcelReader(excelPath);
		int totalNoOfRows = readExcel.getRowCount(excelSheetName);
		int rowNumOfTCCounter = 1;
		int cellsBWTCCounter = 0;
		String parameterName = null;
		String jsonFileName = null;
		LinkedHashMap<Integer, Integer> rownumAndCellsInBWTC = new LinkedHashMap<>();
		Map<String, Object> testParametersForJson = null;
		List<String> parameterValues;
		Set<Map.Entry<Integer, Integer>> entrySetRownumAndCellsInBWTC = rownumAndCellsInBWTC.entrySet();

		for (int rowNum = 1; rowNum <= totalNoOfRows; rowNum++) {
			if (readExcel.getCellData(excelSheetName, 0, rowNum).isEmpty()) {
				cellsBWTCCounter++;
			}
			if (!(readExcel.getCellData(excelSheetName, 0, rowNum).isEmpty()) || rowNum == totalNoOfRows) {
				rownumAndCellsInBWTC.put(rowNumOfTCCounter, cellsBWTCCounter);
				rowNumOfTCCounter = rowNum;
				cellsBWTCCounter = 0;
			}
		}

		for (Map.Entry<Integer, Integer> rownumAndNumOfCellEntry : entrySetRownumAndCellsInBWTC) {
			testParametersForJson = new LinkedHashMap<String, Object>();

			for (int rowCellNum = 1; rowCellNum < readExcel.getTotalCellinRow(excelSheetName,
					rownumAndNumOfCellEntry.getKey()); rowCellNum++) {
				parameterValues = new ArrayList<String>();
				for (int colNum = 0; colNum <= rownumAndNumOfCellEntry.getValue() + 1; colNum++) {
					if (colNum == 0) {
						jsonFileName = readExcel.getCellData(excelSheetName, 0,
								rownumAndNumOfCellEntry.getKey() + colNum);
					} else if (colNum == 1) {
						parameterName = readExcel.getCellData(excelSheetName, rowCellNum,
								rownumAndNumOfCellEntry.getKey() + colNum - 1);
					} else if (!(readExcel
							.getCellData(excelSheetName, rowCellNum, rownumAndNumOfCellEntry.getKey() + colNum - 1)
							.isEmpty())) {
						parameterValues.add(readExcel.getCellData(excelSheetName, rowCellNum,
								rownumAndNumOfCellEntry.getKey() + colNum - 1));

					}
				}
				testParametersForJson.put(parameterName, parameterValues);
			}
			jsonToFile(testParametersForJson, jsonFileName);
		}
	}

	public static void jsonToFile(Map<String, Object> jsonObjVal, String fileName) {
		ObjectMapper mapper = new ObjectMapper();
		String jsonPath = System.getProperty("user.dir") + "\\src\\test\\resources\\Json\\" + fileName + ".json";
		File file = new File(jsonPath);
		try {
			mapper.writerWithDefaultPrettyPrinter().writeValue(file, jsonObjVal);
		} catch (StreamWriteException e) {
			e.printStackTrace();
		} catch (DatabindException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
