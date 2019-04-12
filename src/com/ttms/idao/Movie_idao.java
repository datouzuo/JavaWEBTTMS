package com.ttms.idao;

import java.sql.SQLException;
import java.util.List;

import com.ttms.domain.Customer;
import com.ttms.domain.Data_dict;
import com.ttms.domain.PageBean;
import com.ttms.domain.Sale_item;
import com.ttms.domain.Ticket;
import com.ttms.domain.play;

public interface Movie_idao {

		public void Delete_Movie(String play_id) throws SQLException;
		
	//鏌ユ壘鎵�鏈夌數褰�
		public List<play> findall() throws SQLException;
		public PageBean findall(Integer page) throws SQLException;
		

		
	//鑾峰緱鎵�鏈夌數褰辩被鍨�
		public List<Data_dict> Movietype() throws SQLException;
		
	//鑾峰緱鐢靛奖璇█
		public List<Data_dict> Movielang() throws SQLException;
			
	//娣诲姞鐢靛奖
		public void addmovie(play p) throws SQLException;
			

	//娣诲姞鐢靛奖绫诲瀷
		public void Add_type(String dict_type) throws SQLException;
			
	//娣诲姞鐢靛奖绫诲瀷
		public void Add_lang(String dict_lang) throws SQLException;
			
	//鍥炴樉鐢靛奖淇℃伅
		public play Movieupadata(String play_id) throws SQLException;
		
	//鏇存柊鐢靛奖淇℃伅
		public void Upadatamovie(play p) throws SQLException ;
			
	//鏌ユ壘涓�涓數褰�
		public play FindOne(String play_id) throws SQLException;
			
		public void SaleMovie(Customer user, List<Ticket> tickets, String date) throws SQLException;
			
		
		public List<Sale_item> Findsaleall() throws SQLException;
			
}
