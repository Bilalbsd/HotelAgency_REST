package org.example.server;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.example.ReservationRequest;
import org.example.ReservationResponse;
import org.example.ReservationServiceGrpc;

@GrpcService
public class ReservationServerService extends ReservationServiceGrpc.ReservationServiceImplBase {

    @Override
    public void makeReservation(ReservationRequest request, StreamObserver<ReservationResponse> responseObserver) {
        super.makeReservation(request, responseObserver);
    }
}

