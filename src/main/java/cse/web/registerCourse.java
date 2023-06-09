package cse.web;
import cse.web.Student;

import cse.web.Course;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class registerCourse
 */
@WebServlet("/registerCourse")
public class registerCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerCourse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		ServletRequest session = null;
//		if(session.getAttribute("uname")==null) {
//			response.sendRedirect("index.jsp");
//		}
		ArrayList<Course> courseList = new ArrayList<Course>();
	    
	       
            System.out.println(request.getAttribute("email"));
            
		   
		    RequestDispatcher rd;
		    Connection con=null;

		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		    try {

				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/web_app","root","password");
				PreparedStatement pst3=con.prepareStatement("SELECT * FROM courses");
			//	pst3.setString(1,rs.getString("username"));
				ResultSet rs3= pst3.executeQuery();
				
				while (rs3.next()) {
					  String courseId = rs3.getString("courseId");
					  String courseName = rs3.getString("courseName");
					  Double credit =rs3.getDouble("credit");
					  String courseTeacher=rs3.getString("teacherName");
					  
					  Course c=new Course(courseId,courseName,credit,courseTeacher);
					  courseList.add(c);
					}
				System.out.println(courseList);
				request.setAttribute("courseList", courseList);
				
			//	rd.forward(request,response);
			}catch(Exception e){

				e.printStackTrace();
			}finally {
				try {
					con.close();
				} catch (SQLException e) {

					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
        rd=request.getRequestDispatcher("/registerCourse.jsp");  
        rd.forward(request, response);  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<String> crs = new ArrayList<String>();
		ArrayList<Course> courseList = new ArrayList<Course>();
		HttpSession session  = request.getSession();
	    RequestDispatcher rd;

		
		String username = (String) session.getAttribute("name");
		System.out.println(username);
        
		String courseId = request.getParameter("courseId").toString();  
		
		System.out.println(courseId);
		
		  
		    Connection con=null;
		
		
		 try {

				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/web_app","root","password");
				
				

				
				PreparedStatement pst3=con.prepareStatement("SELECT DISTINCT registration FROM users WHERE username = ?");
				 
				pst3.setString(1, username);
			   
				
				ResultSet rs3= pst3.executeQuery();
				
				long reg = 0;
				
				while (rs3.next()) {
					
					 
					  reg = rs3.getLong("registration");
					
				}
				
			boolean fl =true;
			
			pst3 = con.prepareStatement("select courseId,student_name from course_reg where courseId = ? and student_name=?");
			pst3.setString(1,courseId);
			pst3.setString(2, username);
			
			ResultSet alreadyRegistered = pst3.executeQuery();
			
			while(alreadyRegistered.next()) {
				request.setAttribute("status","failed");
				fl = false;
			}
			
			if(fl) {
				request.setAttribute("status","success");
				 pst3 = con.prepareStatement("INSERT INTO course_reg(courseId,student_reg,student_name) values(?,?,?)");
		         
		         pst3.setString(1, courseId);
		         pst3.setLong(2, reg);
		         pst3.setString(3, username);
		         
		         pst3.executeUpdate();
			}
			
				
        
			
         
         PreparedStatement pst5=con.prepareStatement("SELECT courses.courseId,courseName,credit,teacherName "
					+ " FROM "
					+ " courses INNER JOIN course_reg "
					+ " ON courses.courseId=course_reg.courseId "
					+ " WHERE student_name=?;");
pst5.setString(1,username);
ResultSet rs5= pst5.executeQuery();

while (rs5.next()) {
 courseId = rs5.getString("courses.courseId");
String courseName = rs5.getString("courseName");
Double credit =rs5.getDouble("credit");
String courseTeacher=rs5.getString("teacherName");

Course c1=new Course(courseId,courseName,credit,courseTeacher);
courseList.add(c1);
}

                request.setAttribute("courseList", courseList);



                    rd=request.getRequestDispatcher("student.jsp");  
                rd.include(request, response);  
         
         
         
         
         				
				
				
		
		 }
		 catch(Exception e) {
			 
				e.printStackTrace();

			 
		 }
		 finally {
			 try {
					con.close();
				} catch (SQLException e) {

					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 }
		
		
	   
		
		
	
	}

}
