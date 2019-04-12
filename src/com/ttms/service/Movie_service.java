package com.ttms.service;

import java.sql.SQLException;
import java.util.List;

import org.dom4j.DocumentException;

import com.ttms.dao.Movie_Dao;
import com.ttms.domain.Customer;
import com.ttms.domain.Data_dict;
import com.ttms.domain.PageBean;
import com.ttms.domain.Sale_item;
import com.ttms.domain.Ticket;
import com.ttms.domain.play;
import com.ttms.idao.BeanFactory;
import com.ttms.idao.Movie_idao;

public class Movie_service {
//鏌ヨ鎵�鏈夌數褰�
	public List<play> findall() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, DocumentException {

		Movie_idao movie_dao = (Movie_idao) BeanFactory.getdao("movie_Dao");
		List<play> movieall = movie_dao.findall();

		return movieall;
	}
	
	public PageBean findall(Integer page) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, DocumentException {

		Movie_idao movie_dao = (Movie_idao) BeanFactory.getdao("movie_Dao");
		PageBean movieall = movie_dao.findall(page);

		return movieall;
	}
//鍒犻櫎鐢靛奖灏嗙姸鎬佷粠1鏀逛负-1
	public void Delete_Movie(String play_id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, DocumentException {

		Movie_idao del= (Movie_idao) BeanFactory.getdao("movie_Dao");
		del.Delete_Movie(play_id);

	}
//鏌ヨ鐢靛奖璇█
	public List<Data_dict> Movielang() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, DocumentException {
		Movie_idao movie = (Movie_idao) BeanFactory.getdao("movie_Dao");

		List<Data_dict> lan = movie.Movielang();
		return lan;
	}
//鏌ヨ鐢靛奖绫诲瀷
	public List<Data_dict> Movietype() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, DocumentException {
		Movie_idao movie = (Movie_idao) BeanFactory.getdao("movie_Dao");
		List<Data_dict> type = movie.Movietype();

		return type;
	}
//娣诲姞鐢靛奖
	public void addmovie(play p) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, DocumentException {
		Movie_idao mDao = (Movie_idao) BeanFactory.getdao("movie_Dao");
		mDao.addmovie(p);

	}

//鍔犲叆鐢靛奖绫诲瀷
	public void Addtype(String dict_type) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, DocumentException {
		Movie_idao movie_type = (Movie_idao) BeanFactory.getdao("movie_Dao");
		movie_type.Add_type(dict_type);	
	}
///鍔犲叆鐢靛奖璇█
	public void Addlang(String dict_lang) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, DocumentException {
		Movie_idao movie_lang = (Movie_idao) BeanFactory.getdao("movie_Dao");
		movie_lang.Add_lang(dict_lang);	
	}
//鍥炴樉鐢靛奖娑堟伅
	public play Movie_updata(String play_id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, DocumentException {
		Movie_idao movie_type = (Movie_idao) BeanFactory.getdao("movie_Dao");
		play movie = movie_type.Movieupadata(play_id);	
		return movie;
	}
//鏇存柊鐢靛奖娑堟伅
	public void Movie_data(play p) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, DocumentException {
		
		
		Movie_idao updata = (Movie_idao) BeanFactory.getdao("movie_Dao");
		updata.Upadatamovie(p);
		
	}
	public play FindOne(String play_id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, DocumentException {
		Movie_idao mDao = (Movie_idao) BeanFactory.getdao("movie_Dao");
		play movie = mDao.FindOne(play_id);
		return movie;
	}
	public void SaleMovie(Customer user, List<Ticket> tickets, String date) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, DocumentException {
		Movie_idao sale = (Movie_idao) BeanFactory.getdao("movie_Dao");
		sale.SaleMovie(user,tickets,date);
		
	}
	public List<Sale_item> Findsaleall() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, DocumentException {
		Movie_idao sale = (Movie_idao) BeanFactory.getdao("movie_Dao");
		List<Sale_item> saleall = sale.Findsaleall();
		return saleall;
	}
	
}
