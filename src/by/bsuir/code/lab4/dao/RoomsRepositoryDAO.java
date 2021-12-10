package by.bsuir.code.lab4.dao;

import by.bsuir.code.lab4.entity.Room;

import java.util.List;

public interface RoomsRepositoryDAO {
    List<Room> getRooms();
    List<Room> getVisibleRooms();
    Room getRoomById(int roomId);
    void update(Room room);
}
