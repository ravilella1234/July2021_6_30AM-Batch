package excelDataDriven;

public class ExcelDataDriven 
{

	public static void main(String[] args) throws Exception 
	{
		ExcelAPI e = new ExcelAPI("C:\\Users\\ravi\\Desktop\\testdata1.xlsx");
		
		System.out.println(e.getRowCount("login"));
		
		System.out.println(e.columnCount("login"));
		
		System.out.println(e.getCellData("login", 1, 2));
		
		System.out.println(e.getCellData("login", "UserName", 4));
		
		e.setCellData("login", 4, 3, "aborted");

	}

}
