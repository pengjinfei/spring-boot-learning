package com.pengjinfei.batch;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * Created by Pengjinfei on 2017/3/4.
 * Description:
 */
public class ExcelItemWriterTest {

    @Test
    public void testAppendExcel() throws Exception {
        InputStream inp = new FileInputStream("/Users/Pengjinfei/Documents/temp/1.xlsx");
// notice how the Workbook must be constructed from the existing file
        Workbook wb = WorkbookFactory.create(inp);
// Navigating in POI always follows the same logic:
// 1. grab a sheet
// 2. grab a row from that sheet
// 3. grab a cell from that row
        Sheet sheet = wb.getSheetAt(0);
        Row row1 = sheet.createRow(1);
        Cell cell = row1.createCell(1);

        //Row row = sheet.getRow(2);
        //Cell cell = row.getCell(3);
// a condition like the one that follows will be needed to know in what column
// you have to write your data:
//        if (cell == null)
//            cell = row.createCell(3);
        cell.setCellType(Cell.CELL_TYPE_STRING);
        cell.setCellValue("a test");

// Write the output to a file
        FileOutputStream fileOut = new FileOutputStream("/Users/Pengjinfei/Documents/temp/1.xlsx");
        wb.write(fileOut);
        fileOut.close();
    }

}