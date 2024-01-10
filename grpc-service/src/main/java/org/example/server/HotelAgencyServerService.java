package org.example.server;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.example.*;

@GrpcService
public class HotelAgencyServerService extends HotelAgencyServiceGrpc.HotelAgencyServiceImplBase {

    @Override
    public void getClient(Client request, StreamObserver<Client> responseObserver) {
        DB.getClientsFromDB()
                .stream()
                .filter(client -> client.getId() == request.getId())
                .findFirst()
                .ifPresent(responseObserver::onNext);
        responseObserver.onCompleted();
    }

    @Override
    public void getOffer(Offer request, StreamObserver<Offer> responseObserver) {
        DB.getOffersFromDB()
                .stream()
                .filter(offer -> offer.getId() == request.getId())
                .findFirst()
                .ifPresent(responseObserver::onNext);
        responseObserver.onCompleted();
    }

    @Override
    public void getHotel(Hotel request, StreamObserver<Hotel> responseObserver) {
        DB.getHotelsFromDB()
                .stream()
                .filter(hotel -> hotel.getId() == request.getId())
                .findFirst()
                .ifPresent(responseObserver::onNext);
        responseObserver.onCompleted();
    }

    @Override
    public void getRoom(Room request, StreamObserver<Room> responseObserver) {
        DB.getRoomsFromDB()
                .stream()
                .filter(room -> room.getId() == request.getId())
                .findFirst()
                .ifPresent(responseObserver::onNext);
        responseObserver.onCompleted();
    }


    @Override
    public void checkAvailability(AvailabilityRequest request, StreamObserver<Offer> responseObserver) {
        DB.checkAvailabilityFromDB(request)
                .stream()
                .findFirst()
                .ifPresent(responseObserver::onNext);
        responseObserver.onCompleted();
    }

}
