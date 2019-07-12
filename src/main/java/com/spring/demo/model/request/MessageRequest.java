package com.spring.demo.model.request;

public class MessageRequest {

    private String message;

    public MessageRequest(String message, Long orderId, Long senderId, Long recieverId) {
        this.message = message;
        this.orderId = orderId;
        this.senderId = senderId;
        this.recieverId = recieverId;
    }

    private Long orderId;

    public String getMessage() {
        return message;
    }

    public MessageRequest() {
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getRecieverId() {
        return recieverId;
    }

    public void setRecieverId(Long recieverId) {
        this.recieverId = recieverId;
    }

    private Long senderId;

    private Long recieverId;
}
