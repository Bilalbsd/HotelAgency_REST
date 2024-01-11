package org.example.server;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.example.*;

@GrpcService
public class ReservationServerService extends ReservationServiceGrpc.ReservationServiceImplBase {
    @Override
    public void getReserevation(Reservation request, StreamObserver<Reservation> responseObserver) {
        DB.getReservationsFromDB()
                .stream()
                .filter(reservation -> reservation.getId() == request.getId())
                .findFirst()
                .ifPresent(responseObserver::onNext);
        responseObserver.onCompleted();
    }

    @Override
    public void makeReservation(ReservationRequest request, StreamObserver<Reservation> responseObserver) {
        DB.makeReservationFromDB(request)
                .stream()
                .findFirst()
                .ifPresent(responseObserver::onNext);
        responseObserver.onCompleted();
    }
}

