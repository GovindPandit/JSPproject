package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

@WebServlet(name="LoginServlet",urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		User u=new User();
		u.setUsername(req.getParameter("username"));
		u.setPassword(req.getParameter("password"));
		
		try
		{
			
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
			PreparedStatement ps=con.prepareStatement("select * from users where username=? and password=?");
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ResultSet rs=ps.executeQuery();

			PrintWriter out=resp.getWriter();
			if(rs.next()) 
			{
				u.setEmail(rs.getString("email"));
				u.setRole(rs.getString("role"));
				
				HttpSession hs=req.getSession();
				//hs.setMaxInactiveInterval(60*2);
				hs.setAttribute("u", u);

				Cookie ck1=new Cookie("un", u.getUsername());
				Cookie ck2=new Cookie("pwd", u.getPassword());
				
				ck1.setMaxAge(30);
				ck2.setMaxAge(30);
				
				resp.addCookie(ck1);
				resp.addCookie(ck2);
				
				
				out.println(""
						+ "<script>"
						+ "alert('Welcome "+u.getUsername()+"');"
						+ "window.location='home.jsp';"
						+ "</script>");
			}
			else
			{
				out.println(""
						+ "<script>"
						+ "alert('Incorrect username or password');"
						+ "window.location='login.jsp';"
						+ "</script>");
			}
		}
		catch(Exception e)
		{
			PrintWriter out=resp.getWriter();
			out.println(e);
		}
	}
}
