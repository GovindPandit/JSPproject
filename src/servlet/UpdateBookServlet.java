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

@WebServlet("/UpdateBookServlet")
public class UpdateBookServlet extends HttpServlet 
{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bookid=Integer.parseInt(request.getParameter("bookid"));
		String bookName= request.getParameter("bookname");
		String author= request.getParameter("author");
		String link= request.getParameter("link");
		Float price=Float.parseFloat(request.getParameter("price"));
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
			PreparedStatement ps=con.prepareStatement("update books set bookname=?,author=?,price=?,link=? where bookid=?");
			ps.setString(1, bookName);
			ps.setString(2, author);
			ps.setFloat(3, price);
			ps.setString(4, link);
			ps.setInt(5, bookid);
			ps.executeUpdate();
			response.sendRedirect("books.jsp");
		}
		catch(Exception e)
		{
			PrintWriter out=response.getWriter();
			out.println(e);
		}

	}

}
