package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;

@WebFilter(urlPatterns = {"/addbook.jsp","/edit.jsp","/DeleteServlet"})
public class LoginFilter implements Filter
{
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException 
	{
			HttpServletRequest req=(HttpServletRequest)request;
			HttpServletResponse resp=(HttpServletResponse)response;
			
			if(req.getSession().getAttribute("u")==null)
			{
				resp.sendRedirect("login.jsp");
			}
			else 
			{
				User u=(User)req.getSession().getAttribute("u");
				if(!u.getRole().equals("admin"))
					resp.sendRedirect("login.jsp");
			}
			
			chain.doFilter(req, resp);
	}
}
