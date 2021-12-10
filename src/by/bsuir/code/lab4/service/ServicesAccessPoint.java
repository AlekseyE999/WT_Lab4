package by.bsuir.code.lab4.service;

import by.bsuir.code.lab4.service.security.SaltShaker;
import by.bsuir.code.lab4.dao.impl.SQLReservationDAO;
import by.bsuir.code.lab4.dao.impl.SQLRoomDAO;
import by.bsuir.code.lab4.dao.impl.SQLUserDAO;
import by.bsuir.code.lab4.dao.impl.controller.DatabaseController;

public class ServicesAccessPoint {

    private static final DatabaseController databaseController = new DatabaseController(
            "jdbc:mysql://localhost/hotel?serverTimezone=Europe/Moscow&useSSL=false",
            "root",
            "admin"
    );

    private static final AuthorizationService authorizationService = new AuthorizationService(
            new SQLUserDAO(databaseController),
            new SaltShaker(60000)
    );

    private static final RoomsService roomsService = new RoomsService(
            new SQLRoomDAO(databaseController)
    );

    private static final BookingService bookingService = new BookingService(
            roomsService,
            new SQLReservationDAO(databaseController)
    );

    public AuthorizationService getAuthorizationService() {
        return authorizationService;
    }

    public RoomsService getRoomsService() {
        return roomsService;
    }

    public BookingService getBookingService() {
        return bookingService;
    }
}
