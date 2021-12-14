<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div class="clearfix"></div>
<!-- BEGIN CONTAINER -->
<div class="page-container">
	
	<%@include file = "/common/admin/sidebar.jsp" %> 
		
	<!-- BEGIN CONTENT -->
	<div class="page-content-wrapper">
		<div class="page-content">


			<!-- BEGIN PAGE HEADER-->
			<h3 class="page-title">
				Ship Edit <small>create & edit ship</small>
			</h3>
			<div class="page-bar">
				<ul class="page-breadcrumb">
					<li><i class="fa fa-home"></i> <a href="admin">Admin</a> <i
						class="fa fa-angle-right"></i></li>
					<li><a href="admin/list-city">Ship</a> <i class="fa fa-angle-right"></i>
					</li>
					<li><a href="custom-city">Custom City</a></li>
				</ul>
			</div>
			<div class="portlet-title">
				<div class="caption">
					<i class="fa fa-shopping-cart"></i>Custom City
				</div>
			</div>

			<!-- END PAGE HEADER-->
			<!-- BEGIN PAGE CONTENT-->
			<c:choose>
			<c:when test="${not empty ship}">
			<div class="col-md-9 col-sm-9">
				<div class="content-form-page">
					<div class="row">
						<div class="col-md-7 col-sm-7">

							<form action="${pageContext.request.contextPath}/admin/edit/list-city" method="post" id="formLogin"
								class="form-horizontal form-without-legend" role="form">
								<div class="form-group">
									<label class="col-lg-4 control-label">City ID:
										<span class="require">*</span>
									</label>
									<div class="col-lg-8">
										<input type="number" class="form-control" id="cityid"
											name="cityid" class="form-control" placeholder="City ID"
											required autofocus value = "${ship.sId}" readonly>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-lg-4 control-label">City Name:
										<span class="require">*</span>
									</label>
									<div class="col-lg-8">
										<input type="text" class="form-control" id="cityname"
											name="cityname" class="form-control" placeholder="City Name"
											required autofocus value = "${ship.sName}">
									</div>
								</div>
								<div class="form-group">
									<label class="col-lg-4 control-label">Ship Price:
										<span class="require">*</span>
									</label>
									<div class="col-lg-8">
										<input type="text" class="form-control" id="shipprice"
											name="shipprice" class="form-control" placeholder="Ship Price"
											required autofocus value = "${ship.sPrice}">
									</div>
								</div>
								<div class="form-group">
									<label class="col-lg-4 control-label">Ship Time:
										<span class="require">*</span>
									</label>
									<div class="col-lg-8">
										<input type="text" class="form-control" id="shiptime"
											name="shiptime" class="form-control" placeholder="Ship Time"
											required autofocus value = "${ship.sTime}"> <span>Days</span>
									</div>
								</div>
								<div class="row">
									<div
										class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-20">
										<button type="submit" class="btn btn-primary">Save</button>
									</div>
								</div>

							</form>
						</div>
						
					</div>
				</div>
			</div>
			</c:when>
			<c:otherwise>
				<div class="col-md-9 col-sm-9">
				<div class="content-form-page">
					<div class="row">
						<div class="col-md-7 col-sm-7">

							<form action="${pageContext.request.contextPath}/admin/insert/list-city" method="post" id="formLogin"
								class="form-horizontal form-without-legend" role="form">
								<div class="form-group">
									<label class="col-lg-4 control-label">City Name:
										<span class="require">*</span>
									</label>
									<div class="col-lg-8">
										<input type="text" class="form-control" id="cityname"
											name="cityname" class="form-control" placeholder="City Name"
											required autofocus>
									</div>
								</div>
								<div class="form-group">
									<label class="col-lg-4 control-label">Ship Price:
										<span class="require">*</span>
									</label>
									<div class="col-lg-8">
										<input type="number" class="form-control" id="shipprice"
											name="shipprice" class="form-control" placeholder="Ship Price"
											required autofocus>
									</div>
								</div>
								<div class="form-group">
									<label class="col-lg-4 control-label">Ship Time:
										<span class="require">*</span>
									</label>
									<div class="col-lg-8">
										<input type="number" class="form-control" id="shiptime"
											name="shiptime" class="form-control" placeholder="Ship Time"
											required autofocus> <span>Days</span>
									</div>
								</div>
								<div class="row">
									<div
										class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-20">
										<button type="submit" class="btn btn-primary">Save</button>
									</div>
								</div>

							</form>
						</div>
						
					</div>
				</div>
			</div>
			</c:otherwise>
			</c:choose>
			<!-- END PAGE CONTENT-->
		</div>
	</div>
	<!-- END CONTENT -->

</div>
<!-- END CONTAINER -->