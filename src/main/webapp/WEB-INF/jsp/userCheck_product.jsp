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
            <h1>Product List</h1>
           
            <table border="1">
                <th>Product Id</th>
                <th>Product Name</th>
                <th>Product Link</th>
                <th>Description</th>
                <th>Buy</th>
                
                 
                <c:forEach var="l" items="${lo}" varStatus="status">
                <tr>
                    
                    <td>${l.getId()}</td>
                    <td>${l.getName()}</td>
                    <td>${l.getImg()}</td>
                    <td>${l.getPrice()}</td>
                     <td>
                      
                        <a href="${l.img}">Buy</a>
                    </td> 
                    
                                               
                </tr>
                </c:forEach>              
            </table>
        </div>
         <TD><FORM ACTION="profile">
			<button type="submit"><-- Profile</button></TD>
    </body>
    &nbsp;
    <div class="footer">
            
  <p><strong>&copy Designed By Rishabh & Amarjeet</strong></p>
</div>
</html>