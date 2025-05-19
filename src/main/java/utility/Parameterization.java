package utility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Parameterization {

    public static String getDataFromExcel(String sheetName, int row, int cell) throws EncryptedDocumentException, IOException {
        // Correct path to the Excel file (include file name with extension)
        FileInputStream file = new FileInputStream("C:/Users/sheet/eclipse-workspace/shypbuddyversion/ShypBuddyLogistic/src/test/resources/TestData.xlsx");

        // Read the cell value and return it
        String value = WorkbookFactory.create(file)
                                      .getSheet(sheetName)
                                      .getRow(row)
                                      .getCell(cell)
                                      .getStringCellValue();

        return value;
    }
}

