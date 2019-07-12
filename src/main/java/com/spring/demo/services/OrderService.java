package com.spring.demo.services;

import com.spring.demo.entity.Order;
import com.spring.demo.entity.OrderProdutVariation;
import com.spring.demo.entity.ProductVariations;
import com.spring.demo.errors.RequestNotFoundException;
import com.spring.demo.model.response.OrderProductVariationResponse;
import com.spring.demo.model.response.OrderResponse;
import com.spring.demo.model.response.ProductVariationResponse;
import com.spring.demo.repository.OrderProductVariationRepository;
import com.spring.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    private final OrderProductVariationRepository orderVariationRepository;

    @Autowired
    public OrderService(OrderRepository orderRepo, OrderProductVariationRepository orderVariationRepository){

        this.orderRepository = orderRepo;
        this.orderVariationRepository = orderVariationRepository;
    }

    public Page<OrderResponse> getAllOrders(Pageable pageable, Long sellerID) throws DataAccessException {

        Page<Order> pageOrders = orderRepository.getOrdersBySeller(sellerID, pageable);
        List<OrderResponse> orderResponses = new ArrayList<>();
        for(Order order: pageOrders){

            OrderResponse singleResponse = new OrderResponse();
            singleResponse.setCustomer(order.getCustomer());
            singleResponse.setOrderAmount(order.getOrderAmount());
            singleResponse.setOrderDate(order.getOrderedDate());
            singleResponse.setOrderID(order.getOrderID());
            singleResponse.setSeller(order.getSeller());
            singleResponse.setShippingMethod(order.getShippingMethod());
            List<OrderProductVariationResponse> orderList = new ArrayList<>();
            Collection<ProductVariations> variations = order.getProductVariation();
            arrangeVariations(orderList, variations);
            singleResponse.setOrderVariation(orderList);
            orderResponses.add(singleResponse);
        }
        return new PageImpl<>(orderResponses, pageable, orderResponses.size());
    }

    public OrderResponse getSingleOrder(Long orderID) throws RequestNotFoundException{

        Optional<Order> order = orderRepository.findById(orderID);
        if(order.isPresent()){

            Order order1 = order.get();
            OrderResponse singleResponse = new OrderResponse();
            singleResponse.setCustomer(order1.getCustomer());
            singleResponse.setOrderAmount(order1.getOrderAmount());
            singleResponse.setOrderDate(order1.getOrderedDate());
            singleResponse.setOrderID(order1.getOrderID());
            singleResponse.setSeller(order1.getSeller());
            singleResponse.setShippingMethod(order1.getShippingMethod());
            List<OrderProductVariationResponse> orderList = new ArrayList<>();
            Collection<ProductVariations> variations = order1.getProductVariation();
            arrangeVariations(orderList, variations);
            singleResponse.setOrderVariation(orderList);
            return singleResponse;
        }else{

            throw new RequestNotFoundException("given order is not exists");
        }
    }

    private void arrangeVariations(List<OrderProductVariationResponse> orderList, Collection<ProductVariations> variations) {
        for(ProductVariations productVar: variations){

            OrderProductVariationResponse variationResponse = new OrderProductVariationResponse();
            variationResponse.setProductName(productVar.getProduct().getProductName());
            List<ProductVariationResponse> productResponses = new ArrayList<>();
            List<OrderProdutVariation> orderProdutVariation = orderVariationRepository.findByVariationId(productVar.getId());
            for(OrderProdutVariation orderProdutVariation1: orderProdutVariation){

                ProductVariationResponse prResp = new ProductVariationResponse();
                prResp.setVariation(orderProdutVariation1.getVariations().getVariationValue());
                prResp.setQunatity(orderProdutVariation1.getQuantity());
                prResp.setVariationPrice(orderProdutVariation1.getVariations().getVariationSalePrice());
                productResponses.add(prResp);
            }
            variationResponse.setProductVariation(productResponses);
            orderList.add(variationResponse);
        }
    }
}
