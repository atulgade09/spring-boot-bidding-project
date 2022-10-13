<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link
	href="https://fonts.googleapis.com/css?family=Roboto:400,700,900&display=swap"
	rel="stylesheet">

<link rel="stylesheet" href="fonts/icomoon/style.css">


<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">

<!-- Style -->
<link rel="stylesheet" href="css/style.css">


<title>Insert title here</title>
</head>
<body>
	<!-- <form action="createBid" method="post">
<input type="date" name="createdDate">
<input type="date" name="closeDate">
<input type="text" name="description" placeholder="Description">
<input type="submit" value="Submit">
</form> -->

	<div class="content">

		<div class="container ">
			<div class="row align-items-stretch no-gutters contact-wrap mt-5">
				<div class="col-md-8">
					<div class="form h-100">
						<h3>BIDDING Details</h3>
						<form class="" name="contactForm" action="insertRaisedBid"
							method="post">
							<div class="row">
	
								<div class="col-md-6 form-group mb-3 mt-3">
									<label for="" class="col-form-label">Description *</label> 
									<h3>${bidData.description}</h3>
								</div>

								<div class="col-md-6 form-group mb-3 mt-3">
									<label for="" class="col-form-label">Opening Date *</label> 
									<h3>${bidData.createdDate}</h3>
								</div>
							</div>
							
							<div class="row">
	
								<div class="col-md-6 form-group mb-3 mt-3">
									<label for="" class="col-form-label">Closing date *</label> 
									<h3>${bidData.closeDate}</h3>
								</div>

								<div class="col-md-6 form-group mb-3 mt-3">
									<label for="" class="col-form-label">Bid Starts at *</label> 
									<h3 class="text-danger"><b class="fs-1">$ ${bidData.bidCost}</b> </h3>
								</div>
							</div>

							

							<div class="row">
							<div class="col-md-6  form-group mb-3">
								<label for="" class="col-form-label">Bid Amount *</label> <input
									type="number" class="form-control" name="bidAmount"
									placeholder="Biding Cost" value="0">
							</div>
							
								<div class="col-md-6 form-group mb-5">
									<label for="message" class="col-form-label">Working Range
										*</label>
									<input
									type="number" class="form-control" name="workRange"
									placeholder="Biding Cost" value="0">
								</div>
							</div>
							<div class="row">
								<div class="col-md-12 form-group">
									<!--  <input type="submit" value="Submit_BID" class="btn btn-primary rounded-0 py-2 px-4" name="createBid">-->
									<!--   <button type="submit" class="btn btn-primary">
                 Create BID
                 </button> -->
									<input type="submit" value="Raise BID"
										class="btn btn-primary rounded-0 py-2 px-4">


								</div>
							</div>
						</form>



					</div>
				</div>
				<div class="col-md-4">
					<div class="contact-info h-100" style="padding-top:100px;">
						<h3>Reach Us</h3>
						<h3 class="mb-5 text-white"><b>iProgrammer Solutions Private
							Limited</b> </h3>
						<ul class="list-unstyled">
							<li class="d-flex"><span class="wrap-icon icon-room mr-3"></span>
								<span class="text">Office 103, 104 1st floor Pride Portal
									Senapati Bapat Road Bahiratwadi, Shivaji Co operative Housing
									Society, Gokhalenagar, Pune, Maharashtra 411016</span></li>
							<li class="d-flex"><span class="wrap-icon icon-phone mr-3"></span>
								<span class="text">+1 (291) 939 9321</span></li>
							<li class="d-flex"><span
								class="wrap-icon icon-envelope mr-3"></span> <span class="text">info@mywebsite.com</span>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>

	</div>



	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.validate.min.js"></script>
	<script src="js/main.js"></script>


</body>
</html>