package org.example.client.controller;

import com.google.protobuf.Descriptors;
import org.example.AvailabilityRequest;
import org.example.Offer;
import org.example.client.service.HotelAgencyClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HotelAgencyController {

    final HotelAgencyClientService hotelAgencyClientService;

    public HotelAgencyController(HotelAgencyClientService hotelAgencyClientService) {
        this.hotelAgencyClientService = hotelAgencyClientService;
    }

    @GetMapping("/client/{id}")
    public Map<Descriptors.FieldDescriptor, Object> getClient(@PathVariable String id) {
        return hotelAgencyClientService.getClient(Integer.parseInt(id));
    }

    @GetMapping("/offer/{id}")
    public Map<Descriptors.FieldDescriptor, Object> getOffer(@PathVariable String id) {
        return hotelAgencyClientService.getOffer(Integer.parseInt(id));
    }

    @GetMapping("/hotel/{id}")
    public Map<Descriptors.FieldDescriptor, Object> getHotel(@PathVariable String id) {
        return hotelAgencyClientService.getHotel(Integer.parseInt(id));
    }

    @GetMapping("/room/{id}")
    public Map<Descriptors.FieldDescriptor, Object> getRoom(@PathVariable String id) {
        return hotelAgencyClientService.getRoom(Integer.parseInt(id));
    }

    @GetMapping("/agency/{id}")
    public Map<Descriptors.FieldDescriptor, Object> getAgency(@PathVariable String id) {
        return hotelAgencyClientService.getAgency(Integer.parseInt(id));
    }

    @GetMapping("/checkAvailability")
    public Map<Descriptors.FieldDescriptor, Object> checkAvailability(
            @RequestParam int agencyId,
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String startDate,
            @RequestParam String endDate,
            @RequestParam int nbGuests) {

        AvailabilityRequest.Builder availabilityRequest = AvailabilityRequest.newBuilder()
                .setAgencyId(agencyId)
                .setUsername(username)
                .setPassword(password)
                .setStartDate(startDate)
                .setEndDate(endDate)
                .setNbGuests(nbGuests);

        return hotelAgencyClientService.checkAvailability(availabilityRequest);
    }

}
