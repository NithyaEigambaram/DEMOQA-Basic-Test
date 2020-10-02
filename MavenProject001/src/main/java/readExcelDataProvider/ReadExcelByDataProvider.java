package readExcelDataProvider;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import basePoint.BaseCase;

public class ReadExcelByDataProvider extends BaseCase {
	public ReadExcelByDataProvider() throws IOException {
		super();

	}

	
	public XSSFWorkbook wb;
	public XSSFSheet sheet;
	public XSSFCell cellData;
	public XSSFRow row;

	public Object[][] testData(String flname) throws IOException {
		try {
			//Declare the Object array for eliminate size issue
			Object[][] excelData = null;
			//Specify the file input output operation
			FileInputStream fs = new FileInputStream(flname);
			//links the workBook
			wb = new XSSFWorkbook(fs);
			//Links the sheet with specified index 
			sheet = wb.getSheetAt(0);
			//Gets the Row with index 0
			row = sheet.getRow(0);
			
			
			
			int rowCount = sheet.getLastRowNum() + 1;//Counts the row and cols ---row starts with 0
			int colCount = row.getLastCellNum();
			
			
			excelData = new Object[rowCount - 1][colCount];//assigns the rows and  cols to the array
			for (int i = 1; i < rowCount; i++) {
				for (int j = 0; j < colCount; j++) {
					
					excelData[i - 1][j] = getCellData(i, j);//calls the method to get cell data with specified row and  cols
					//excelData[i - 1][j] = sheet.getRow(i).getCell(j);//Not used because of arguments Specified in String
				}

			}
			return excelData;//returns the object array value
		} catch (Exception e) {
			System.out.println("File reading failed .....Please specify the right file specifications");
			return null;
		}

	}

	public String getCellData(int i, int j) {
		try {
			cellData = sheet.getRow(i).getCell(j);//gets the value of cell
			
			
			if (cellData.getCellType() == CellType.STRING) {//converts the value to String type
				return cellData.getStringCellValue();
			} else if (cellData.getCellType() == CellType.NUMERIC || cellData.getCellType() == CellType.FORMULA) {
				return String.valueOf(cellData.getNumericCellValue());
			} else if (cellData.getCellType() == CellType.BLANK) {
				return " ";

			} else

				return String.valueOf(cellData.getBooleanCellValue());

		}

		catch (Exception e) {
			System.out.println("error reading in cell data.....Please check the data once again!!!!");
			return null;

		}

	}

}
