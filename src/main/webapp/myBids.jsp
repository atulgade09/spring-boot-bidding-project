
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Owner Details</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">


<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">

li


<style>
body {
	color: #566787;
	background: #f5f5f5;
	font-family: 'Varela Round', sans-serif;
	font-size: 13px;
}

.table-responsive {
	margin: 30px 0;
}

.table-wrapper {
	min-width: 1000px;
	background: #fff;
	padding: 20px 25px;
	border-radius: 3px;
	box-shadow: 0 1px 1px rgba(0, 0, 0, .05);
}

.table-title {
	padding-bottom: 15px;
	background: #435d7d;
	color: #fff;
	padding: 16px 30px;
	margin: -20px -25px 10px;
	border-radius: 3px 3px 0 0;
}

.table-title h2 {
	margin: 5px 0 0;
	font-size: 24px;
}

.table-title .btn-group {
	float: right;
}

.table-title .btn {
	color: #fff;
	float: right;
	font-size: 13px;
	border: none;
	min-width: 50px;
	border-radius: 2px;
	border: none;
	outline: none !important;
	margin-left: 10px;
}

.table-title .btn i {
	float: left;
	font-size: 21px;
	margin-right: 5px;
}

.table-title .btn span {
	float: left;
	margin-top: 2px;
}

table.table tr th, table.table tr td {
	border-color: #e9e9e9;
	padding: 12px 15px;
	vertical-align: middle;
}

table.table tr th:first-child {
	width: 60px;
}

table.table tr th:last-child {
	width: 100px;
}

table.table-striped tbody tr:nth-of-type(odd) {
	background-color: #fcfcfc;
}

table.table-striped.table-hover tbody tr:hover {
	background: #f5f5f5;
}

table.table th i {
	font-size: 13px;
	margin: 0 5px;
	cursor: pointer;
}

table.table td:last-child i {
	opacity: 0.9;
	font-size: 22px;
	margin: 0 5px;
}

table.table td a {
	font-weight: bold;
	color: #566787;
	display: inline-block;
	text-decoration: none;
	outline: none !important;
}

table.table td a:hover {
	color: #2196F3;
}

table.table td a.edit {
	color: #FFC107;
}

table.table td a.delete {
	color: #F44336;
}

table.table td i {
	font-size: 19px;
}

table.table .avatar {
	border-radius: 50%;
	vertical-align: middle;
	margin-right: 10px;
}

.pagination {
	float: right;
	margin: 0 0 5px;
}

.pagination li a {
	border: none;
	font-size: 13px;
	min-width: 30px;
	min-height: 30px;
	color: #999;
	margin: 0 2px;
	line-height: 30px;
	border-radius: 2px !important;
	text-align: center;
	padding: 0 6px;
}

.pagination li a:hover {
	color: #666;
}

.pagination li.active a, .pagination li.active a.page-link {
	background: #03A9F4;
}

.pagination li.active a:hover {
	background: #0397d6;
}

.pagination li.disabled i {
	color: #ccc;
}

.pagination li i {
	font-size: 16px;
	padding-top: 6px
}

.hint-text {
	float: left;
	margin-top: 10px;
	font-size: 13px;
}

/* Custom checkbox */
.custom-checkbox {
	position: relative;
}

.custom-checkbox input[type="checkbox"] {
	opacity: 0;
	position: absolute;
	margin: 5px 0 0 3px;
	z-index: 9;
}

.custom-checkbox label:before {
	width: 18px;
	height: 18px;
}

.custom-checkbox label:before {
	content: '';
	margin-right: 10px;
	display: inline-block;
	vertical-align: text-top;
	background: white;
	border: 1px solid #bbb;
	border-radius: 2px;
	box-sizing: border-box;
	z-index: 2;
}

.custom-checkbox input[type="checkbox"]:checked+label:after {
	content: '';
	position: absolute;
	left: 6px;
	top: 3px;
	width: 6px;
	height: 11px;
	border: solid #000;
	border-width: 0 3px 3px 0;
	transform: inherit;
	z-index: 3;
	transform: rotateZ(45deg);
}

.custom-checkbox input[type="checkbox"]:checked+label:before {
	border-color: #03A9F4;
	background: #03A9F4;
}

