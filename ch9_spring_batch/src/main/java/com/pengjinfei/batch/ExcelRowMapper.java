package com.pengjinfei.batch;

import org.apache.poi.ss.usermodel.Row;

/**
 * Created by Pengjinfei on 2017/3/4.
 * Description:
 */
public interface ExcelRowMapper<T> {

    void rowMapper(T item, Row row);
}
