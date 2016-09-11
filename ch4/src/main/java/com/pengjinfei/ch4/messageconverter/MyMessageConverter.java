package com.pengjinfei.ch4.messageconverter;

import com.pengjinfei.ch4.domain.DemoObj;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by Pengjinfei on 16/9/10.
 * Description:
 */
public class MyMessageConverter extends AbstractHttpMessageConverter<DemoObj> {

    private Logger logger = LoggerFactory.getLogger(MyMessageConverter.class);

    public MyMessageConverter() {
        super(new MediaType("application", "pengjinfei", Charset.forName("UTF-8")));
    }

    @Override
    protected boolean supports(Class<?> aClass) {
        return DemoObj.class.isAssignableFrom(aClass);
    }

    @Override
    protected DemoObj readInternal(Class<? extends DemoObj> aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        String temp = StreamUtils.copyToString(httpInputMessage.getBody(), Charset.forName("UTF-8"));
        String[] split = temp.split("-");
        return new DemoObj(new Long(split[0]), split[1]);
    }

    @Override
    protected void writeInternal(DemoObj demoObj, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        String out = "hello: " + demoObj.getId() + "-" + demoObj.getName();
        httpOutputMessage.getBody().write(out.getBytes());
    }
}
