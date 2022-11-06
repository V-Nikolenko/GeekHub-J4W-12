package edu.geekhub.models.request;

public class Response {

    private Object data;
    private final ResponseStatus status;

    public Response(ResponseStatus status) {
        this.status = status;
    }

    private Response(Object data, ResponseStatus status) {
        this.data = data;
        this.status = status;
    }

    public static Response ok() {
        return new Response(ResponseStatus.SUCCESS);
    }

    public static Response ok(Object data) {
        return new Response(data, ResponseStatus.SUCCESS);
    }

    public static Response fail() {
        return new Response(ResponseStatus.FAIL);
    }

    public static Response fail(Object data) {
        return new Response(data, ResponseStatus.FAIL);
    }

    public Object getData() {
        return data;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Response {" +
                "data=" + data +
                ", status=" + status +
                '}';
    }
}
