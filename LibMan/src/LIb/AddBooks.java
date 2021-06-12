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

public class AddBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBooks() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con = DriverManager.getConnection("Jdbc:Odbc:BookData");
			PreparedStatement st=con.prepareStatement("insert into Books(Id,Name,Author,Details,Edition,Volume,Price,Publication,Rack_Number) values(?,?,?,?,?,?,?,?,?)");
			PreparedStatement st1=con.prepareStatement("insert into Current_Books(Id,Name,Author,Details,Edition,Volume,Price,Publication,Rack_Number) values(?,?,?,?,?,?,?,?,?)");
			String s1=request.getParameter("bname");
			String s2=request.getParameter("bid");
			String s3=request.getParameter("bauthor");
			String s4=request.getParameter("bdetails");
			String s5=request.getParameter("bedition");
			String s6=request.getParameter("bvolume");
			String s7=request.getParameter("bprice");
			String s8=request.getParameter("bpublication");
			String s9=request.getParameter("bRack_Number");
			st.setString(1,s1);
			st.setString(2,s2);
			st.setString(3,s3);
			st.setString(4,s4);
			st.setString(5,s5);
			st.setString(6,s6);
			st.setString(7,s7);
			st.setString(8,s8);
			st.setString(9,s9);
			st1.setString(1,s1);
			st1.setString(2,s2);
			st1.setString(3,s3);
			st1.setString(4,s4);
			st1.setString(5,s5);
			st1.setString(6,s6);
			st1.setString(7,s7);
			st1.setString(8,s8);
			st1.setString(9,s9);
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
