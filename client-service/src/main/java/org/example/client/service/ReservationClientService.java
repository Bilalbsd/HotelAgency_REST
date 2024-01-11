package org.example.client.service;

import com.google.protobuf.Descriptors;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.example.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReservationClientService {

    @GrpcClient("grpc-example-service")
    ReservationServiceGrpc.ReservationServiceBlockingStub synchronousClient;

    @GrpcClient("grpc-example-service")
    ReservationServiceGrpc.ReservationServiceStub asynchronousClient;

    public Map<Descriptors.FieldDescriptor, Object> getReservation(int reservationId) {
        Reservation reservationRequest = Reservation.newBuilder().setId(reservationId).build();
        Reservation reservationResponse = synchronousClient.getReservation(reservationRequest);
        return reservationResponse.getAllFields();
    }

    public Map<Descriptors.FieldDescriptor, Object> makeReservation(ReservationRequest.Builder resRequest) {
        Reservation reservationRequest = Reservation.newBuilder().setId(1).build();
        Reservation reservationResponse = synchronousClient.getReservation(reservationRequest);
        return reservationResponse.getAllFields();
    }


}
