package LIb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Taken_List
 */
public class Taken_List extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Taken_List() {
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
			Connection con=DriverManager.getConnection("Jdbc:Odbc:BookData");
			Statement sst=con.createStatement();
			ResultSet rset =sst.executeQuery("select * from Taken_Books") ;
			out.println("<html><head> <style> body{ background-image:url(all11.jpg);  background-size:cover; background-repeat:no-repeat; } div{ color:white; } </style> </head> ");
			out.print("<body>");
			out.print("<div>");
			 while(rset.next())
			{
					out.println("ID :"+ rset.getString(1)+"<br>"); 
					out.println("User Name :" +rset.getString(2)+"<br>");
					out.println("Book 1 :"+ rset.getString(3)+"<br>");
					out.println("Book 2 :"+ rset.getString(4)+"<br>");
					out.println("Book 3 :"+ rset.getString(5)+"<br>");
					out.println("Book 4 :" +rset.getString(6)+"<br><br>");
			 } 
			 out.print("</div>");
			 out.print("</body>");
				
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
