<%
if(request.getSession().getAttribute("login")!=null){
	
	  response.sendRedirect("dashboord");
	

}
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
<title>air traffic controller</title>
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

<%
if(request.getAttribute("error")!=null)
{
%>
<script> alert("error authentification !!!");</script>

<%
}

%>

<body>
	<!-- header section start-->
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
       <h1>controller</h1>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">

        </div>
         <div class="login_text"><a href="#login">LOGIN HERE</a></div>
    </nav>
	<!-- header section start-->
	<!-- banner section start-->
	<div class="banner_section layout_padding">
		<div class="container">
			<h1 class="best_taital" style="color:rgb(183, 230, 232)">Best Air traffic controller here</h1>
			<div class="box_main">
		    </div>
		    <p class="there_text" style="color:rgb(255, 255, 255)" >Air traffic control specialists, abbreviated ATCs, are personnel responsible for the safe, orderly, and expeditious flow of air traffic in the global air traffic control system. Usually stationed in air traffic control centers and control towers on the ground, they monitor the position, speed, and altitude of aircraft in their assigned airspace visually and by radar, and give directions to the pilots by radio.</p>
		    <div class="bt_main">
		    	<div class="discover_bt"></div>
		    </div>
		</div>
	</div>
	<!-- banner section end-->
	<!-- marketing section start-->
	<div class="marketing_section layout_padding" style="margin-top: -2%;">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-6">
					<div class="job_section">
					    <h1 class="jobs_text">Air networks</h1>
					    <p class="dummy_text">Air transport network or air transportation network (ATN) is an example of transport networks and spatial networks. The nodes of the network are the airports and the links represent direct flight routes between two airports. Alternatively, cities can be considered as the nodes with links representing direct flight connection between them.</p>
					    
					</div>
				</div>
				<div class="col-md-6">
					<div class="image_1 padding_0"><img src="images/map.png"></div>
				</div>
			</div>
		</div>
	</div>
	<!-- marketing section end-->
	<!-- footer section start-->
	<div class="footer_section layout_padding" id="login">
		<div class="container">
		<form action="Home" method="Post">
		
			<h1 class="subscribr_text"> LogIn </h1>
			<p class="lorem_text">There are many variations of passages of Lorem Ipsum available, but the majority have </p>
			<div class="box_main_2">
			    <textarea  class="email_bt_2" placeholder="Enter Your Email" name="username"  required="required"></textarea>
		    </div>
			<div class="box_main_2">
			    <input type="password"  class="email_bt_2" placeholder="Enter Your Password" name="password" required="required">
		    </div>
		    <button class="subscribe_bt_2" name="submit" >LogIn</button>
		</div>
		
		</form>
		
	</div>
	<!-- footer section end-->
	<!-- copyright section start-->
	<div class="copyright_section">
		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<p class="copyright_text">By its_rahmoun.<a href="https://github.com/Its7Rahmoun"> git hub here</a></p>
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


</body>
</html>


     
