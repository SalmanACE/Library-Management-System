package LIb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class Screate
 */
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SignUp() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		try
		{
		
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			int i=1;
			Connection con=DriverManager.getConnection("Jdbc:Odbc:BookData");
			PreparedStatement st= con.prepareStatement("insert into Users(F_Name,L_Name,Phone,Address,User_ID,Password,Profession) values(?,?,?,?,?,?,?)");
			PreparedStatement st1= con.prepareStatement("insert into Users_Login(User_ID,Password) values(?,?)");
			String sfname=request.getParameter("fname");
			String slname = request.getParameter("lname");
			String sphone = request.getParameter("pnum");
			String saddress = request.getParameter("address");
			String suser= request.getParameter("cuserid");
			String spassword = request.getParameter("cpassword");
			String sprofession=request.getParameter("cprofession");
			Statement stt = con. createStatement();
			ResultSet rst= stt.executeQuery("select User_ID from Users_Login");
			while(rst.next())
			{
					String a=rst.getString(1);
					if(a.equals(suser))
					{
						//out.print("User Id already Exists");
						i=0;
						response.sendRedirect("ReRegister.html");
					}
			}
			if(i==1)
			{
				st.setString(1,sfname);
				st.setString(2,slname);
				st.setString(3,sphone);
				st.setString(4,saddress);
				st.setString(5,suser);
				st.setString(6,spassword);
				st.setString(7,sprofession);
				st.executeUpdate();
				st1.setString(1,suser);
				st1.setString(2,spassword);
				st1.executeUpdate();
				response.sendRedirect("frame3.html");
			}
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
