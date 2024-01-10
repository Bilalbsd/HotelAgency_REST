package org.example.client.controller;

import com.google.protobuf.Descriptors;
import org.example.Offer;
import org.example.Reservation;
import org.example.client.service.ReservationClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ReservationController {

    final ReservationClientService reservationClientService;


    public ReservationController(ReservationClientService reservationClientService) {
        this.reservationClientService = reservationClientService;
    }

    @PostMapping("/makereservation")
    public Reservation makeReservation() {
        return null;
    }

    @GetMapping("/reservation/{id}")
    public Map<Descriptors.FieldDescriptor, Object> getHotel(@PathVariable String id) {
        return reservationClientService.getReservation(Integer.parseInt(id));
    }

}
