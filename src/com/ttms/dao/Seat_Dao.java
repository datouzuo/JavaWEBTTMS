package com.ttms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.ttms.domain.Schedule;
import com.ttms.domain.Seat;
import com.ttms.domain.Studio;
import com.ttms.domain.Ticket;
import com.ttms.domain.play;

import com.ttms.domain.Studio;
import com.ttms.utils.DBUtils;
import com.ttms.utils.DataSourceUtils;

public class Seat_Dao {


	/**
	 * ����id��ѯ�ݳ���
	 * @param id
	 * @return
	 */
	public Studio findstu(int id){
		Studio s=new Studio();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			con=(Connection) DBUtils.getConnection();
			ps=(PreparedStatement) con.prepareStatement("select * from Studio where Studio_id=?");
			ps.setInt(1,id);
			rs = ps.executeQuery();
			if(rs.next()){
				s.setStudio_id(rs.getInt(1));
				s.setStudio_name(rs.getString(2));
				s.setStudio_row_Count(rs.getInt(3));
				s.setStudio_col_Count(rs.getInt(4));
				s.setStudio_introduction(rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtils.closeAll(rs, ps, con);
		}	
		return s;
	}		

	/**
	 * �����λ
	 * @param stu
	 */
	public void addseat(Studio stu) {		
		Connection con=null;
		PreparedStatement ps=null;
		try {
			con=(Connection) DBUtils.getConnection();
			for(int i=1;i<=stu.getStudio_row_Count();i++){
				for(int j=1;j<=stu.getStudio_col_Count();j++){
					ps=(PreparedStatement) con.prepareStatement("INSERT INTO seat(Studio_id,seat_row,seat_column) VALUES(?,?,?)");
					ps.setInt(1, stu.getStudio_id());
					ps.setInt(2, i);
					ps.setInt(3, j);
					ps.executeUpdate();
				}			
			}		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtils.closeAll(null, ps, con);
		}	
	}
	/**
	 * ��ѯ�ݳ��ƻ�
	 * @param id
	 * @return
	 */
	public Schedule findSchedule(int id){
		Schedule s=new Schedule();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			con=(Connection) DBUtils.getConnection();
			ps=(PreparedStatement) con.prepareStatement("SELECT * FROM SCHEDULE WHERE sched_id=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()){
				s.setSched_id(rs.getInt(1));
				s.setStudio_id(rs.getInt(2));
				s.setPlay_id(rs.getInt(3));
				s.setSched_time(rs.getString(4));
				s.setSched_ticket_price(rs.getInt(5) );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtils.closeAll(rs, ps, con);
		}	
		return s;
	}	
	
	/**
	 * ��ѯ�ѳ���Ʊ
	 * @param id
	 * @return
	 */
	public ArrayList<Seat> findSeat(int id){
		ArrayList<Seat> seat_sale=new ArrayList<Seat>();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			con=(Connection) DBUtils.getConnection();
			ps=(PreparedStatement) con.prepareStatement("SELECT * FROM seat WHERE seat_id IN (SELECT seat_id FROM ticket WHERE  (ticket_status='9' or ticket_status='1') AND sched_id=?)");
			ps.setInt(1, id);
			rs = ps.executeQuery();		
			while(rs.next()){
				Seat seat=new Seat();
				seat.setSeat_id(rs.getInt(1));
				seat.setStudio_id(rs.getInt(2));
				seat.setSeat_row(rs.getInt(3));
				seat.setSeat_column(rs.getInt(4));
				seat_sale.add(seat);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtils.closeAll(rs, ps, con);
		}	
		return seat_sale;
	}		
	/**
	 * ��ѯƱid���� ��λ �� �� �ݳ��ƻ�
	 * @param id
	 * @return
	 * @throws SQLException 
	 */
	public int findticketID(int row,int col,int scheID) throws SQLException{
	
	
	QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
	String sql = "SELECT * FROM ticket WHERE sched_id=? AND seat_id=any(SELECT seat_id FROM seat WHERE seat_row=? AND seat_column=?)";
	Ticket ticket = runner.query(sql, new BeanHandler<Ticket>(Ticket.class), scheID,row,col);
	
	return ticket.getTicket_id();
	
	
//		Connection con=null;
//		PreparedStatement ps=null;
//		ResultSet rs=null;
//		try {
//			con=(Connection) DBUtils.getConnection();
//			ps=(PreparedStatement) con.prepareStatement("SELECT ticket_id FROM ticket WHERE sched_id=? AND seat_id=(SELECT seat_id FROM seat WHERE seat_row=? AND seat_column=?)");
//			ps.setInt(1, scheID);
//			ps.setInt(2, row);
//			ps.setInt(3, col);
//			rs = ps.executeQuery();		
//			if(rs.next()){
//				ID = rs.getInt(1);
//			}
//			System.out.println(ID+"id");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{
//			DBUtils.closeAll(rs, ps, con);
//		}	
		
	}	
	/**
	 * ��ѯ��Ӱ
	 * @param id
	 * @return
	 */
	public play findplay(int id){
		play s=new play();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			con=(Connection) DBUtils.getConnection();
			ps=(PreparedStatement) con.prepareStatement("SELECT * FROM play WHERE play_id=(SELECT play_id FROM SCHEDULE WHERE sched_id=?)");
			ps.setInt(1,id);
			rs = ps.executeQuery();
			if(rs.next()){
				s.setPlay_id(rs.getInt(1));
				s.setPlay_type_id(rs.getInt(2));
				s.setPlay_lang_id(rs.getInt(3));
				s.setPlay_name(rs.getString(4));
				s.setplay_introduction(rs.getString(5));
				s.setplay_image(rs.getString(6));
				s.setPlay_length(rs.getInt(7));
				s.setPlay_ticket_price(rs.getInt(8));
				s.setPlay_status(rs.getInt(9));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtils.closeAll(rs, ps, con);
		}	
		return s;
	}		
	
	
	
	
	public void CreatSeat(Studio stu) {
		Connection con=null;
		PreparedStatement ps=null;
		try {
			con=(Connection) DBUtils.getConnection();
			for(int i=1;i<=stu.getStudio_row_Count();i++){
				for(int j=1;j<=stu.getStudio_col_Count();j++){
					ps=(PreparedStatement) con.prepareStatement("INSERT INTO seat(Studio_id,seat_row,seat_column) VALUES(?,?,?)");
					ps.setInt(1, stu.getStudio_id());
					ps.setInt(2, i);
					ps.setInt(3, j);
					ps.executeUpdate();
				}			
			}		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtils.closeAll(null, ps, con);
		}	

		
	}

	public void DeleteSeat(int id) throws SQLException {
	QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
	String sql = "delete from seat where Studio_id=?";
	runner.update(sql,id);
		
	}

	
}
