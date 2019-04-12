package com.ttms.web.ticket;

import com.ttms.domain.Seat;
import com.ttms.domain.Ticket;
import com.ttms.domain.play;
import com.ttms.json.JSONArray;
import com.ttms.service.Ticket_service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "LockedTicket", urlPatterns = {"/lockedticket"})
public class LockedTicketServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("tickedId");
        List<Integer> Ids = new ArrayList<>();
        JSONArray jsonArray = new JSONArray(id);
        for (int i = 0; i < jsonArray.length(); i++) {
            Ids.add(jsonArray.getInt(i));
        }
        System.out.println("Begin");
        Ticket_service ticket_service = new Ticket_service();
        List<Ticket> tickets = null;
        try {
            tickets = ticket_service.LockedTicket(Ids);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Ticket_service ticket_service1 = new Ticket_service();
        List<Seat> seats = null;
        try {
            seats = ticket_service.GetSeat(tickets);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        play play1 = null;
        if(!tickets.isEmpty()) {
            try {
                play1 = ticket_service.Getplay(tickets.get(0));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        //request.setAttribute("ticket", tickets);
        //request.setAttribute("seat", seats);
        //request.setAttribute("play", play1);
    }
}
