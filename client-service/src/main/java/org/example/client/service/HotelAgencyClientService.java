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
import java.util.concurrent.CountDownLatch;

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

    public List<Offer> checkAvailability(AvailabilityRequest availabilityRequest) {
        CompletableFuture<List<Offer>> resultFuture = new CompletableFuture<>();

        // Appeler le service gRPC de manière asynchrone
        StreamObserver<AvailabilityResponse> responseObserver = new StreamObserver<AvailabilityResponse>() {
            private final List<Offer> availableOffers = new ArrayList<>();

            @Override
            public void onNext(AvailabilityResponse value) {
                // Ajouter les offres disponibles à la liste
                availableOffers.addAll(value.getAvailableOffersList());
            }

            @Override
            public void onError(Throwable t) {
                // Gérer les erreurs, si nécessaire
                resultFuture.completeExceptionally(t);
            }

            @Override
            public void onCompleted() {
                // Compléter le futur avec la liste des offres disponibles
                resultFuture.complete(availableOffers);
            }
        };

        // Appeler le service gRPC de manière asynchrone
        asynchronousClient.checkAvailability(availabilityRequest, responseObserver);

        // Attendre la fin de l'appel asynchrone et récupérer le résultat
        return resultFuture.join();
    }
}
