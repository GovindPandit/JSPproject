package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

@WebServlet(name="AddToCartServlet",urlPatterns = "/AddToCartServlet")
public class AddToCartServlet extends HttpServlet 
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		doPost(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		HttpSession hs  = req.getSession();
		
		int bookid      = Integer.parseInt(req.getParameter("bookid"));
		String username = ((User)hs.getAttribute("u")).getUsername();
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
			PreparedStatement ps = con.prepareStatement("insert into cartitems (bookid,username) values(?,?)");
			ps.setInt(1, bookid);
			ps.setString(2, username);
			ps.executeUpdate();
			
			PrintWriter out=resp.getWriter();
			
			out.println(""
					+ "<script>"
					+ "alert('cart item added successfully!!!');"
					+ "window.location='cart.jsp';"
					+ "</script>");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
