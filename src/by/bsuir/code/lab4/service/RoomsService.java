package by.bsuir.code.lab4.service;

import by.bsuir.code.lab4.entity.Room;
import by.bsuir.code.lab4.dao.RoomsRepositoryDAO;

import java.util.List;

public class RoomsService {

    private final RoomsRepositoryDAO roomsRepository;

    public RoomsService(RoomsRepositoryDAO roomsRepository) {
        this.roomsRepository = roomsRepository;
    }

    public List<Room> getAllRooms() {
        return roomsRepository.getRooms();
    }

    public List<Room> getVisibleRooms() {
        return roomsRepository.getVisibleRooms();
    }

    public Room getRoomById(int roomId) {
        return roomsRepository.getRoomById(roomId);
    }

    public void changeRoomVisibility(int roomId) {
        Room room = roomsRepository.getRoomById(roomId);
        if (room != null) {
            room.setHidden(!room.isHidden());
            roomsRepository.update(room);
        }
    }
}
