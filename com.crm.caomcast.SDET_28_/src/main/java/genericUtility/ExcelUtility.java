package genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * @author Ammu
 *
 */


public class ExcelUtility {
	/**
	 * This method will return string value from excel sheet
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws Throwable
	 *
	 */

	public String getStringCellData(String Sheet1,int rowNo,int cellNo) throws Throwable
	{
	FileInputStream file=new FileInputStream(IpathConstants.EXCEL_PATH);
	Workbook workbook=WorkbookFactory.create(file);
	 Sheet sheet = workbook.getSheet(Sheet1);
	Row row=sheet.getRow(rowNo);
	Cell cell=row.getCell(cellNo);
	return cell.toString();
	
	

	
	}
	
	public double getNumericCellData(String Sheet1,int rowNo,int cellNo) throws Throwable
	{
		FileInputStream file=new FileInputStream(IpathConstants.EXCEL_PATH);
		Workbook workbook=WorkbookFactory.create(file);
		return workbook.getSheet(Sheet1).getRow(rowNo).getCell(cellNo).getNumericCellValue();
		
	}
	
	public Object[][] getMultipleData(String sheet1)throws Throwable
	{
		FileInputStream file=new FileInputStream(IpathConstants.EXCEL_PATH);
		Workbook workbook=WorkbookFactory.create(file);
		Sheet sheet=workbook.getSheet(sheet1);
		int rowNo = sheet.getLastRowNum();
		int cellNo=sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[rowNo][cellNo];
		for(int i=0;i<rowNo;i++)
		{
			for(int j=0;j<cellNo;j++)
			{
				data[i][j]=sheet.getRow(i).getCell(j).toString();
				
			}
		}
		return data;
		
	}
	
	public void writeDataIntoExcel(String Sheet1, int rowNo,int Cellno,String Value) throws Throwable, IOException {
		FileInputStream file=new FileInputStream(IpathConstants.EXCEL_PATH);
		Workbook workbook=WorkbookFactory.create(file);
		workbook.createSheet(Sheet1).createRow(rowNo).createCell(rowNo).setCellValue(Value);
		
		FileOutputStream writeFile=new FileOutputStream(IpathConstants.EXCEL_PATH);
		workbook.write(writeFile);
		workbook.close();
	}
}
