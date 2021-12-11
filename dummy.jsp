<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//w3C//DTD HTML 4.01 Transitional//EN" "http://www.we3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
      content="width=device-width,initial-scale=1, shrink-to-fit=no">
      
      <!-- Bootstrap CSS -->
      <link rel="stylesheet"
      href="https://stackpath.boostrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
      integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYM70gZWKYbI706tWS"
      crossorigin="anonymous">
      
<title>Customer Directory</title>
</head>

<body>
         <div class="container">
         
             <center>
                 <b>
                   <font size ="3">
                      <h1  style="background-color:Voilet;">CUSTOMER ENROLLED</h1>
                   </font>
                 </b>
             </center>
               <hr>
        

			<!-- Add a button -->
			<a href="/CustomerRelationshipManagement/customer/showFormForAdd"
				class="btn btn-primary btn-sm mb-3"> Add Customer </a> 
			 
             
             <!-- Display table user interface -->
             <table  class="table table-bordered table-striped">
			<thead class="thead-dark">
				<tr>
					<th>Student Id</th>
					<th>Name</th>
					<th>Firstname</th>
					<th>Lastname</th>
					<th>Action</th>
				</tr>
			</thead>
			
            <tbody>
				<c:forEach items="${Customer}" var="c">
					<tr>
					<td><c:out value="${c.id}" /></td>
						<td><c:out value="${c.firstname}" /></td>
						<td><c:out value="${c.lastname}" /></td>
						<td><c:out value="${c.email}" /></td>
						<td>
							<!-- Add "update" button/link -->     
						<a href="/CustomerRelationshipManagement/customer/showFormForUpdate?id=${c.id}"
							class="btn btn-info btn-sm"> Update </a>
							
							 <!-- Add "delete" button/link -->
							<a href="/CustomerRelationshipManagement/customer/delete?id=${c.id}"
							class="btn btn-danger btn-sm"
							onclick="if (!(confirm('Are you sure you want to delete ?'))) return false">
								Delete </a> 

						</td>

					</tr>
				</c:forEach>

			</tbody>
		</table>
   </div>             
           
         
         
         
         
		                                                                                                                                                                                                                                                                                                                                                                                                                                                                         



</body>
</html>
    