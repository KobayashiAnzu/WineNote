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
 * Servlet implementation class DetailServlet
 */
@WebServlet("/detailWine")
public class DetailWineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Getパラメータ(?id=○○)を元に、
		// 対象の情報をDBから取得
        String strId = request.getParameter("id");
        Integer id = Integer.parseInt(strId);
        Wine wine = null;
        try {
	        WineDao dao = DaoFactory.createWineDao();
	        wine = dao.findById(id);
         }
          catch(Exception e) {
              e.printStackTrace();
          }
         // idに該当するユーザーは存在しない
     		if(wine == null) {
     			response.sendRedirect("myPage");
     			return;
     		}

		// 対象の情報をスコープに格納
        request.setAttribute("wine", wine);

		// フォワード
		request.getRequestDispatcher("/WEB-INF/view/detailWine.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
