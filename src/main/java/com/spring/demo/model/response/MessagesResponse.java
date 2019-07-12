package com.spring.demo.model.response;

import com.spring.demo.entity.SystemUser;

import java.util.Date;

public class MessagesResponse {

    private String message;

    public MessagesResponse(String message, Date messageDate, SystemUser sender, SystemUser reciever, int messageStatus) {
        this.message = message;
        this.messageDate = messageDate;
        this.sender = sender;
        this.reciever = reciever;
        this.messageStatus = messageStatus;
    }

    public String getMessage() {
        return message;
    }

    public MessagesResponse() {
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(Date messageDate) {
        this.messageDate = messageDate;
    }

    public SystemUser getSender() {
        return sender;
    }

    public void setSender(SystemUser sender) {
        this.sender = sender;
    }

    public SystemUser getReciever() {
        return reciever;
    }

    public void setReciever(SystemUser reciever) {
        this.reciever = reciever;
    }

    public int getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(int messageStatus) {
        this.messageStatus = messageStatus;
    }

    private Date messageDate;

    private SystemUser sender;

    private SystemUser reciever;

    private int messageStatus;
}
