package com.ttms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.ttms.domain.Studio;
import com.ttms.domain.Studio;
import com.ttms.utils.DBUtils;
import com.ttms.utils.DataSourceUtils;

public class Studio_Dao {

	public List<Studio> FindStudio() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select *from studio";
		List<Studio> Studios  = runner.query(sql, new BeanListHandler<Studio>(Studio.class));
		return Studios;
	}

	
	
	
	
	/**
	 * �����ݳ���
	 * @param id
	 * @return
	 * @throws SQLException 
	 */
	public void addstu(Studio s) throws SQLException{	
		Connection con=null;
		
		PreparedStatement ps=null;
		try {
			con=DBUtils.getConnection();
			ps=con.prepareStatement("INSERT INTO studio(studio_name,studio_row_count,studio_col_count,studio_introduction) VALUES(?,?,?,?)");
			ps.setString(1, s.getStudio_name());
			ps.setInt(2, s.getStudio_row_Count());
			ps.setInt(3, s.getStudio_col_Count());
			ps.setString(4, s.getStudio_introduction());
			ps.executeUpdate();
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtils.closeAll(null, ps, con);
		}	
		
	}
	/**
	 * ����idɾ���ݳ���
	 */
	public void delstu(int id){	
		Connection con=null;
		PreparedStatement ps=null;
		try {
			con=DBUtils.getConnection();
			ps=con.prepareStatement("DELETE FROM studio WHERE studio_id=?");
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtils.closeAll(null, ps, con);
		}	
	}
	/**
	 * �޸��ݳ���
	 */
	public void modstu(Studio s){	
		Connection con=null;
		PreparedStatement ps=null;
		try {
			con=DBUtils.getConnection();
			ps=con.prepareStatement("UPDATE studio SET studio_name=?,studio_row_count=?,studio_col_count=?,studio_introduction=? WHERE studio_id=?");
			ps.setString(1, s.getStudio_name());
			ps.setInt(2, s.getStudio_row_Count());
			ps.setInt(3, s.getStudio_col_Count());
			ps.setString(4, s.getStudio_introduction());
			ps.setInt(5, s.getStudio_id());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtils.closeAll(null, ps, con);
		}	
	}
	/**
	 * ��ѯ�����ݳ���
	 * @param id
	 * @return
	 */
	public List<Studio> findallstu(){
		List<Studio> stu=new ArrayList<Studio>();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			con=DBUtils.getConnection();
			ps=con.prepareStatement("select * from studio");
			rs = ps.executeQuery();
			while(rs.next()){
				Studio s=new Studio();
				s.setStudio_id(rs.getInt(1));
				s.setStudio_name(rs.getString(2));
				s.setStudio_row_Count(rs.getInt(3));
				s.setStudio_col_Count(rs.getInt(4));
				s.setStudio_introduction(rs.getString(5));
				stu.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtils.closeAll(rs, ps, con);
		}	
		return stu;
	}





	public Studio FindStudio_ID(Studio s) throws SQLException {
		Studio studio=null;
		String sql = "select * from studio where studio_name=? and "
				+ "studio_row_count=? and studio_col_count=?";
		System.out.println(s.getStudio_name());
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		studio = runner.query(sql, new BeanHandler<Studio>(Studio.class ),s.getStudio_name(),
				s.getStudio_row_Count(),s.getStudio_col_Count());
		
		
		return studio;
	}
}
