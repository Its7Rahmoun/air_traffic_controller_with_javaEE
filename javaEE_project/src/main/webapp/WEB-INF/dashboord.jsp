
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.modul.*" %>
<% 
if(request.getSession().getAttribute("login")==null){
	response.sendRedirect("Home");
}
%>
<%
ArrayList<flight> flights = (ArrayList<flight>) request.getAttribute("flights");
%>
<!DOCTYPE html>
<html lang="en">
<head>
<!-- basic -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- mobile metas -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="initial-scale=1, maximum-scale=1">
<!-- site metas -->
<title> air traffic controller </title>
<meta name="keywords" content="">
<meta name="description" content="">
<meta name="author" content="">	
<!-- bootstrap css -->
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<!-- style css -->
<link rel="stylesheet" type="text/css" href="css/style.css">
<!-- Responsive-->
<link rel="stylesheet" href="css/responsive.css">
<!-- fevicon -->
<link rel="icon" href="images/fevicon.png" type="image/gif" />
<!-- Scrollbar Custom CSS -->
<link rel="stylesheet" href="css/jquery.mCustomScrollbar.min.css">
<!-- Tweaks for older IEs-->
<link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
<!-- owl stylesheets --> 
<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesoeet" href="css/owl.theme.default.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css" media="screen">

</head>
<body>
	<!-- header section start-->
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <h1>Controller</h1>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
        </div>
    </nav>
	<!-- header  section end-->
	<!-- Recurments  section start-->
    <div class="services_section">
        <div class="container">
            <h1 class="services_text">All flights available</h1>
        </div>
    </div>



<div class="container">

                    <div class="row height d-flex justify-content-center align-items-center">

                      <div class="col-md-8">
						<form action="flights" method="POST">
                        <div class="search">
                          <i class="fa fa-search"></i>
                          <input type="text" class="form-control" placeholder="......." name="searchfeild">
                          <button class="btn btn-primary" name="search">Search</button>
                        </div>
                        </form>
                        
                      </div>
                      
                    </div>
                </div>
                
                
<style>

@import url("https://fonts.googleapis.com/css2?family=Poppins:weight@100;200;300;400;500;600;700;800&display=swap");



       .height{
        height: 10vh;
       }
       

       .search{
       margin-top:1%;
       position: relative;
       box-shadow: 0 0 40px rgba(51, 51, 51, .1);
         
       }

       .search input{

        height: 60px;
        text-indent: 25px;
        border: 2px solid #d6d4d4;


       }


       .search input:focus{

        box-shadow: none;
        border: 2px solid blue;


       }

       .search .fa-search{

        position: absolute;
        top: 20px;
        left: 16px;

       }

       .search button{

        position: absolute;
        top: 5px;
        right: 5px;
        height: 50px;
        width: 110px;
        background: blue;

       }

</style>


<form  action="flights" method="POST">
    
    <%
    for(flight f : flights)
    {
    %>

    <div class="Recurments_section_2">
    	<div class="container">
    		<div class="product_section">
    			<div class="row padding_top_0">
    				<div class="col-sm-2">
    					<div class="one_text"><a href="#" class="active"> <%=f.getId() %> </a></div>
    				</div>
    				<div class="col-sm-8">
    					<h1 class="software_text"><%=f.getNamecompany() %></h1>
    					<p class="lorem_ipsum_text">This flight departs from <%=f.getSource() %> to <%=f.getDestination() %>.</p>
    				</div>
    				<div class="col-sm-2" >
              <input type="checkbox" name="flights" value="<%=f.getId() %>/<%=f.getSource()%>/<%=f.getDestination()%>">
    				</div>
    			</div>
    	</div>
    </div>
    
    
 <% 
 }
 %>
 
 <center  >
 <button style="margin: 50px ; padding: 10px;background-color: blue; color : white;" name="submit"> Run flights </button>
 </center>
 
 </form>


	<!-- Recurments  section end-->

    <!-- copyright section start-->
    <div class="copyright_section">
      <div class="container">
        <div class="row">
          <div class="col-md-6">
            <p class="copyright_text">By its_rahmoun.<a href="https://github.com/Its7Rahmoun"> github here</a></p>
          </div>
          <div class="col-md-6">
            <p class="cookies_text">Cookies, Privacy and Terms</p>
          </div>
        </div>
      </div>
    </div>
    <!-- copyright section end-->


    <!-- Javascript files-->
    <script src="js/jquery.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.bundle.min.js"></script>
      <script src="js/jquery-3.0.0.min.js"></script>
      <script src="js/plugin.js"></script>
      <!-- sidebar -->
      <script src="js/jquery.mCustomScrollbar.concat.min.js"></script>
      <script src="js/custom.js"></script>
      <!-- javascript --> 
      <script src="js/owl.carousel.js"></script>
      <script src="https:cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.js"></script>
      <script>
      $(document).ready(function(){
      $(".fancybox").fancybox({
         openEffect: "none",
         closeEffect: "none"
         });
         </script>


     
</body>
</html>