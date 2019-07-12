package com.spring.demo.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "messages")
public class Messages {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "messageID")
    private Long messageID;

    public Long getMessageID() {
        return messageID;
    }

    public Messages() {
    }

    public Messages(String messageText, Date messageDate, SystemUser sender, SystemUser reciever, int messageStaus, Order order) {
        this.messageText = messageText;
        this.messageDate = messageDate;

        this.sender = sender;
        this.reciever = reciever;
        this.messageStaus = messageStaus;
        this.order = order;
    }

    public void setMessageID(Long messageID) {
        this.messageID = messageID;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
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

    public int getMessageStaus() {
        return messageStaus;
    }

    public void setMessageStaus(int messageStaus) {
        this.messageStaus = messageStaus;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Column(name = "messageText")

    private String messageText;

    @Column(name = "messageDate")
    private Date messageDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id")
    private SystemUser sender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reciever_id")
    private SystemUser reciever;


    @Column(name = "messageStatus")
    private int messageStaus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id",nullable = false)
    private Order order;

}
