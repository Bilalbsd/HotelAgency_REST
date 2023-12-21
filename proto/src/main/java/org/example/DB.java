package org.example;

import java.util.ArrayList;
import java.util.List;

public class DB {

    public static List<Client> getClientsFromDB() {
        return new ArrayList<Client>() {
            {
                add(Client.newBuilder().setId(1).setFirstName("Charles").setLastName("Dickens").setCardNumber("0188737483").setCcv("123").build());
                add(Client.newBuilder().setId(2).setFirstName("William").setLastName("Shakespeare").setCardNumber("93783904").setCcv("123").build());
                add(Client.newBuilder().setId(3).setFirstName("JK").setLastName("Rowling").setCardNumber("93807398065930").setCcv("123").build());
            }
        };
    }

    public static List<Agency> getAgencysFromDB() {
        return new ArrayList<Agency>() {
            {
                add(Agency.newBuilder().setId(1).setAgencyName("Agency1").setUsername("username").setPassword("password").setDiscount(0.5).build());
            }
        };
    }

    public static List<Hotel> getHotelsFromDB() {
        return new ArrayList<Hotel>() {
            {
                add(Hotel.newBuilder().setId(1).setHotelName("HotelName").setAddress("75 Avenue Augustin Fliche").setCountry("France").setCity("Montpellier").setNbStars(3).build());
            }
        };
    }

    public static List<Room> getRoomsFromDB() {
        return new ArrayList<Room>() {
            {
                add(Room.newBuilder().setId(1).setRoomType("Seul").setNbBeds(1).setImage("linktoImage1").build());
                add(Room.newBuilder().setId(2).setRoomType("Double").setNbBeds(2).setImage("linktoImage2").build());
            }
        };
    }

    public static List<Offer> getOffersFromDB() {
        return new ArrayList<Offer>() {
            {
                add(Offer.newBuilder().setId(1).setAvailabilityDate("17/12/2023").setPrice(100).setIsReserved(false).setAgencyId(1).setRoomId(1).build());
                add(Offer.newBuilder().setId(2).setAvailabilityDate("23/12/2023").setPrice(200).setIsReserved(false).setAgencyId(1).setRoomId(2).build());
            }
        };
    }




}
