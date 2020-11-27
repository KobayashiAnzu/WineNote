package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.WineDao;
import domain.Wine;

/**
 * Servlet implementation class DeleteWineServlet
 */
@WebServlet("/deleteWine")
public class DeleteWineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Getパラメータ(?id=○○)を元に、
		// 対象の情報をDBから取得
		String strId = request.getParameter("id");
		Integer id = Integer.parseInt(strId);
		Wine wine = null;
		try {
			WineDao dao = DaoFactory.createWineDao();
			wine = dao.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}


		// idに該当するユーザーは存在しない
		if(wine == null) {
			response.sendRedirect("topPage");
			return;
		}

		// 対象の情報をスコープに格納
		request.setAttribute("wine", wine);

		// フォワード
		request.getRequestDispatcher("/WEB-INF/view/deleteWine.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// キャンセルボタン押下
		if(request.getParameter("cancel") != null) {
			response.sendRedirect("topPage");
			return;
		}

		// ?id=○○を取得
		String strId = request.getParameter("id");
		Integer id = Integer.parseInt(strId);

		// idを元に削除処理
		try {
			WineDao dao = DaoFactory.createWineDao();
			dao.delete(id);
			request.getRequestDispatcher("/WEB-INF/view/done.jsp").forward(request, response);
		}
		 catch(Exception e) {
			 e.printStackTrace();
		 }

	}

}
