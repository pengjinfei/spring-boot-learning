package com.pengjinfei.ch2.el;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by Pengjinfei on 16/9/10.
 * Description:
 */
@Service
public class DemoService {

    @Value("其他类属性")
    private String another;

    public String getAnother() {
        return another;
    }

    public void setAnother(String another) {
        this.another = another;
    }
}
