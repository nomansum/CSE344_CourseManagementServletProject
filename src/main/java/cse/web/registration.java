package cse.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class registration
 */
@WebServlet("/registration")
public class registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		String userName= request.getParameter("userName");
		String registraion= request.getParameter("registraion");
		String email= request.getParameter("email");
		String password= request.getParameter("password");
		String role= request.getParameter("role");
		int rowCount = 0;
		boolean fl = true;
		RequestDispatcher dispatcher = null;
		Connection con = null;
		
		try {
			System.out.println(userName + email + registraion + role);
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/web_app","root","password");
			PreparedStatement pstPrev = con.prepareStatement("SELECT * FROM users WHERE email=?");
			
			pstPrev.setString(1, email);
			 ResultSet validation = pstPrev.executeQuery();
			
			 if(validation.next()) {
				 System.out.println("INSIDE THE EMAIL\n");
				  fl = false;
			  }
			  pstPrev = con.prepareStatement("SELECT * FROM users WHERE username=?");
				
				pstPrev.setString(1, userName);
				 validation = pstPrev.executeQuery();
				
				 if(validation.next()) {
					 System.out.println("INSIDE THE Username\n");
					  fl = false;
				  }
				 pstPrev = con.prepareStatement("SELECT * FROM users WHERE registration=?");
					
					pstPrev.setString(1, registraion);
					 validation = pstPrev.executeQuery();
					
					 if(validation.next()) {
						 System.out.println("INSIDE THE reg\n");
						  fl = false;
					  }
					 
					  
			  
			  
			   rowCount = 0;
			
		  if(fl) {
			   
			  
			  
				PreparedStatement pst=con.prepareStatement("insert into users (username,registration,email,password,role) VALUES(?,?,?,?,?)");
				pst.setString(1,userName);
				pst.setString(2,registraion);
				pst.setString(3,email);
				pst.setString(4,password);
				pst.setString(5,role);
				
		 rowCount = pst.executeUpdate();
		
		  }
			 
			 
		
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(fl && rowCount > 0) {
				request.setAttribute("status","success");
			}
			else {
				request.setAttribute("status", "failedReg");
				
			}
			
			

			dispatcher = request.getRequestDispatcher("index.jsp");

			
			dispatcher.forward(request,response);
			
		}

//		PrintWriter out=response.getWriter();		
//		out.print("<h1>"+firstName+"</h1>");
//		out.print("<h1>"+lastName+"</h1>");
//		out.print("<h1>"+email+"</h1>");
//		out.print("<h1>"+password+"</h1>");
//		doGet(request, response);
		
		
	}

}
