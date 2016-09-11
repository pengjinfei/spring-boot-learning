package com.pengjinfei.ch7.websocket;

/**
 * Created by Pengjinfei on 16/9/11.
 * Description:
 */
public class Response {
    private String responseMessage;

    public Response(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
