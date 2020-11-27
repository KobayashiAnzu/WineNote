package dao;

import java.util.List;

import domain.Admin;

public interface AdminDao {

	// IDとPassを元に1人分のデータを返すメソッド
	Admin findByLoginIdAndLoginPass(String loginId, String loginPass) throws Exception;

	/**
	 * IDとPass両方正しい場合 ⇒ 管理者データを返す。
	 * どちらか一方でも違う場合 ⇒ nullを返す。
	 */

	//Readするメソッド(DBから)
		//①全体を持ってくる
		List<Admin> findAll() throws Exception;
		//②１件持ってくる
		Admin findById(Integer id) throws Exception;

	    //Createするメソッド
		void insert(Admin admin) throws Exception;

		//Deleteするメソッド
	    void delete (Integer id)throws Exception;


}
