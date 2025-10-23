package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HotelDAO {

    public List<Room> getRooms() {
        List<Room> list = new ArrayList<>();
        String sql = "SELECT * FROM rooms";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Room(rs.getInt("id"), rs.getString("type"), rs.getInt("price")));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    public List<Reservation> getReservations() {
        List<Reservation> list = new ArrayList<>();
        String sql = "SELECT * FROM reservations";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Reservation(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("room_id"),
                        rs.getString("check_in"),
                        rs.getString("check_out")));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    public boolean addReservation(String name, int roomId, String checkIn, String checkOut) {
        String sql = "INSERT INTO reservations (name, room_id, check_in, check_out) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setInt(2, roomId);
            ps.setString(3, checkIn);
            ps.setString(4, checkOut);
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); return false; }
    }

    public boolean deleteReservation(int id) {
        String sql = "DELETE FROM reservations WHERE id=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); return false; }
    }

    public Room getRoomById(int id) {
        String sql = "SELECT * FROM rooms WHERE id=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
                return new Room(rs.getInt("id"), rs.getString("type"), rs.getInt("price"));
        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }
}
