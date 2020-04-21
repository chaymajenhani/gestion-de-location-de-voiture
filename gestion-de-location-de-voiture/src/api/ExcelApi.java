package api;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExcelApi {

	public FileInputStream fis = null;
	public FileOutputStream fos = null;
	public XSSFWorkbook workbook = null;
	public XSSFSheet sheet = null;
	public XSSFRow row = null;
	public XSSFCell cell = null;
	public File f = null;

	public ExcelApi() {

		try {
			File f = new File("donnees.xlsx");
			

			if (!f.exists()) {
				
				String[] clientCol = { "CIN", "Nom", "Prenom", "Adresse", "Numero de permis" };
				String[] vehiculeCol = { "Matricule", "Marque", "Couleur", "Categorie", "Kilometrage", "Disponibilite",
						"Date entree", "Nombre de location", "Prix de location"};
				String[] locationCol = { "Code location", "CIN Client", "Matricule Vehicule", "Date location",
						"Date debut", "Date fin", "Avec/Sans Chauffeur","Type de paiement"  };

				
				workbook = new XSSFWorkbook();
				
				Font headerFont = workbook.createFont();
				headerFont.setBold(true);
				CellStyle headerCellStyle = workbook.createCellStyle();
				headerCellStyle.setFont(headerFont);
				

				sheet = workbook.createSheet("Client");
				Row headerRow = sheet.createRow(0);
				for (int i = 0; i < clientCol.length; i++) {
					Cell cell = headerRow.createCell(i);
					cell.setCellValue(clientCol[i]);
					cell.setCellStyle(headerCellStyle);
					 sheet.autoSizeColumn(i);
					
				}
				sheet = workbook.createSheet("Vehicule");
				headerRow = sheet.createRow(0);
				for (int i = 0; i < vehiculeCol.length; i++) {
					Cell cell = headerRow.createCell(i);
					cell.setCellValue(vehiculeCol[i]);
					cell.setCellStyle(headerCellStyle);
					 sheet.autoSizeColumn(i);
				}
				sheet = workbook.createSheet("Location");
				headerRow = sheet.createRow(0);

				for (int i = 0; i < locationCol.length; i++) {
					Cell cell = headerRow.createCell(i);
					cell.setCellValue(locationCol[i]);
					cell.setCellStyle(headerCellStyle);
					 sheet.autoSizeColumn(i);
				}
				
			} else {
				workbook = new XSSFWorkbook(f);
				fis = new FileInputStream(f);
				fis.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

	public String getCellData(String sheetName, int colNum, int rowNum) {
		try {
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(rowNum);
			cell = row.getCell(colNum);


			if (cell.getCellType() == CellType.STRING)
				return cell.getStringCellValue();
			else if (cell.getCellType() == CellType.NUMERIC || cell.getCellType() == CellType.FORMULA) {
				String cellValue = String.valueOf(cell.getNumericCellValue());
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					Date date = cell.getDateCellValue();
					cellValue = df.format(date);
				}
				return cellValue;
			} else if (cell.getCellTypeEnum() == CellType.BLANK)
				return "";
			else
				return String.valueOf(cell.getBooleanCellValue());}

		catch (Exception e) {
			e.printStackTrace();
			return "row " + rowNum + " or column " + colNum + " does not exist  in Excel";
		}
	}

	public boolean setCellData(String sheetName, String colName, int rowNum, String value) {
		try {

			int col_Num = -1;
			sheet = workbook.getSheet(sheetName);

			row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().trim().equals(colName)) {
					col_Num = i;
				}
			}

			row = sheet.getRow(rowNum);
			if (row == null)
				row = sheet.createRow(rowNum);

			cell = row.getCell(col_Num);
			if (cell == null)
				cell = row.createCell(col_Num);

			cell.setCellValue(value);

			fos = new FileOutputStream("donnees.xlsx");
			workbook.write(fos);
			fos.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	public int searchData(String sheetName, String colName, String value) {

		sheet = workbook.getSheet(sheetName);
		int colNum = -1;
		row = sheet.getRow(0);
		for (int i = 0; i < row.getLastCellNum(); i++) {
			if (row.getCell(i).getStringCellValue().trim().equals(colName)) {
				colNum = i;
			}
			for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
				if (getCellData(sheetName, colNum, rowIndex).equals(value))
					return rowIndex;
			}
		}
		return -1;
	}

	public boolean removeRow(String sheetName, int rowNum) {
		Row row = workbook.getSheet(sheetName).getRow(rowNum);
		sheet.removeRow(row);
		try {
			fos = new FileOutputStream(f);
			workbook.write(fos);

			fos.close();

		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
		return true;
	}

}
