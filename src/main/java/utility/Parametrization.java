package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Parametrization {

	public static String getExcelData(String sheet,int row,int cell) throws EncryptedDocumentException, IOException {
		
		FileInputStream  file  = new FileInputStream ("C:\\Users\\Nikhil\\Desktop\\API\\SwagLab\\src\\test\\resources\\email sheet.xlsx");
		
	String value=WorkbookFactory.create(file).getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();

	return value;
	
	}
	
	
	
	
	
	
}
