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
public class Remove_Books extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Remove_Books() {
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
			Statement st = con. createStatement();
			ResultSet rst= st.executeQuery("select ID from Current_Books");
			while(rst.next())
			{
					String a=rst.getString(1);
					if(a.equals(sid))
						
					{
						PreparedStatement rst1= con.prepareStatement("delete from Current_Books where ID='"+sid+"'");
						rst1.executeUpdate();
						i=0;
					}
			}
			if(i==0)
			{
				out.print("Book's Data Deleted Successfully");
					
			}
			else
			{
				out.print("Book's Data was not found");
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
