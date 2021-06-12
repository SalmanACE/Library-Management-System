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
public class Search_Book extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search_Book() {
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
			String sname=request.getParameter("value1");
			Statement sst=con.createStatement();
			out.println("<html><head> <style> body{ background-image:url(all11.jpg);  background-size:cover; background-repeat:no-repeat; } div{ color:white; } </style> </head> ");
			out.print("<body>");
			out.print("<div>");
			ResultSet rset =sst.executeQuery("select * from Current_Books where Name='"+sname+"'") ;
			 while(rset.next())
			{
					out.println("Name :"+ rset.getString(1)+"<br>");
					out.println("Id :" +rset.getString(2)+"<br>");
					out.println("Author :"+ rset.getString(3)+"<br>");
					out.println("Edition :"+ rset.getString(4)+"<br>");
					out.println("Volume :"+ rset.getString(5)+"<br>");
					out.println("Detail :" +rset.getString(6)+"<br>");
					out.println("Publication :" +rset.getString(7)+"<br>");
					out.println("Price :" +rset.getString(8)+"<br>");
					out.println("Rackno :" +rset.getString(9)+"<br>");
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
