package LIb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class Sbooks
 */
public class Take_Books extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Take_Books() {
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
			PreparedStatement st=con.prepareStatement("insert into Taken_Books(ID,UserName,Book1,Book2,Book3,Book4) values(?,?,?,?,?,?)");
			String s1=request.getParameter("bname");
			String s2=request.getParameter("bid");
			String s3=request.getParameter("vbook1");
			String s4=request.getParameter("vbook2");
			String s5=request.getParameter("vbook3");
			String s6=request.getParameter("vbook4");
			st.setString(1,s1);
			st.setString(2,s2);
			st.setString(3,s3);
			st.setString(4,s4);
			st.setString(5,s5);
			st.setString(6,s6);
			st.executeUpdate();
			response.sendRedirect("UserPage.html");
		}
		catch(Exception e)
		{
			out.print(e.getMessage());
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
