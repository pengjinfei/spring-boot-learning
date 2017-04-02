package com.pengjinfei.batch;

import org.springframework.batch.item.file.ResourceAwareItemReaderItemStream;
import org.springframework.batch.item.support.AbstractItemCountingItemStreamItemReader;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;

/**
 * Created by Pengjinfei on 2017/3/4.
 * Description:
 */
public class ExcelItemReader<T> extends AbstractItemCountingItemStreamItemReader<T> implements
        ResourceAwareItemReaderItemStream<T>, InitializingBean {

    private Resource resource;
    @Override
    public void setResource(Resource resource) {
        this.resource=resource;
    }

    @Override
    protected T doRead() throws Exception {
        return null;
    }

    @Override
    protected void doOpen() throws Exception {

    }

    @Override
    protected void doClose() throws Exception {

    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
