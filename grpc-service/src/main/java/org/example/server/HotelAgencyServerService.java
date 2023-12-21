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
                .filter(author -> author.getId() == request.getId())
                .findFirst()
                .ifPresent(responseObserver::onNext);
        responseObserver.onCompleted();
    }

    @Override
    public void getOffer(Offer request, StreamObserver<Offer> responseObserver) {
        DB.getOffersFromDB()
                .stream()
                .filter(author -> author.getId() == request.getId())
                .findFirst()
                .ifPresent(responseObserver::onNext);
        responseObserver.onCompleted();
    }

    @Override
    public void checkAvailability(AvailabilityRequest request, StreamObserver<AvailabilityResponse> responseObserver) {
        // Implémentez la logique pour vérifier la disponibilité en fonction des paramètres de demande
        // Utilisez DB.getOffersFromDB() pour obtenir les offres disponibles depuis votre base de données
        // Supposons une logique simple pour cet exemple (retourner toutes les offres)
        AvailabilityResponse.Builder responseBuilder = AvailabilityResponse.newBuilder();
        DB.getOffersFromDB().forEach(offer -> responseBuilder.addAvailableOffers(offer));
        responseObserver.onNext(responseBuilder.build());
        responseObserver.onCompleted();
    }

}
