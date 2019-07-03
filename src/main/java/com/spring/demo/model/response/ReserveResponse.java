package com.spring.demo.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class ReserveResponse {

    private Long id;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate checkin;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate checkout;

    public ReserveResponse() {
    }

    public ReserveResponse(Long id, LocalDate checkin, LocalDate checkout) {
        this.id = id;
        this.checkin = checkin;
        this.checkout = checkout;

    }

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
}
