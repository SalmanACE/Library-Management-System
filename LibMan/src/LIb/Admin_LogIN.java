package LIb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class adminDelete
 */
public class Admin_LogIN extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin_LogIN() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		int i=1;
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con = DriverManager.getConnection("Jdbc:Odbc:BookData");
			String sid= request.getParameter("value1");
			String spassword = request.getParameter("value2");
			Statement st = con. createStatement();
			ResultSet rst= st.executeQuery("select * from Admin");
			while(rst.next())
			{
					String a=rst.getString(1);
					String b=rst.getString(2);
					if(a.equals(sid) && b.equals(spassword))
					{
						//out.print("found");
						i=0;
					}
			}
			if(i==0)
			{
				response.sendRedirect("AdminPage.html");
			}
			else
			{
				response.sendRedirect("ReRegister.html");
			}
			
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
