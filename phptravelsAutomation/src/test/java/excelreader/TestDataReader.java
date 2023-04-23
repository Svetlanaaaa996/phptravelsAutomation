package excelreader;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 * Class presenting a reader of Excel sheet.
 */
public final class TestDataReader {

    private static final String urlPath = "/testdata/TestData.xlsx";
	 
    final XSSFWorkbook workbook;
    final XSSFSheet sheet;

    public TestDataReader(int sheetNumber) throws IOException {
        URL sheetURL = TestDataReader.class.getResource(urlPath);
        FileInputStream excelFile = new FileInputStream(sheetURL.getPath());
        this.workbook = new XSSFWorkbook(excelFile);
        this.sheet = workbook.getSheetAt(sheetNumber);
    }

    public String getData(int rowNumber, int cellNumber) {
        return sheet.getRow(rowNumber).getCell(cellNumber).getStringCellValue();
    }
}
