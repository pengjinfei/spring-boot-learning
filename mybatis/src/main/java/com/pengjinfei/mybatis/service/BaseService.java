package com.pengjinfei.mybatis.service;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

/**
 * Created by Pengjinfei on 2017/5/2.
 * Description:
 */
public abstract class BaseService<T> {

    @Autowired
    BaseMapper<T> mapper;

    public List<T> selectByPage(int page, int rows) {
        PageHelper.startPage(page, rows);
        return mapper.selectAll();
    }

}
