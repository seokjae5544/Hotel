package model;

import java.util.*;

public class HotelManager {
    private static final List<Room> rooms = new ArrayList<>();
    private static final List<Reservation> reservations = new ArrayList<>();
    private static int nextResId = 1;

    static {
        rooms.add(new Room(101, "Single", 60000));
        rooms.add(new Room(102, "Single", 60000));
        rooms.add(new Room(201, "Double", 90000));
        rooms.add(new Room(202, "Double", 90000));
        rooms.add(new Room(301, "Suite", 150000));
    }

    public static List<Room> getRooms() {
        return new ArrayList<>(rooms);
    }

    public static List<Reservation> getReservations() {
        return new ArrayList<>(reservations);
    }

    public static void addReservation(String name, int roomId, String checkIn, String checkOut) {
        reservations.add(new Reservation(nextResId++, name, roomId, checkIn, checkOut));
    }

    public static void deleteReservation(int id) {
        reservations.removeIf(r -> r.getId() == id);
    }

    public static Room getRoomById(int id) {
        return rooms.stream().filter(r -> r.getId() == id).findFirst().orElse(null);
    }
}