.custom-checkbox input[type="checkbox"]:checked+label:after {
	border-color: #fff;
}

.custom-checkbox input[type="checkbox"]:disabled+label:before {
	color: #b8b8b8;
	cursor: auto;
	box-shadow: none;
	background: #ddd;
}

/* Modal styles */
.modal .modal-dialog {
	max-width: 400px;
}

.modal .modal-header, .modal .modal-body, .modal .modal-footer {
	padding: 20px 30px;
}

.modal .modal-content {
	border-radius: 3px;
}

.modal .modal-footer {
	background: #ecf0f1;
	border-radius: 0 0 3px 3px;
}

.modal .modal-title {
	display: inline-block;
}

.modal .form-control {
	border-radius: 2px;
	box-shadow: none;
	border-color: #dddddd;
}

.modal textarea.form-control {
	resize: vertical;
}

.modal .btn {
	border-radius: 2px;
	min-width: 100px;
}

.modal form label {
	font-weight: normal;
}

body {
	background: #eee;
}

.card {
	border: none;
	position: relative;
	overflow: hidden;
	border-radius: 8px;
	cursor: pointer;
}

.card:before {
	content: "";
	position: absolute;
	left: 0;
	top: 0;
	width: 4px;
	height: 100%;
	background-color: #95b8ef;
	transform: scaleY(1);
	transition: all 0.5s;
	transform-origin: bottom
}

.card:after {
	content: "";
	position: absolute;
	left: 0;
	top: 0;
	width: 4px;
	height: 100%;
	background-color: green;
	transform: scaleY(0);
	transition: all 0.5s;
	transform-origin: bottom
}

.card:hover::after {
	transform: scaleY(1);
}

.fonts {
	font-size: 11px;
}

.social-list {
	display: flex;
	list-style: none;
	justify-content: center;
	padding: 0;
}

.social-list li {
	padding: 10px;
	color: #136dfa;
	font-size: 19px;
}

.buttons button:nth-child(1) {
	border: 1px solid #136dfa !important;
	color: #136dfa;
	height: 40px;
}

.buttons button:nth-child(1):hover {
	border: 1px solid #136dfa !important;
	color: #fff;
	height: 40px;
	background-color: #136dfa;
}

.buttons button:nth-child(2) {
	border: 1px solid #136dfa !important;
	background-color: #136dfa;
	color: #fff;
	height: 40px;
}
</style>
<script>
	$(document).ready(function() {
		// Activate tooltip
		$('[data-toggle="tooltip"]').tooltip();

		// Select/Deselect checkboxes
		var checkbox = $('table tbody input[type="checkbox"]');
		$("#selectAll").click(function() {
			if (this.checked) {
				checkbox.each(function() {
					this.checked = true;
				});
			} else {
				checkbox.each(function() {
					this.checked = false;
				});
			}
		});
		checkbox.click(function() {
			if (!this.checked) {
				$("#selectAll").prop("checked", false);
			}
		});
	});
</script>
</head>

<body>
	<div class="container mt-5 pt-5 pb-4 shadow">
		<h2>
			Welcome<b> ${user.name} !!!</b>
		</h2>
		<div class="text-end">
			<p>
				<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
					fill="currentColor" class="bi bi-envelope" viewBox="0 0 16 16">
<path
						d="M0 4a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v8a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V4Zm2-1a1 1 0 0 0-1 1v.217l7 4.2 7-4.2V4a1 1 0 0 0-1-1H2Zm13 2.383-4.708 2.825L15 11.105V5.383Zm-.034 6.876-5.64-3.471L8 9.583l-1.326-.795-5.64 3.47A1 1 0 0 0 2 13h12a1 1 0 0 0 .966-.741ZM1 11.105l4.708-2.897L1 5.383v5.722Z" />
