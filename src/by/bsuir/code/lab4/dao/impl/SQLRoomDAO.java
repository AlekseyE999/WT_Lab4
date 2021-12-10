package by.bsuir.code.lab4.dao.impl;

import by.bsuir.code.lab4.entity.Room;
import by.bsuir.code.lab4.dao.RoomsRepositoryDAO;
import by.bsuir.code.lab4.dao.impl.controller.DatabaseController;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLRoomDAO implements RoomsRepositoryDAO {

    private final DatabaseController databaseController;

    public SQLRoomDAO(DatabaseController databaseController) {
        this.databaseController = databaseController;
    }

    @Override
    public List<Room> getRooms() {
        List<Room> rooms = new ArrayList<>();
        try {
            PreparedStatement ps = databaseController.getPreparedStatement(
                    "SELECT * FROM ROOMS"
            );
            ResultSet result = ps.executeQuery();

            Room room = getNextRoom(result);
            while (room != null) {
                rooms.add(room);
                room = getNextRoom(result);
            }

        } catch (Exception ignore) {

        }
        return rooms;
    }

    @Override
    public List<Room> getVisibleRooms() {
        List<Room> rooms = new ArrayList<>();
        try {
            PreparedStatement ps = databaseController.getPreparedStatement(
                    "SELECT * FROM ROOMS WHERE hidden=false"
            );
            ResultSet result = ps.executeQuery();

            Room room = getNextRoom(result);
            while (room != null) {
                rooms.add(room);
                room = getNextRoom(result);
            }

        } catch (Exception ignore) {

        }
        return rooms;
    }

    @Override
    public Room getRoomById(int roomId) {
        Room room = null;
        try {
            PreparedStatement ps = databaseController.getPreparedStatement(
                    "SELECT * FROM ROOMS WHERE id=?"
            );
            ps.setInt(1, roomId);
            ResultSet result = ps.executeQuery();

            room = getNextRoom(result);

        } catch (Exception ignore) {

        }

        return room;
    }

    @Override
    public void update(Room room) {
        try {
            PreparedStatement ps = databaseController.getPreparedStatement(
                    "UPDATE ROOMS SET hidden=?, name=?, description=?, price=?, beds_count=? WHERE id=?"
            );

            ps.setBoolean(1, room.isHidden());
            ps.setString(2, room.getName());
            ps.setString(3, room.getDescription());
            ps.setInt(4, room.getPrice());
            ps.setInt(5, room.getBedsCount());
            ps.setInt(6, room.getId());
            ps.executeUpdate();

        } catch (Exception ignore) {

        }
    }

    private Room getNextRoom(ResultSet resultSet) throws SQLException {
        Room room = null;
        if (resultSet.next()) {
            room = new Room(
                    resultSet.getInt(1),
                    resultSet.getBoolean(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getInt(5),
                    resultSet.getInt(6)
            );
        }
        return room;
    }
}
