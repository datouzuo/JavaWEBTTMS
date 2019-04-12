package com.ttms.dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.ttms.domain.Customer;
import com.ttms.domain.Data_dict;
import com.ttms.domain.Employee;
import com.ttms.domain.PageBean;
import com.ttms.domain.Sale_item;
import com.ttms.domain.Schedule;
import com.ttms.domain.Ticket;
import com.ttms.domain.play;
import com.ttms.idao.Movie_idao;
import com.ttms.utils.DataSourceUtils;

public class Movie_Dao implements Movie_idao{
//鍒犻櫎鐢靛奖
	public void Delete_Movie(String play_id) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update play set play_status='-1' where play_id=?";
		runner.update(sql, play_id);
	}
//鏌ユ壘鎵�鏈夌數褰�
	public List<play> findall() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from data_dict a, play b where a.dict_id=b.play_type_id and play_status='1'";
		List<play> movieall = runner.query(sql, new BeanListHandler<play>(play.class));
		for (play movie : movieall) {
			String sql1 = "select * from data_dict where dict_id=" + movie.getPlay_lang_id();
			Data_dict data_dict = runner.query(sql1, new BeanHandler<Data_dict>(Data_dict.class));
			movie.setDict_value1(data_dict.getDict_value());
		}

		return movieall;
	}
	
	
	
	public PageBean findall(Integer page) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		int row = 10;
		int start = (page-1)*10;
		String sql = "select * from data_dict a, play b where a.dict_id=b.play_type_id "
				+ "and play_status='1' limit ?,?";
	    String sql2 = "select count(*) from play";	
	    Object[]  paras = {};
	    Object[]  paras1 = {start,row};
	    Long total =  (Long) runner.query(sql2, new ScalarHandler(), paras);
		List<play> movieall = runner.query(sql, new BeanListHandler<play>(play.class), paras1);
		for (play movie : movieall) {
			String sql1 = "select * from data_dict where dict_id=" + movie.getPlay_lang_id();
			Data_dict data_dict = runner.query(sql1, new BeanHandler<Data_dict>(Data_dict.class));
			movie.setDict_value1(data_dict.getDict_value());
		}
      PageBean pageBean = new PageBean();
      pageBean.setMovieall(movieall);
      int ta =Integer.parseInt(total+"");
      pageBean.setToatal(ta);
      ta =ta+9;
     pageBean.setPage(ta/10);
     pageBean.setCurrentPage(page);
		return pageBean;
	}
	
//鑾峰緱鎵�鏈夌數褰辩被鍨�
	public List<Data_dict> Movietype() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from data_dict where dict_parent_id=?";

		List<Data_dict> typ = runner.query(sql, new BeanListHandler<Data_dict>(Data_dict.class), 2);
		return typ;
	}
//鑾峰緱鐢靛奖璇█
	public List<Data_dict> Movielang() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from data_dict where dict_parent_id=?";

		List<Data_dict> lan = runner.query(sql, new BeanListHandler<Data_dict>(Data_dict.class), 3);
		return lan;
	}
//娣诲姞鐢靛奖
	public void addmovie(play p) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into play (play_type_id,play_lang_id,"
				+ "play_name,play_introduction,play_image,play_length,play_ticket_price,play_status)"
				+ "values(?,?,?,?,?,?,?,?)";
		runner.update(sql, p.getPlay_type_id(), p.getPlay_lang_id(), p.getPlay_name(), p.getplay_introduction(),
				p.getPlay_image(), p.getPlay_length(),p.getPlay_ticket_price(), p.getPlay_status());
		
	}

//娣诲姞鐢靛奖绫诲瀷
	public void Add_type(String dict_type) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into data_dict(dict_parent_id,dict_value) values(?,?)";
		runner.update(sql, 2,dict_type);
		
	}
//娣诲姞鐢靛奖绫诲瀷
	public void Add_lang(String dict_lang) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into data_dict(dict_parent_id,dict_value) values(?,?)";
		runner.update(sql, 3,dict_lang);
		
		
	}
//鍥炴樉鐢靛奖淇℃伅
	public play Movieupadata(String play_id) throws SQLException {
	QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
	String sql = "select * from play where play_id=?";
		play movie = runner.query(sql, new BeanHandler<play>(play.class), play_id);
		return movie;
	}
//鏇存柊鐢靛奖淇℃伅
	public void Upadatamovie(play p) throws SQLException {
		
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update play set play_type_id=?,play_lang_id=?,play_name=?,play_introduction=?,play_length=? where play_id=?";
				
		runner.update(sql,p.getPlay_type_id(), p.getPlay_lang_id(),p.getPlay_name(),
				p.getplay_introduction(),p.getPlay_length(),p.getPlay_id());
	}
//鏌ユ壘涓�涓數褰�
	public play FindOne(String play_id) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from data_dict a, play b where a.dict_id=b.play_type_id and play_id=?";
		play pp = runner.query(sql, new BeanHandler<play>(play.class),play_id);
		String sql1 ="select * from data_dict where dict_id=?" ;
		Data_dict data_dict = runner.query(sql1, new BeanHandler<Data_dict>(Data_dict.class),pp.getPlay_lang_id());
		pp.setDict_value1(data_dict.getDict_value());
		return pp;
	}
	public void SaleMovie(Customer user, List<Ticket> tickets, String date) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into sale_item(ticket_id,emp_id,sale_time) values(?,?,?)";
		for(Ticket t : tickets) {
			runner.update(sql, t.getTicket_id(),user.getEmp_id(),date);
		}
		
	}
	public List<Sale_item> Findsaleall() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from sale_item";
		List<Sale_item> saleall = runner.query(sql, new BeanListHandler<Sale_item>(Sale_item.class));
		for(Sale_item sale : saleall) {
			System.out.println(sale.getSale_time()+"wide ");
		String sql1 = "select * from employee where emp_id=?";
		Customer customer = runner.query(sql1, new BeanHandler<Customer>(Customer.class), sale.getEmp_id());
		sale.setUsename(customer.getUsename());
		
		String sql2 = "select * from ticket where ticket_id=?";
		Ticket ticket = runner.query(sql2, new BeanHandler<Ticket>(Ticket.class), sale.getTicket_id());
		 
		
		String sql3 = "select * from schedule where sched_id=?";
		Schedule schedule = runner.query(sql3, new BeanHandler<Schedule>(Schedule.class), ticket.getSched_id());
		System.out.println(schedule.getSched_time()+"tiande");
		
		String sql4 = "select * from play where play_id=?";
		play pp = runner.query(sql4, new BeanHandler<play>(play.class), schedule.getPlay_id());
		System.out.println(pp.getPlay_name()+"sheide ");
		sale.setPlay_name(pp.getPlay_name());
		}
		return saleall;
	}

}