</svg>
				&nbsp; <span class=""> ${user.email}</span>&nbsp;&nbsp; <a
					href="logout"><button class="btn btn-primary">Log Out</button></a>
			</p>
		</div>
		
		<c:forEach var="bidderList" items="${list}">
			<div class="shadow pb-3">
				<div class="table-title m-0 shadow mb-3 mt-5">
					<div class="row pt-4 pb-4">
						<div class="col-md-6">
							<%-- <h2 style="padding-top: 5px;">
								BID BY : <b>${BiddingData.name }</b>
							</h2> --%>
						</div>
						<div class="col-md-6">
							<!--   <button type="button" class="btn btn-primary btn-lg shadow fs-6" data-bs-toggle="collapse"
                    data-bs-target="#demo"><i
                    class="material-icons">&#xE147;</i><a href="getBiddingList"
                    class="text-white text-decoration-none">Show BID Details</a></button>  -->
							<!--     <button type="button" class="btn btn-primary btn-lg shadow fs-6" data-bs-toggle="collapse"
                    data-bs-target="#demo" style="margin-bottom:15px;"><i
                    class="material-icons">&#xE147;</i>Show BID Details</button>  -->
							<!--   <a href="getBiddingList"
                    class="text-white text-decoration-none">Show BID Details</a> -->
							<%-- 	<a href="raiseBid/${BiddingData.bidId}"
								class="text-white text-decoration-none"><button
									class="btn btn-success btn-lg shadow fs-6" data-toggle="modal">
									<i class="material-icons">&#xE147;</i>Raise Your BID
								</button></a> --%>

					<%-- 		<c:choose>
								<c:when test="${disableId==BiddingData.bidId}">

								</c:when>
								<c:otherwise>
									<a href="raiseBid/${BiddingData.bidId}"
										class="text-white text-decoration-none"><button
											class="btn btn-success btn-lg shadow fs-6"
											data-toggle="modal">
											<i class="material-icons">&#xE147;</i>Raise Your BID
										</button></a>

									<br />
								</c:otherwise>
							</c:choose> --%>

							

						</div>
					</div>
				</div>
				<div id="" class="">
					<table class="table table-striped table-hover fs-6 text-center">
						<thead>
							<tr class="fs-6">
								<!-- <th>
                    <span class="custom-checkbox">
                        <input type="checkbox" id="selectAll">
                        <label for="selectAll"></label>
                    </span>
                </th> -->

								<th>BID ID</th>
								<th></th>
								<th>BID AMOUNT</th>
								
								<th>WORK RANGE</th>
								<!-- <th>Closing Date</th>
								<th>Cost</th>
								<th>Your BID</th> -->
								<!--  <th>Bided By</th> -->
                <th>Actions</th> 

							</tr>
						</thead>
						<tbody>

							<tr>
								<!-- <td>
                        <span class="custom-checkbox">
                            <input type="checkbox" id="checkbox1" name="options[]" value="1">
                            <label for="checkbox1"></label>
                        </span>
                    </td> -->
								<td>${bidderList.bidId}</td>
								<!-- <td><a href="#" data-bs-toggle="collapse"
                        data-bs-target="#demo">See Owner Details</a></td> -->
								<td></td>
								<td>${bidderList.bidAmount}</td>
								<td>${bidderList.workRange}</td>
							<!-- 	
								<td><button class="btn btn-danger">
										<b>$${BiddingData.bidCost}</b>
									</button></td> -->
								<!--                         <td><a href="getBidderList">See Bidder List</a></td>
-->
								  <td>
                        <a href="editBidderBid/${bidderList.bidderId}" class="edit" data-toggle="modal"><i class="material-icons"
                                data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                        <a href="deleteBidderBid/${bidderList.bidderId}" class="delete" data-toggle="modal"><i class="material-icons"
                                data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                    </td>
							</tr>

						</tbody>
					</table>

				</div>
