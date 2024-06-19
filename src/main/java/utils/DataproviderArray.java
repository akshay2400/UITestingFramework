package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataproviderArray {
public static String[][] getarray(String path, String sheetname) {
	
	try {
		FileInputStream fileInputStream = new FileInputStream(new File(path));
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetname);
		int rowCount = sheet.getPhysicalNumberOfRows();
		Row row = sheet.getRow(0);
		int colCount = row.getPhysicalNumberOfCells();
		String[][] data = new String[rowCount][colCount];
		DataFormatter df = new DataFormatter();
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				data[i][j] = df.formatCellValue(sheet.getRow(i).getCell(j));
			}
		}
		return data;
	} catch (IOException e) {
		e.printStackTrace();
	}
	return null;
}
}