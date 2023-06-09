<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.InputStreamReader" %> 
<%@page import="java.util.ArrayList"%>
<%@page import="cse.web.Student"%>
<%@page import="cse.web.Course"%>

<%ArrayList<Course> courseList=(ArrayList<Course>)request.getAttribute("courseList");%>


   

<!DOCTYPE html>
<html>
<head>
	<title>Online Course Registration</title>
	<link rel="stylesheet" type="text/css" href="./public/st.css">
</head>
<body>
<input type="hidden" id="status" value="<%= request.getAttribute("status") %>" >
<%-- <%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setHeader("Pragme", "no-cache");
response.setHeader("Expires", "0");
if (session.getAttribute("name") == null) {
			response.sendRedirect("index.jsp");
		}
%> --%>

	<header>
		<nav>
			<h1>Student</h1>
      <h1> Online Course Registration</h1>
      <div>
      	<a href="./registerCourse">Register New Course</a> 
		<a href="logout">Logout</a>
      </div>
		</nav>
	</header>

	<main>
<!--  		<form>  -->
			<h2>Your Courses</h2>
			<table class="css-serial">
				<thead>
					<tr>
						<th>SL</th>
						<th>Course ID</th>
						<th>Course Name</th>
						<th>Credit</th>
					</tr>
				</thead>
        
				<tbody>
				<%! int i=0; %>  
			     <%
			    for(int j=0; j<courseList.size(); j++){%>
			            <tr>
			              <td> </td>
			              
			              <td><%=courseList.get(j).courseId %></td> 
						  <td><%=courseList.get(j).courseName %></td>            
			              <td><%=courseList.get(j).credit %></td> 
			            </tr>
			            
			
				<%}%>
				
			
			          
<!-- 					<tr>
						<td> </td>
						<td><input type="text" name="course-id"></td>
						<td><input type="text" name="course-name"></td>
						<td><input type="text" name="credit"></td>
					</tr>   -->
                
				</tbody>
			</table>

		<!--  		</form>  -->
	</main>
	<script src="vendor/jquery/jquery.min.css"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<link rel="stylesheet" href="alert/dist/sweetalert.css">
    <script type="text/javascript">
    	var status=document.getElementById("status").value;
    	if(status=="success"){
    		swal("Congrats","Course Enrolled Successfully", "success");
    	}
    	else if(status=="failed"){
    		swal("Sorry","Already Enrolled", "error");
    	}
    
    </script>
</body>
</html>