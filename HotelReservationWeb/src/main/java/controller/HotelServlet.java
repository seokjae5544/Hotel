package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.HotelDAO;

@WebServlet("/hotel")
public class HotelServlet extends HttpServlet {
    private final HotelDAO dao = new HotelDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "rooms";

        switch (action) {
            case "rooms":
                req.setAttribute("rooms", dao.getRooms());
                req.getRequestDispatcher("rooms.jsp").forward(req, resp);
                break;
            case "reservations":
                req.setAttribute("reservations", dao.getReservations());
                req.getRequestDispatcher("reservations.jsp").forward(req, resp);
                break;
            case "delete":
                int id = Integer.parseInt(req.getParameter("id"));
                dao.deleteReservation(id);
                resp.sendRedirect("hotel?action=reservations");
                break;
            default:
                resp.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String name = req.getParameter("name");
        int roomId = Integer.parseInt(req.getParameter("roomId"));
        String checkIn = req.getParameter("checkIn");
        String checkOut = req.getParameter("checkOut");

        if (dao.addReservation(name, roomId, checkIn, checkOut)) {
            resp.sendRedirect("hotel?action=reservations");
        } else {
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }
}
