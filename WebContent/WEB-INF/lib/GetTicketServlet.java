package com.ttms.web.ticket;

import com.google.gson.Gson;
import com.ttms.domain.Ticket;
import com.ttms.json.JSONArray;
import com.ttms.service.Ticket_service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "GetTicket", urlPatterns = {"/getTicket"})
public class GetTicketServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String sched_id = request.getParameter("Sched_id");
        Ticket_service ticket_service = new Ticket_service();
        JSONArray jsonArray = new JSONArray();
        List<Ticket> tickets = null;
        try {
            tickets = ticket_service.Get_Ticket(Integer.parseInt(sched_id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Ticket ticket : tickets) {
            Gson gson = new Gson();
            String string = gson.toJson(ticket);
            jsonArray.put(string);
        }
        response.getWriter().write(jsonArray.toString());
    }
}
