package com.spring.demo.entity;

import com.spring.demo.model.response.ReservationResponse;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Room")
public class RoomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private Integer roomNumber;

    @NotNull
    private String price;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<ReservationEntity> reservationEntities;

    public List<ReservationEntity> getReservationEntities() {
        return reservationEntities;
    }

    public void setReservationEntities(List<ReservationEntity> reservationEntities) {
        this.reservationEntities = reservationEntities;
    }

    public RoomEntity() {
    }

    public RoomEntity(@NotNull Integer roomNumber, @NotNull String price) {

        this.roomNumber = roomNumber;
        this.price = price;
    }

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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void addReservationEntity(ReservationEntity entity){

        if(this.reservationEntities == null){

            this.reservationEntities = new ArrayList<>();
        }
        this.reservationEntities.add(entity);
    }
}