<%-- <%-- 				<a class="btn btn-primary m-3" data-bs-toggle="collapse"
					href="#demo" role="button" aria-expanded="false"
					aria-controls="collapseExample"> See Owner Details </a>
				<div class="collapse" id="demo">
					<div class="container text-white mb-5" id="">

						<div class="row d-flex justify-content-center">

							<div class="col-md-7">

								<div class="card p-3 py-4 shadow-lg"
									style="background-color: #435d7d;">



									<div class="text-center mt-3">
										<!-- <span class="bg-secondary p-1 px-4 rounded text-white">Pro</span> -->
										<h5 class="mt-2 mb-0">${BiddingData.name}</h5>
										<br> <span><svg xmlns="http://www.w3.org/2000/svg"
												width="16" height="16" fill="currentColor"
												class="bi bi-envelope" viewBox="0 0 16 16">
                            <path
													d="M0 4a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v8a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V4Zm2-1a1 1 0 0 0-1 1v.217l7 4.2 7-4.2V4a1 1 0 0 0-1-1H2Zm13 2.383-4.708 2.825L15 11.105V5.383Zm-.034 6.876-5.64-3.471L8 9.583l-1.326-.795-5.64 3.47A1 1 0 0 0 2 13h12a1 1 0 0 0 .966-.741ZM1 11.105l4.708-2.897L1 5.383v5.722Z" />
                            </svg> &nbsp; ${BiddingData.email}</span> <br> <br>
										<span><svg xmlns="http://www.w3.org/2000/svg"
												width="16" height="16" fill="currentColor"
												class="bi bi-telephone" viewBox="0 0 16 16">
                                <path
													d="M3.654 1.328a.678.678 0 0 0-1.015-.063L1.605 2.3c-.483.484-.661 1.169-.45 1.77a17.568 17.568 0 0 0 4.168 6.608 17.569 17.569 0 0 0 6.608 4.168c.601.211 1.286.033 1.77-.45l1.034-1.034a.678.678 0 0 0-.063-1.015l-2.307-1.794a.678.678 0 0 0-.58-.122l-2.19.547a1.745 1.745 0 0 1-1.657-.459L5.482 8.062a1.745 1.745 0 0 1-.46-1.657l.548-2.19a.678.678 0 0 0-.122-.58L3.654 1.328zM1.884.511a1.745 1.745 0 0 1 2.612.163L6.29 2.98c.329.423.445.974.315 1.494l-.547 2.19a.678.678 0 0 0 .178.643l2.457 2.457a.678.678 0 0 0 .644.178l2.189-.547a1.745 1.745 0 0 1 1.494.315l2.306 1.794c.829.645.905 1.87.163 2.611l-1.034 1.034c-.74.74-1.846 1.065-2.877.702a18.634 18.634 0 0 1-7.01-4.42 18.634 18.634 0 0 1-4.42-7.009c-.362-1.03-.037-2.137.703-2.877L1.885.511z" />
                              </svg>&nbsp; ${BiddingData.contact}</span> <br> <br>
										<span><svg xmlns="http://www.w3.org/2000/svg"
												width="16" height="16" fill="currentColor"
												class="bi bi-geo-alt-fill" viewBox="0 0 16 16">
                            <path
													d="M8 16s6-5.686 6-10A6 6 0 0 0 2 6c0 4.314 6 10 6 10zm0-7a3 3 0 1 1 0-6 3 3 0 0 1 0 6z" />
                          </svg>&nbsp; ${BiddingData.address}</span>


										<ul class="social-list">
											<li><i class="fa fa-facebook text-white"></i></li>
											<li><i class="fa fa-dribbble text-white"></i></li>
											<li><i class="fa fa-instagram text-white"></i></li>
											<li><i class="fa fa-linkedin text-white"></i></li>
											<li><i class="fa fa-google text-white"></i></li>
										</ul>

										<div class="b">

											<button class="btn btn-success px-4">Message</button>
											<button class="btn btn-success px-4 ms-3">Contact</button>
										</div>


									</div>




								</div>

							</div>

						</div>

					</div>
				</div> --%> 
			</div>
		</c:forEach>

		<!--     <div class="clearfix">
        <div class="hint-text">Showing <b>Bidding</b>  Entries</div>
        <ul class="pagination">
            <li class="page-item disabled"><a href="#">Previous</a></li>
            <li class="page-item"><a href="#" class="page-link">1</a></li>
            <li class="page-item"><a href="#" class="page-link">2</a></li>
            <li class="page-item active"><a href="#" class="page-link">3</a></li>
            <li class="page-item"><a href="#" class="page-link">4</a></li>
            <li class="page-item"><a href="#" class="page-link">5</a></li>
            <li class="page-item"><a href="#" class="page-link">Next</a></li>
        </ul>
    </div> -->
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js"
		integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk"
		crossorigin="anonymous">
		
	</script>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.min.js"
		integrity="sha384-ODmDIVzN+pFdexxHEHFBQH3/9/vQ9uori45z4JjnFsRydbmQbmL5t1tQ0culUzyK"
		crossorigin="anonymous">
		
	</script>
</body>

</html>