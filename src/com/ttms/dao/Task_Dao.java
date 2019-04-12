package com.ttms.dao;

import com.ttms.domain.Ticket;
import com.ttms.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;
import java.util.List;
import java.util.TimerTask;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Task_Dao extends TimerTask {
    private List<Ticket> tickets;
    private  HttpServletRequest request;
    Task_Dao(List<Ticket> tickets,  HttpServletRequest request){
        this.tickets = tickets;
       
    this.request=request;
    }
    
    
    @Override
    public void run() {
    	
    	
    	
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select ticket_status from ticket where ticket_id = ?;";
        String sql2 = "update ticket set ticket_status=? where ticket_id=?";
        for(Ticket ticket : tickets){
            Ticket ticket1 = null;
            try {
                ticket1 = runner.query(sql, new BeanHandler<Ticket>(Ticket.class), ticket.getTicket_id());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if(ticket1.getTicket_status() == 1){
                try {
                   runner.update(sql2, 0, ticket.getTicket_id());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            
        }
        
//        
//    HttpSession session = request.getSession();
//    session.removeAttribute("ticketNumber");
//    int num=4;//用户最多能够购买四张票
//    	session.setAttribute("ticketNumber", num);
    }
    

    
}
