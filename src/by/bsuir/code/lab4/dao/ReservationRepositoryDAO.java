package by.bsuir.code.lab4.dao;

import by.bsuir.code.lab4.entity.Reservation;

import java.util.List;

public interface ReservationRepositoryDAO {
    void add(Reservation reservation);
    List<Reservation> getReservationsByUserId(int userId);
}
