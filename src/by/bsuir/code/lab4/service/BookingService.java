package by.bsuir.code.lab4.service;

import by.bsuir.code.lab4.dao.ReservationRepositoryDAO;
import by.bsuir.code.lab4.entity.BookingErrors;
import by.bsuir.code.lab4.entity.Reservation;
import by.bsuir.code.lab4.entity.User;
import by.bsuir.code.lab4.servlets.UserSession;

import java.sql.Date;
import java.util.List;

public class BookingService {

    private final RoomsService roomsService;
    private final ReservationRepositoryDAO reservationRepository;

    public BookingService(RoomsService roomsService, ReservationRepositoryDAO reservationRepository) {
        this.roomsService = roomsService;
        this.reservationRepository = reservationRepository;
    }

    public BookingErrors canBook(UserSession session, int roomId) {
        String role = session.getUserRole();

        if (role.equals(User.UserRole.guest)) {
            return BookingErrors.NOT_AUTHORIZED;
        }
        if (!role.equals(User.UserRole.user)) {
            return BookingErrors.INCORRECT_PARAMETERS;
        }
        if (roomsService.getRoomById(roomId) == null) {
            return BookingErrors.INCORRECT_PARAMETERS;
        }
        return BookingErrors.OK;
    }

    public BookingErrors tryBook(UserSession session, int roomId, Date start, Date end) {
        BookingErrors error = canBook(session, roomId);
        if (error != BookingErrors.OK) {
            return error;
        }

        if (start.after(end) || start.before(new Date(System.currentTimeMillis()))) {
            return BookingErrors.INCORRECT_DATE_PARAMETERS;
        }
        reservationRepository.add(new Reservation(session.getUserId(), roomId, start, end));
        return error;
    }

    public List<Reservation> getReservationsOf(int userId) {
        return reservationRepository.getReservationsByUserId(userId);
    }
}
