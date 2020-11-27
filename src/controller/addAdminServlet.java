package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDao;
import dao.DaoFactory;
import domain.Admin;

/**
 * Servlet implementation class addAdminServlet
 */
@WebServlet("/addAdmin")
public class addAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/addAdmin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//キャンセルボタンが押されたとき
		if(request.getParameter("cancel") != null) {
			response.sendRedirect("adminList");
			return;
		}
			//追加ボタンが押されたとき
			String strId = request.getParameter("id");
			String name = request.getParameter("name");
			String relationship = request.getParameter("relationship");
			String loginId = request.getParameter("login_id");
			String loginPass = request.getParameter("login_pass");
			String strAuthLevel = request.getParameter("auth_level");
			String strCreated = request.getParameter("created");


		    //型変換
			Integer id = Integer.parseInt(strId);
	        Integer authLevel = Integer.parseInt(strAuthLevel);
	        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
	        Date created = new Date();
	        try {
	        	  created = fmt.parse(strCreated);
		   }
	        catch(ParseException e) {
	        	e.printStackTrace();
	        }



	        //Adminオブジェクトにまとめる
	        Admin admin = new Admin();
	        admin.setId(id);
	        admin.setName(name);
	        admin.setRelationship(relationship);
	        admin.setLoginId(loginId);
	        admin.setLoginPass(loginPass);
	        admin.setAuthLevel(authLevel);
	        admin.setCreated(created);


	        //DaoにDBに追加してもらう
	        AdminDao dao = DaoFactory.createAdminDao();
	        try {
	        	dao.insert(admin);
	        }
	         catch(Exception e) {
	        	 e.printStackTrace();
	         }

	        //完了画面を表示
	        request.getRequestDispatcher("/WEB-INF/view/done.jsp").forward(request, response);
	}

}
