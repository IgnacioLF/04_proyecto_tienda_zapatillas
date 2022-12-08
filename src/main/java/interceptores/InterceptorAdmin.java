package interceptores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class InterceptorAdmin extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
	
		if( request.getParameter("pass")!=null && 
			request.getParameter("pass").equals("123")){
			request.getSession().setAttribute("admin", "ok");
		}
		
		if( request.getSession().getAttribute("admin") != null && 
			request.getSession().getAttribute("admin").equals("ok")) {
			return true;
		}else {
			response.sendRedirect("../loginAdmin.jsp");
			return false;
		}
		
	}
	
}
