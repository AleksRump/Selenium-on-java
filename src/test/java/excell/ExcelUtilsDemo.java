package excell;

public class ExcelUtilsDemo {    // а этот робит как тест опираясь на  РО excelRowCount

	public static void main(String[] args) {
		
		String projectPath = System.getProperty("user.dir");
		excelRowCount excel = new excelRowCount(projectPath+"\\excel\\data.xlsx", "List1");
		
		excel.getRowCount();           // подсёт строк
		excel.getCellDataString(0, 0);  // первая пишется строка с верху вниз  , вторая это столбец с лева на право
		excel.getCellDataString(2, 0);  //строкас верху вниз 2 / столбец с лева на право 0 (ABBRA)
		excel.getCellDataNumber(1, 1);
		excel.getCellDataNumber(2, 1);
		excel.getColCount();           // подсчёт столлбцов
		

	}

}
