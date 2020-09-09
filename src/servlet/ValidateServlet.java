package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ValidateServlet")
public class ValidateServlet extends HttpServlet 
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String value=req.getParameter("value");//govindpanditniit@gmail.com
		String id=req.getParameter("id");//email
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
			PreparedStatement ps=con.prepareStatement("select * from users where "+id+"=?");
			ps.setString(1, value);
			ResultSet rs=ps.executeQuery();
			
			PrintWriter out=resp.getWriter();
			if(rs.next())
			{
				con.close();
				out.println(id+" is already exist");
			}
			con.close();
		}
		catch(Exception e) 
		{
			PrintWriter out=resp.getWriter();
			out.println(e);
		}
	}
}
