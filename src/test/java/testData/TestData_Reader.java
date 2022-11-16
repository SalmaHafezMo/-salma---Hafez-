package testData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestData_Reader {
	
	static FileInputStream fis = null; 
	//Get Excel sheet from project 
	public Object[][] getExcelData (int index , int Col) throws IOException{
		String filepath = System.getProperty("user.dir")+"//TestData//Task Test Data  (3).xlsx";
		File scrfile = new File(filepath);
		fis = new FileInputStream(scrfile); 
		
	    //Point to Excel sheet by index num 
	    XSSFWorkbook  DataWB = new XSSFWorkbook(fis);
	    XSSFSheet Loginsheet = DataWB.getSheetAt(index);
	    int TotalRow = Loginsheet.getLastRowNum();
	    String [][] excel = new String[TotalRow][Col];
	    
	    //Loop in sheet to read test data from columns and rows 
	    for (int row=0 ; row<TotalRow; row++)
	    {
	    	for (int coln=0 ; coln<Col; coln++)
	    	{
	    		XSSFRow readRows = Loginsheet.getRow(row);
	    		DataFormatter format = new DataFormatter();
	    		excel[row][coln]= format.formatCellValue(readRows.getCell(coln));
	    		
	    	}
	    }
	    //Close Workbook opened 
	    DataWB.close();
	    return excel; 
	
	}

}
