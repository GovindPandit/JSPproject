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

@WebServlet(name="AddBookServlet",urlPatterns = "/AddBookServlet")
public class AddBookServlet extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String bookname=req.getParameter("bookname");
		String author=req.getParameter("author");
		float price=Float.parseFloat(req.getParameter("price"));
		String link=req.getParameter("link");
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
			PreparedStatement ps=con.prepareStatement("insert into books (bookname,author,price,link) values(?,?,?,?)");
			ps.setString(1, bookname);
			ps.setString(2, author);
			ps.setFloat(3, price);
			ps.setString(4, link);
			ps.executeUpdate();
			resp.sendRedirect("books.jsp");
		}
		catch(Exception e)
		{
			PrintWriter out=resp.getWriter();
			out.println(e);
		}
	}
}
