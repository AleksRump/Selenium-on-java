package excell;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelRowCount {   // как понял этот файл будет работать как PO для ExcelUtilsDemo

	static String projectPath;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public excelRowCount(String excelPath, String sheetName) {    //это как он сказал конструктор
		
		try {
		
		workbook = new XSSFWorkbook(excelPath);      //вот эти два это какие то параметры
		sheet = workbook.getSheet(sheetName);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		getRowCount();
		getCellDataString(0,0);
		getCellDataNumber(1,1);
		//getCellDataNumber2(2,2);
		
	}

	public static int getRowCount() {                            // весь этот try/catch для получения колличества строк
		int rowCount=0;
		try {

			rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println("No of rows " + rowCount);

		} catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();                                // весь этот try/catch для получения колличества строк
		}
		return rowCount;
	}
	
	public static int getColCount() {                 // для подсчёта столбцов           
		int colCount=0;
		try {                                                      // весь этот try/catch для получения колличества строк

			colCount = sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println("No of colums " + colCount);

		} catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();                                // весь этот try/catch для получения колличества строк
		}
		return colCount;
	}

	public static String getCellDataString(int rowNum, int colNum) {                           // весь этот try/catch для получения данных в ячейке 0
		String cellData=null;
		try {
			if (sheet.getRow(rowNum) != null && sheet.getRow(rowNum).getCell(colNum) != null) {
			//cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();    // указывает номер ячейки
			//System.out.println(cellData);
				switch (sheet.getRow(rowNum).getCell(colNum).getCellType()) {                                 // от сюда
                case STRING:
                    cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
                    break;
                case NUMERIC:
                    // Преобразуем число в строку
                    cellData = String.valueOf(sheet.getRow(rowNum).getCell(colNum).getNumericCellValue());
                    break;
                default:
                    cellData = "Unsupported cell type";                                                        // до сюда добавил потому что есть числа
				}
			}else {
                System.out.println("Cell is empty or does not exist.");
			}

		} catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();                               // весь этот try/catch для получения данных в ячейке 0
		}
		return cellData;

	}
	
public static void getCellDataNumber(int rowNum, int colNum) {                           // весь этот try/catch для получения данных числовых
		
		try {
			 if (sheet.getRow(rowNum) != null && sheet.getRow(rowNum).getCell(colNum) != null) {
	                double cellDataNum = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
	                System.out.println(cellDataNum);
	            } else {
	                System.out.println("Cell is empty or does not exist.");
	            }
			 
		} catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();                               // весь этот try/catch для получения данных числовых
		}

	}



}
