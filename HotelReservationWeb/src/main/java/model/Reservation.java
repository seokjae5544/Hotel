package model;

public class Reservation {
    private int id;
    private String name;
    private int roomId;
    private String checkIn;
    private String checkOut;

    public Reservation(int id, String name, int roomId, String checkIn, String checkOut) {
        this.id = id;
        this.name = name;
        this.roomId = roomId;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getRoomId() { return roomId; }
    public String getCheckIn() { return checkIn; }
    public String getCheckOut() { return checkOut; }
}
