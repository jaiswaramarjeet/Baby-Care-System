<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<style>
* {
  box-sizing: border-box;
}

.row::after {
  content: "";
  clear: both;
  display: table;
}

[class*="col-"] {
  float: left;
  padding: 15px;
}

html {
  font-family: "Lucida Sans", sans-serif;
}

.header {
  background-color: #9933cc;
  border-radius: 12px;
  color: #ffffff;
  padding: 15px;
}

.menu ul {
  list-style-type: none;
  color: #00050d;
  margin: 0;
  padding: 0;
}

.menu li {
  padding: 8px;
  margin-bottom: 7px;
  background-color: #33b5e5;
  border-radius: 12px;
  color: #ffffff;
  box-shadow: 0 1px 3px rgba(0,0,0,0.12), 0 1px 2px rgba(0,0,0,0.24);
}

.menu li:hover {
  background-color: #ffffff;
}

.aside {
  background-color: #33b5e5;
  border-radius: 12px;
  padding: 15px;
  color: #ffffff;
  text-align: center;
  font-size: 14px;
  box-shadow: 0 1px 3px rgba(0,0,0,0.12), 0 1px 2px rgba(0,0,0,0.24);
}

.footer {
  background-color: #0099cc;
  border-radius: 12px;
  color: #ffffff;
  text-align: center;
  font-size: 12px;
  padding: 15px;
}

/* For mobile phones: */
[class*="col-"] {
  width: 100%;
}

@media only screen and (min-width: 600px) {
  /* For tablets: */
  .col-s-1 {width: 8.33%;}
  .col-s-2 {width: 16.66%;}
  .col-s-3 {width: 25%;}
  .col-s-4 {width: 33.33%;}
  .col-s-5 {width: 41.66%;}
  .col-s-6 {width: 50%;}
  .col-s-7 {width: 58.33%;}
  .col-s-8 {width: 66.66%;}
  .col-s-9 {width: 75%;}
  .col-s-10 {width: 83.33%;}
  .col-s-11 {width: 91.66%;}
  .col-s-12 {width: 100%;}
}
@media only screen and (min-width: 768px) {
  /* For desktop: */
  .col-1 {width: 8.33%;}
  .col-2 {width: 16.66%;}
  .col-3 {width: 25%;}
  .col-4 {width: 33.33%;}
  .col-5 {width: 41.66%;}
  .col-6 {width: 50%;}
  .col-7 {width: 58.33%;}
  .col-8 {width: 66.66%;}
  .col-9 {width: 75%;}
  .col-10 {width: 83.33%;}
  .col-11 {width: 91.66%;}
  .col-12 {width: 100%;}
}
</style>
</head>
<body>

<div class="header">
  <h1>MotherHood-The Step Towards Baby Care</h1>
  
</div>

<div class="row">
  <div class="col-3 col-s-3 menu">
    <ul>
      <li><a href="registration">Register Yourself</a></li>
      <li><a href="loginuser">Login</a></li>
      <li><a href="about">About Us</a></li>
    </ul>
  </div>

  <div class="col-6 col-s-9">
    <h1>MotherHood</h1>
    <p>Being a parent is one of the most wonderful and rewarding roles you will ever have in your life, it's also likely to be the toughest. Every baby has their own characteristics and traits which make them the person they are and you will have to adapt to their ever changing needs.</p>
     <img src="https://i.ibb.co/N9V30DF/Motherhood.png" alt="Motherhood" style="width:400px;height:142px;">
  </div>

  <div class="col-3 col-s-12">
    <div class="aside">
      <h2>BABYCARE</h2>
      <p>Taking care of your newborn baby can be a "challenging" experience and time. How warm should the bath water temperature be or how to coax your little one to a restful night of good sleep, find the answers to these questions here with our detailed information</p>
    </div>
  </div>
</div>
&nbsp;
&nbsp;
&nbsp;
&nbsp;
&nbsp;
&nbsp;

<div class="footer">
  <p><strong>&copy Designed By Rishabh & Amarjeet</strong></p>
</div>
<div class="w3-container">
            <ul class="w3-ul">
           <li><i class="glyphicon glyphicon-user"></i><a href="admin"></i>@</li>
             </ul>
             </div>

</body>
</html>
