package org.example.client.controller;

import com.google.protobuf.Descriptors;
import org.example.AvailabilityRequest;
import org.example.Offer;
import org.example.Reservation;
import org.example.ReservationRequest;
import org.example.client.service.ReservationClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ReservationController {

    final ReservationClientService reservationClientService;


    public ReservationController(ReservationClientService reservationClientService) {
        this.reservationClientService = reservationClientService;
    }

    @GetMapping("/reservation/{id}")
    public Map<Descriptors.FieldDescriptor, Object> getReservation(@PathVariable String id) {
        return reservationClientService.getReservation(Integer.parseInt(id));
    }

    @PostMapping("/makeReservation")
    public Map<Descriptors.FieldDescriptor, Object> makeReservation(
            @RequestParam int agencyId,
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam int offerId,
            @RequestParam int clientId) {

        ReservationRequest.Builder reservationRequest = ReservationRequest.newBuilder()
                .setAgencyId(agencyId)
                .setUsername(username)
                .setPassword(password)
                .setOfferId(offerId)
                .setClientId(clientId);

        return reservationClientService.makeReservation(reservationRequest);
    }

}
