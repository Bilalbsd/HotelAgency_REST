package org.example.client.service;

import com.google.protobuf.Descriptors;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.example.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Service
public class HotelAgencyClientService {

    @GrpcClient("grpc-example-service")
    HotelAgencyServiceGrpc.HotelAgencyServiceBlockingStub synchronousClient;

    @GrpcClient("grpc-example-service")
    HotelAgencyServiceGrpc.HotelAgencyServiceStub asynchronousClient;

    public Map<Descriptors.FieldDescriptor, Object> getClient(int clientId) {
        Client clientRequest = Client.newBuilder().setId(clientId).build();
        Client clientResponse = synchronousClient.getClient(clientRequest);
        return clientResponse.getAllFields();
    }

    public Map<Descriptors.FieldDescriptor, Object> getOffer(int offerId) {
        Offer offerRequest = Offer.newBuilder().setId(offerId).build();
        Offer offerResponse = synchronousClient.getOffer(offerRequest);
        return offerResponse.getAllFields();
    }

    public Map<Descriptors.FieldDescriptor, Object> getHotel(int hotelId) {
        Hotel hotelRequest = Hotel.newBuilder().setId(hotelId).build();
        Hotel hotelResponse = synchronousClient.getHotel(hotelRequest);
        return hotelResponse.getAllFields();
    }

    public Map<Descriptors.FieldDescriptor, Object> getRoom(int roomId) {
        Room roomRequest = Room.newBuilder().setId(roomId).build();
        Room roomResponse = synchronousClient.getRoom(roomRequest);
        return roomResponse.getAllFields();
    }

    public Map<Descriptors.FieldDescriptor, Object> getAgency(int agencyId) {
        Agency agencyRequest = Agency.newBuilder().setId(agencyId).build();
        Agency agencyResponse = synchronousClient.getAgency(agencyRequest);
        return agencyResponse.getAllFields();
    }

    public Map<Descriptors.FieldDescriptor, Object> checkAvailability(AvailabilityRequest.Builder availabilityRequest) {
        Offer offerRequest = Offer.newBuilder().setId(1).build();
        Offer offerResponse = synchronousClient.getOffer(offerRequest);
        return offerResponse.getAllFields();
    }
}
