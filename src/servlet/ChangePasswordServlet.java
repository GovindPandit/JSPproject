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

@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String pass=req.getParameter("password");
		String cpass=req.getParameter("confirmpassword");
		
		PrintWriter out=resp.getWriter();
		if(pass.equals(cpass))
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","root");
				PreparedStatement ps=con.prepareStatement("update users set password=? where email=?");
				ps.setString(1, pass);
				ps.setString(2, (String)req.getSession().getAttribute("email"));
				ps.executeUpdate();
				
				out.println(""
						+ "<script>"
						+ "alert('Your password is changed succesfully!!!');"
						+ "window.location='login.jsp';"
						+ "</script>");
			}
			catch (Exception e) 
			{
				System.out.println(e);
			}
		}
		else
		{
			out.println(""
					+ "<script>"
					+ "alert('Password and confirm password are not same!!!');"
					+ "window.location='changepassword.jsp';"
					+ "</script>");
		}
	}
}
