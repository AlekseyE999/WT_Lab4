package by.bsuir.code.lab4.entity;

import java.io.Serializable;
import java.sql.Date;

public class Reservation implements Serializable {

    private int id;
    private int userId;
    private int roomId;
    private Date start;
    private Date end;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Reservation() {
    }

    public Reservation(int userId, int roomId, Date start, Date end) {
        this.userId = userId;
        this.roomId = roomId;
        this.start = start;
        this.end = end;
    }

    public Reservation(int id, int userId, int roomId, Date start, Date end) {
        this.id = id;
        this.userId = userId;
        this.roomId = roomId;
        this.start = start;
        this.end = end;
    }
}
