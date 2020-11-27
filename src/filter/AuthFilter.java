package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Admin;

/**
 * Servlet Filter implementation class AuthFilter
 */
@WebFilter("/*")
public class AuthFilter implements Filter {

    /**
     * Default constructor.
     */
    public AuthFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// セッション取得やリダイレクト処理に必要な
		// HttpServlet系のRequestとResoponseを取得
		HttpServletRequest req =
			(HttpServletRequest) request;
		HttpServletResponse res =
			(HttpServletResponse) response;

		// セッションとURLの取得
		HttpSession session = req.getSession();
		String url = req.getRequestURI();

		// URLが/login以外の場合の処理
		if(!url.endsWith("/login") && !url.contains("/css/")) {
			// セッションにログイン済みの証があるか確認
			if(session.getAttribute("admin") == null) {
				res.sendRedirect("login");
				return;
			}
		}

		// auth_levelが２未満の場合、
				// ユーザー追加のページに行けない
				if(url.endsWith("/adminList")) {
					Admin admin = (Admin) session.getAttribute("admin");
		              if(admin.getAuthLevel() == 1) {
		                res.sendRedirect("topPage");
		                return;

					}
				}


		// pass the request along the filter chain
		chain.doFilter(request, response);
		}


	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

