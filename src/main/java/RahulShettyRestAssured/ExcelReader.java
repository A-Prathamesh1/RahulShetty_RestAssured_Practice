package RahulShettyRestAssured;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReader {
    public static List<String> getDataForTest(String testName) throws IOException {
        // identify the sheet's row for headings by reading first row
        // identify the purchase row from sheet and provide ot to the test case
        List<String> testDataList = new ArrayList<>();
        FileInputStream fis = new FileInputStream("C:\\Users\\praausek\\Documents\\Courses\\Rest API Testing (Automation) from Scratch-Rest Assured Java\\Book1.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        int sheetsCount = workbook.getNumberOfSheets(); // get total number of sheets
        for (int i = 0; i < sheetsCount; i++) {
            if (workbook.getSheetName(i).equalsIgnoreCase("sheet1")) {// get each sheet
                XSSFSheet sheet = workbook.getSheetAt(i);
                // get the rows
                Iterator<Row> rowIt = sheet.iterator();

                Row firstRow = rowIt.next();
                Iterator<Cell> firstCellOf1stRow = firstRow.cellIterator();// get

                int col = 0;
                int k = 0;
                while (firstCellOf1stRow.hasNext()) {
                    Cell cellValue = firstCellOf1stRow.next();
                    if (cellValue.getStringCellValue().equalsIgnoreCase("TestCase")) {
                        col = k;
                        System.out.println("column of TestCase:" + col);
                        break;
//                        System.out.println(cellValue);
                    }
                    k++;
                }

                while (rowIt.hasNext()) {
                    Row r = rowIt.next();
                    if (r.getCell(col).getStringCellValue().equalsIgnoreCase(testName)) {
                        Iterator<Cell> cellIt = r.cellIterator();
                        while (cellIt.hasNext()) {
                            Cell c = cellIt.next();

                            if (c.getCellType() == CellType.STRING) {
                                testDataList.add(c.getStringCellValue());
                            } else if (c.getCellType() == CellType.NUMERIC) {
                                testDataList.add(NumberToTextConverter.toText(c.getNumericCellValue()));
                            }
                        }
                    }
                }

            }
        }
        return testDataList;
    }

//    public static void main(String[] args) throws IOException {
//        System.out.println(getDataForTest("Purchase"));
//    }
}
