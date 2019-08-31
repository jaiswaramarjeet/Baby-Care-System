<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contact Manager Home</title>
    </head>
    <style>
    html {
  font-family: "Lucida Sans", sans-serif;
}

.header {
  background-color: #9933cc;
  border-radius: 12px;
  color: #ffffff;
  padding: 15px;
}
    div.ex {
				text-align: right width:300px;
				padding: 10px;
				border: 5px solid grey;
				box-shadow: 5px 10px;
				margin: 0px
				
				}
	body 			{
 					 background-color: white;
					}
			h1 {
  				background-color: #9933cc;
			
				}
  .footer {
  background-color: #0099cc;
  border-radius: 12px;
  color: #ffffff;
  text-align: center;
  font-size: 12px;
  padding: 15px;
}
  
    </style>
   <body>
    <div class="header">
  <h1>MotherHood-The Step Towards Baby Care</h1>
  
  </div>
        <div align="center">
            <h1>All Babysitter List</h1>
           
            <table border="1">
                <th>Full Name</th>
                <th>Mobile number</th>
                <th>Gender</th>
                <th>Aadhar Number</th>
                
                <th>Address</th>
                <th>Area</th>
                <th>State</th>
                
                 
                <c:forEach var="l" items="${lo}" varStatus="status">
                <tr>
                    
                    <td>${l.getFull()}</td>
                    <td>${l.getNo()}</td>
                    <td>${l.getGender()}</td>
                   
                    
                    <td>${l.getAadhar()}</td>
                    
                    <td>${l.getAddress()}</td>
                    <td>${l.getArea()}</td>
                    <td>${l.getState()}</td>
                    
                    
                    
                    <td>
                      
                        <a href="deleteBabysitter?aadhar=${l.aadhar}">Delete</a>
                    </td>
                             
                </tr>
                </c:forEach>              
            </table>
        </div>
         <TD><FORM ACTION="adminprofile">
			<button type="submit"><-- back</button></TD>
    </body>
    <div class="footer">
            
  <p><strong>&copy Designed By Rishabh & Amarjeet</strong></p>
</div>
</html>