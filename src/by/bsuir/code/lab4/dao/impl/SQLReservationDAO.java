package by.bsuir.code.lab4.dao.impl;

import by.bsuir.code.lab4.entity.Reservation;
import by.bsuir.code.lab4.dao.ReservationRepositoryDAO;
import by.bsuir.code.lab4.dao.impl.controller.DatabaseController;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLReservationDAO implements ReservationRepositoryDAO {

    private final DatabaseController databaseController;

    public SQLReservationDAO(DatabaseController databaseController) {
        this.databaseController = databaseController;
    }

    @Override
    public void add(Reservation reservation) {
        try {
            PreparedStatement ps = databaseController.getPreparedStatement(
                    "INSERT INTO RESERVATIONS (user_id, room_id, start, end) VALUES (?, ?, ?, ?)"
            );
            ps.setInt(1, reservation.getUserId());
            ps.setInt(2, reservation.getRoomId());
            ps.setDate(3, reservation.getStart());
            ps.setDate(4, reservation.getEnd());
            ps.executeUpdate();

        } catch (Exception ignore) {

        }
    }

    @Override
    public List<Reservation> getReservationsByUserId(int userId) {
        List<Reservation> reservations = new ArrayList<>();
        try {
            PreparedStatement ps = databaseController.getPreparedStatement(
                    "SELECT * FROM RESERVATIONS WHERE user_id=?"
            );
            ps.setInt(1, userId);
            ResultSet result = ps.executeQuery();

            Reservation reservation = getNextReservation(result);
            while (reservation != null) {
                reservations.add(reservation);
                reservation = getNextReservation(result);
            }

        } catch (Exception ignore) {

        }

        return reservations;
    }

    private Reservation getNextReservation(ResultSet resultSet) throws SQLException {
        Reservation reservation = null;
        if (resultSet.next()) {
            reservation = new Reservation(
                    resultSet.getInt(1),
                    resultSet.getInt(2),
                    resultSet.getInt(3),
                    resultSet.getDate(4),
                    resultSet.getDate(5)
            );
        }
        return reservation;
    }
}
