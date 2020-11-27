package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.mindrot.jbcrypt.BCrypt;

import domain.Admin;

public class AdminDaoImpl implements AdminDao {

	private DataSource ds;

	public AdminDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	/**
	 * IDとPass両方正しい場合 ⇒ 管理者データを返す。
	 * どちらか一方でも違う場合 ⇒ nullを返す。
	 */
	@Override
	public Admin findByLoginIdAndLoginPass(String loginId, String loginPass)
			throws Exception {
		Admin admin = null;

		// DBとの照合
		// IDとPassに該当するものがあるか？
		try (Connection con = ds.getConnection()) {
			// ログインIDが合っているか？
			String sql = "SELECT*FROM admin"
					+ " WHERE login_id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, loginId);
			ResultSet rs = stmt.executeQuery();

			// 該当するIDがそもそもない
			// ⇒ rs.next()はfalseを返す
			if (rs.next()) {
				// IDは正しい
				// ⇒Passが正しいか？
				String hashedPass = rs.getString("login_pass");
				if (BCrypt.checkpw(loginPass, hashedPass)) {
					// Passも正しい
					// 管理者データをuserに入れる
					admin = new Admin();
					admin.setLoginId(loginId);
					admin.setAuthLevel((Integer)rs.getObject("auth_level"));
				}
			}

		} catch (Exception e) {
			throw e;
		}
		// IDとPassが正しければuserには管理者データが入っている
		// 正しくない場合、userはnull
		return admin;

	}

	@Override
	public List<Admin> findAll() throws Exception {
		List<Admin> admins = new ArrayList<>();

		try(Connection con = ds.getConnection()){
			String sql = "SELECT * FROM admin";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {
				admins.add(mapToAdmin(rs));
			}
          }
		   catch(Exception e) {
			   throw e;
		   }

		return admins;
	}


	@Override
	public Admin findById(Integer id) throws Exception {
		Admin admin = null;
		try(Connection con = ds.getConnection()){
		        String sql= "SELECT * FROM admin"
		        		+ " WHERE id = ?";
           PreparedStatement stmt = con.prepareStatement(sql);
	            stmt.setObject(1, id, Types.INTEGER);
		        ResultSet rs = stmt.executeQuery();
		        if(rs.next() == true) {
		        	// 該当データあり
		        	//　⇒Wineにマッピング
                     admin = mapToAdmin(rs);
		        }
           }
		catch(Exception e){
			throw e;
		}
		return admin;
	}

	@Override
	public void insert(Admin admin) throws Exception {
		try(Connection con = ds.getConnection()){
			String sql = "INSERT INTO admin"
					+ " (id, login_id, login_pass, auth_level, name, created, relationship)"
					+ " VALUES"
					+ " (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, admin.getId(), Types.INTEGER);
			stmt.setString(2, admin.getLoginId());

			// パスワードをハッシュ化してセット
			String hashed = BCrypt.hashpw(admin.getLoginPass(), BCrypt.gensalt());
			stmt.setString(3, hashed);

			stmt.setObject(4, admin.getAuthLevel(), Types.INTEGER);
			stmt.setString(5, admin.getName());

			//java.util.Dateからjava.sql.Dateに変換
			long bd = admin.getCreated().getTime();
			stmt.setDate(6, new java.sql.Date(bd));

			stmt.setString(7, admin.getRelationship());
			stmt.executeUpdate();

		}
		 catch(Exception e) {
			 throw e;
		 }

	}

	@Override
	public void delete(Integer id) throws Exception {
		try(Connection con = ds.getConnection()){
			String sql = "DELETE FROM admin"
					+ " WHERE id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, id, Types.INTEGER);
			stmt.executeUpdate();
		}
		 catch(Exception e) {
			 throw e;
		 }

	}


	/**
	 * マッピング
	 */
	  private Admin mapToAdmin(ResultSet rs)throws SQLException{

      	// 各カラムのデータを取り出す
	        Integer id = (Integer)rs.getObject("id");
	        String loginId = rs.getString("login_id");
	        String loginPass = rs.getString("login_pass");
	        Integer authLevel = (Integer)rs.getObject("auth_level");
	        String name = rs.getString("name");
	        Date created = rs.getTimestamp("created");
	        String relationship = rs.getString("relationship");

	        //取り出したデータをまとめる
	        Admin admin = new Admin();
	        admin.setId(id);
	        admin.setLoginId(loginId);
	        admin.setLoginPass(loginPass);
	        admin.setAuthLevel(authLevel);
	        admin.setName(name);
	        admin.setCreated(created);
	        admin.setRelationship(relationship);

	        return admin;

    }

}
