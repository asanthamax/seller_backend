package com.spring.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "Reservation")
public class ReservationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public ReservationEntity() {
    }

    public ReservationEntity(LocalDate checkin, LocalDate checkout) {
        this.checkin = checkin;

        this.checkout = checkout;
    }

    @NotNull
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate checkin;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getCheckin() {
        return checkin;
    }

    public void setCheckin(LocalDate checkin) {
        this.checkin = checkin;
    }

    public LocalDate getCheckout() {
        return checkout;
    }

    public void setCheckout(LocalDate checkout) {
        this.checkout = checkout;
    }

    @NotNull
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate checkout;

    public RoomEntity getRoomEntity() {
        return roomEntity;
    }

    public void setRoomEntity(RoomEntity roomEntity) {
        this.roomEntity = roomEntity;
    }

    @ManyToOne
    private RoomEntity roomEntity;
}
