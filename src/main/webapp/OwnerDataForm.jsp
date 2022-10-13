<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css?family=Roboto:400,700,900&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="fonts/icomoon/style.css">


    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    
    <!-- Style -->
    <link rel="stylesheet" href="css/style.css">

    <title>Owner Form</title>
  </head>
  <body>
  

  <div class="content">
     
    <div class="container ">
      <div class="row align-items-stretch no-gutters contact-wrap mt-5">
        <div class="col-md-8">
          <div class="form h-100">
            <h3>BIDDING Details</h3>
            <form class="mb-5" id="contactForm" name="contactForm" action="createBid" method="post">
              <div class="row">
              
                  <div class="col-md-6 form-group mb-5 mt-5">
                  <label for="" class="col-form-label">Create Date *</label>
                  <input type="date" class="form-control" name="createdDate" id="createdDate" placeholder="Create Date">
                </div>
                
                 <div class="col-md-6 form-group mb-5 mt-5">
                  <label for="" class="col-form-label">Closing Date *</label>
                  <input type="date" class="form-control" name="closeDate" id="closeDate" placeholder="Closing Date">
                </div>
                
              </div>

          

              <div class="row">
                <div class="col-md-12 form-group mb-5">
                  <label for="message" class="col-form-label">Description *</label>
                  <textarea class="form-control" name="description" id="message" cols="30" rows="4"  placeholder="Write your Description"></textarea>
                </div>
              </div>
              <div class="row">
                <div class="col-md-12 form-group">
                  <!--  <input type="submit" value="Submit_BID" class="btn btn-primary rounded-0 py-2 px-4" name="createBid">-->
               <!--   <button type="submit" class="btn btn-primary">
                 Create BID
                 </button> -->
                <input type="submit" value="Submit">
                
                	
                </div>
              </div>
            </form>

           

          </div>
        </div>
        <div class="col-md-4">
          <div class="contact-info h-100">
            <h3>Contact Information</h3>
            <p class="mb-5">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Molestias, magnam!</p>
            <ul class="list-unstyled">
              <li class="d-flex">
                <span class="wrap-icon icon-room mr-3"></span>
                <span class="text">9757 Aspen Lane South Richmond Hill, NY 11419</span>
              </li>
              <li class="d-flex">
                <span class="wrap-icon icon-phone mr-3"></span>
                <span class="text">+1 (291) 939 9321</span>
              </li>
              <li class="d-flex">
                <span class="wrap-icon icon-envelope mr-3"></span>
                <span class="text">info@mywebsite.com</span>
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