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
 * Servlet implementation class Search_Book
 */
public class AllUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllUsers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		long i=1;
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con=DriverManager.getConnection("Jdbc:Odbc:BookData");
			Statement sst=con.createStatement();
			out.println("<html><head> <style> body{ background-image:url(all11.jpg);  background-size:cover; background-repeat:no-repeat; } div{ color:white; } </style> </head> ");
			out.print("<body>");
			out.print("<div>");
			ResultSet rset =sst.executeQuery("select * from Users") ;
			 while(rset.next())
			{
				 	out.print("\nUser :"+i+++"<br>");
				 	out.print("\nName :"+ rset.getString(1)+""+rset.getString(2)+"<br>"); 
					out.print("\nPhone Number :" +rset.getString(3)+"<br>");
					out.print("\nAddress :"+ rset.getString(4)+"<br>");
					out.print("\nUser ID :"+ rset.getString(5)+"<br>");
					out.print("\nPassword :"+ rset.getString(6)+"<br>");
					out.print("\nProfession :"+ rset.getString(7)+"<br>");
					out.print("\n");
					//response.sendRedirect("AdminPage.html");
			 } 
			 out.print("</body>");
			 out.print("</div>");
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
