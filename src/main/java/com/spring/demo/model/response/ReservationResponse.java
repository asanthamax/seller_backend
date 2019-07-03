package com.spring.demo.model.response;

import com.spring.demo.entity.ReservationEntity;

import java.util.List;

public class ReservationResponse {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Link getLinks() {
        return links;
    }

    public void setLinks(Link links) {
        this.links = links;
    }

    public ReservationResponse(Integer roomNumber, Integer price) {
        this.roomNumber = roomNumber;
        this.price = price;
    }

    public ReservationResponse() {
    }

    private Long id;
    private Integer roomNumber;
    private Integer price;
    private Link links;

    public List<ReservationEntity> getReservations() {
        return reservations;
    }

    public void setReservations(List<ReservationEntity> reservations) {
        this.reservations = reservations;
    }

    private List<ReservationEntity> reservations;
}
