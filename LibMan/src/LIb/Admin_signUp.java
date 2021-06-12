package LIb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class Screate
 */
public class Admin_signUp extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Admin_signUp() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		try
		{

		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		
		Connection con=DriverManager.getConnection("Jdbc:Odbc:BookData");
		
		PreparedStatement st= con.prepareStatement("insert into AdminInfo(FirstName,LastName,PhoneNumber,Address,UserID,Password) values(?,?,?,?,?,?)");
		PreparedStatement st1= con.prepareStatement("insert into Admin(UserID,Password) values(?,?)");
		String sfname=request.getParameter("fname");
		String slname = request.getParameter("lname");
		String sphone = request.getParameter("pnum");
		String saddress = request.getParameter("address");
		String suser= request.getParameter("cuserid");
		String spassword = request.getParameter("cpassword");
		st.setString(1,sfname);
		st.setString(2,slname);
		st.setString(3,sphone);
		st.setString(4,saddress);
		st.setString(5,suser);
		st.setString(6,spassword);
		st1.setString(1,suser);
		st1.setString(2,spassword);
		st.executeUpdate();
		st1.executeUpdate();
		response.sendRedirect("AdminPage.html");
		}
		catch(Exception e)
		{
			out.println(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
