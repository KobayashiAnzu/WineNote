package dao;

import java.util.List;

import domain.Wine;

public interface WineDao {

	//Readするメソッド(DBから)
	//①全体を持ってくる
	List<Wine> findAll() throws Exception;
	//②１件持ってくる
	Wine findById(Integer id) throws Exception;

    //Createするメソッド
	void insert(Wine wine) throws Exception;

	//Deleteするメソッド
    void delete (Integer id)throws Exception;

    // TYPE別に情報を持ってくる
    List<Wine> findByType(String type) throws Exception;











}
