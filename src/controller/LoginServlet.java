package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminDao;
import dao.DaoFactory;
import domain.Admin;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 入力値の取得
		String loginId = request.getParameter("login_id");
		String loginPass = request.getParameter("login_pass");
		System.out.println(loginId);
		System.out.println(loginPass);

		// DBを参照し、ログインIDとパスワードが正しいか確認
        AdminDao dao = DaoFactory.createAdminDao();
        Admin admin = null;
        try {
        	admin = dao.findByLoginIdAndLoginPass(loginId, loginPass);
        }
         catch(Exception e) {
        	 e.printStackTrace();
         }
		if(admin != null) {
			// ログイン成功
			// 1．セッションにログイン済みの証を格納
			HttpSession session = request.getSession();
			session.setAttribute("admin", admin);
			// 2. MyPageへリダイレクト
			response.sendRedirect("topPage");

		}else {
			// ログイン失敗
			request.setAttribute("error", "※ IDまたはパスワードが違います");

			request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
		}

	}

}
