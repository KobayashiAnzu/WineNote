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

import domain.Wine;

public class WineDaoImpl implements WineDao {

	private DataSource ds;

	//引数ありのコンストラクタを作成
	//→FactoryからDataSourceを受け取るため

	public WineDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	//全データ取得（ワイン情報）
	@Override
	public List<Wine> findAll() throws Exception {
		List<Wine> wines = new ArrayList<>();
		try (Connection con = ds.getConnection()) {
			String sql = "SELECT * FROM wine"
					+ " ORDER BY date DESC";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {

				wines.add(mapToWine(rs));

			}
		} catch (Exception e) {
			throw e;
		}

		return wines;

	}

	// タイプ別データ取得
	@Override
	public List<Wine> findByType(String type) throws Exception {
		List<Wine> wines = new ArrayList<>();
		try (Connection con = ds.getConnection()) {
			String sql = "SELECT * FROM wine"
					+ " WHERE type = ?"
					+ " ORDER BY id DESC";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, type);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				wines.add(mapToWine(rs));

			}
		} catch (Exception e) {
			throw e;
		}

		return wines;

	}


	// idを元に1つ分の情報を取得
	@Override
	public Wine findById(Integer id) throws Exception {
		Wine wine = null;
		try (Connection con = ds.getConnection()) {
			String sql = "SELECT * FROM wine"
					+ " WHERE id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, id, Types.INTEGER);
			ResultSet rs = stmt.executeQuery();
			if (rs.next() == true) {
				// 該当データあり
				//　⇒Wineにマッピング
				wine = mapToWine(rs);
			}
		} catch (Exception e) {
			throw e;
		}
		return wine;
	}

	@Override
	public void insert(Wine wine) throws Exception {
		try (Connection con = ds.getConnection()) {
			String sql = "INSERT INTO wine"
					+ " (name, image, evaluation, type, country, price, date, comment, contributor, shop, alcohol)"
					+ " VALUES"
					+ " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, wine.getName());
			stmt.setString(2, wine.getImage());
			stmt.setObject(3, wine.getEvaluation(), Types.INTEGER);
			stmt.setString(4, wine.getType());
			stmt.setString(5, wine.getCountry());
			stmt.setObject(6, wine.getPrice(), Types.INTEGER);

			//java.util.Dateからjava.sql.Dateに変換
			long bd = wine.getDate().getTime();
			stmt.setDate(7, new java.sql.Date(bd));

			stmt.setString(8, wine.getComment());
			stmt.setString(9, wine.getContributor());
			stmt.setString(10, wine.getShop());
			stmt.setObject(11, wine.getAlcohol(), Types.INTEGER);

			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;

		}

	}

	@Override
	public void delete(Integer id) throws Exception {
		try (Connection con = ds.getConnection()) {
			String sql1 = "DELETE FROM wine"
					+ " WHERE id = ?";
			String sql2 = "UPDATE wine SET"
					+ " status = ?"
					+ " WHERE id = ?";
			PreparedStatement stmt = con.prepareStatement(sql1);
			stmt.setObject(1, id, Types.INTEGER);
			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}

	}

	/**
	 * wineテーブルから取得したデータ
	 * ResultSetをWineオブジェクトに変換
	 * @throws SQLException
	 */

	private Wine mapToWine(ResultSet rs) throws SQLException {

		//各カラムのデータを取り出す
		Integer id = (Integer) rs.getObject("id");
		String name = rs.getString("name");
		String image = rs.getString("image");
		Integer evaluation = (Integer) rs.getObject("evaluation");
		String type = rs.getString("type");
		String country = rs.getString("country");
		Integer price = (Integer) rs.getObject("price");
		Date date = rs.getTimestamp("date");
		String comment = rs.getString("comment");
		String contributor = rs.getString("contributor");
		String shop = rs.getString("shop");
		Integer alcohol = (Integer) rs.getObject("alcohol");

		//取り出したデータをまとめる
		Wine wine = new Wine();
		wine.setId(id);
		wine.setName(name);
		wine.setImage(image);
		wine.setEvaluation(evaluation);
		wine.setType(type);
		wine.setCountry(country);
		wine.setPrice(price);
		wine.setDate(date);
		wine.setComment(comment);
		wine.setContributor(contributor);
		wine.setShop(shop);
		wine.setAlcohol(alcohol);

		return wine;
	}



}
