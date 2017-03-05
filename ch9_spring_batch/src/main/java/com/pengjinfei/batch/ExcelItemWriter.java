package com.pengjinfei.batch;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.file.ResourceAwareItemWriterItemStream;
import org.springframework.batch.item.support.AbstractItemStreamItemWriter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by Pengjinfei on 2017/3/4.
 * Description:
 */
@Slf4j
public class ExcelItemWriter<T> extends AbstractItemStreamItemWriter<T> implements ResourceAwareItemWriterItemStream<T>,
        InitializingBean {

    private static final String LINES_WRITTEN = "excel.lines.written";
    private Resource resource;
    @Setter
    private String[] headers;
    @Setter
    private boolean saveState = false;
    private int currentLine = 0;

    @Setter
    private ExcelRowMapper<T> rowMapper;
    private SXSSFWorkbook workbook;
    private SXSSFSheet sheet;

    public ExcelItemWriter() {
        this.setExecutionContextName(ClassUtils.getShortName(ExcelItemWriter.class));
    }

    @Override
    public void setResource(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void write(List<? extends T> items) throws Exception {
        for (T item : items) {
            SXSSFRow row = sheet.createRow(currentLine++);
            rowMapper.rowMapper(item,row);
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.notNull(rowMapper,"Excel RowMapper must not be null.");
    }

    @Override
    public void open(ExecutionContext executionContext) {
        super.open(executionContext);
        if (executionContext.containsKey(LINES_WRITTEN)) {
            //retry strategy
            currentLine = executionContext.getInt(LINES_WRITTEN);
            try {
                workbook = new SXSSFWorkbook((XSSFWorkbook) WorkbookFactory.create(resource.getInputStream()), 100);
            } catch (IOException | InvalidFormatException e) {
                log.info("Reopen excel file failed.",e);
                throw new ItemStreamException(e);
            }
        } else {
            workbook = new SXSSFWorkbook(100);
            sheet = workbook.createSheet();
            if (headers.length != 0) {
                SXSSFRow row = sheet.createRow(0);
                for (int i = 0; i < headers.length; i++) {
                    SXSSFCell cell = row.createCell(i, CellType.STRING);
                    cell.setCellValue(headers[i]);
                }
                currentLine=1;
            }
        }
    }

    @Override
    public void close() {
        super.close();
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(resource.getFile());
            workbook.write(outputStream);
        } catch (IOException e) {
            log.error("Failed to write stream to excel.",e);
            throw new ItemStreamException(e);
        }finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void update(ExecutionContext executionContext) {
        super.update(executionContext);
        if (saveState) {
            executionContext.putInt(LINES_WRITTEN, currentLine);
        }
    }
}
