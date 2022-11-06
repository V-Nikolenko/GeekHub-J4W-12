package edu.geekhub.models.request;

import static java.util.Objects.isNull;

public class Request {

    private Object data;

    public Request() {
    }

    public Request(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    @Override
    public String toString() {
        String requestData = isNull(data) ? "no data" : data.toString();
        return "Request{" +
                "data=" + requestData +
                '}';
    }
}
