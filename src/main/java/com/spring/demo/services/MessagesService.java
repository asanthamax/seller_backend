package com.spring.demo.services;

import com.spring.demo.entity.Messages;
import com.spring.demo.entity.Order;
import com.spring.demo.entity.SystemUser;
import com.spring.demo.errors.RequestNotFoundException;
import com.spring.demo.model.request.MessageRequest;
import com.spring.demo.model.response.MessagesResponse;
import com.spring.demo.repository.MessagesRepository;
import com.spring.demo.repository.OrderRepository;
import com.spring.demo.repository.SystemUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MessagesService {

    private final MessagesRepository messagesRepository;
    private final OrderRepository orderRepository;
    private final SystemUserRepository userRepository;

    @Autowired
    public MessagesService(MessagesRepository messagesRepository, OrderRepository orderRepo, SystemUserRepository userRepo){

        this.messagesRepository = messagesRepository;
        this.orderRepository = orderRepo;
        this.userRepository = userRepo;
    }

    public Page<MessagesResponse> getAllMessages(Pageable pageable) throws DataAccessException{

        Page<Messages> allMessages = this.messagesRepository.findAll(pageable);
        List<MessagesResponse> messageList = new ArrayList<>();
        for (Messages message:allMessages){

            MessagesResponse response = new MessagesResponse();
            response.setMessage(message.getMessageText());
            response.setMessageDate(message.getMessageDate());
            response.setMessageStatus(message.getMessageStaus());
            response.setReciever(message.getReciever());
            response.setSender(message.getSender());
            messageList.add(response);
        }
        return new PageImpl<>(messageList, pageable, messageList.size());
    }

    public void saveNewMessage(MessageRequest messageRequest) throws RequestNotFoundException,DataAccessException {

        Messages newMessage = new Messages();
        newMessage.setMessageDate(new Date());
        newMessage.setMessageStaus(2);
        newMessage.setMessageText(messageRequest.getMessage());
        Optional<Order> order = this.orderRepository.findById(messageRequest.getOrderId());
        if(order.isPresent()){

            newMessage.setOrder(order.get());
        }else{

            throw new RequestNotFoundException("Order not found");
        }
        Optional<SystemUser> sender = this.userRepository.findById(messageRequest.getSenderId());
        if(sender.isPresent()){

            newMessage.setSender(sender.get());
        }else{

            throw new RequestNotFoundException("Sender not a registered user");
        }
        Optional<SystemUser> reciver = this.userRepository.findById(messageRequest.getRecieverId());
        if(reciver.isPresent()){

            newMessage.setReciever(reciver.get());
        }else{

            throw new RequestNotFoundException("Reciever is not a valid registered user");
        }
        this.messagesRepository.save(newMessage);
    }


    public Page<MessagesResponse> getMessagesByOrder(Pageable pageable, Long orderId) throws DataAccessException {

        Page<Messages> messagesByOrder = messagesRepository.findByOrderId(orderId, pageable);
        List<MessagesResponse> messagesResponses = new ArrayList<>();
        for(Messages message: messagesByOrder){

            MessagesResponse response = new MessagesResponse();
            response.setSender(message.getSender());
            response.setReciever(message.getReciever());
            response.setMessageStatus(message.getMessageStaus());
            response.setMessageDate(message.getMessageDate());
            response.setMessage(message.getMessageText());
            messagesResponses.add(response);
        }
        return new PageImpl<>(messagesResponses, pageable, messagesResponses.size());
    }
}
