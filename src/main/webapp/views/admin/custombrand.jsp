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
				Brand Edit <small>create & edit brand</small>
			</h3>
			<div class="page-bar">
				<ul class="page-breadcrumb">
					<li><i class="fa fa-home"></i> <a href="admin">Admin</a> <i
						class="fa fa-angle-right"></i></li>
					<li><a href="admin/list-brand">Brand</a> <i class="fa fa-angle-right"></i>
					</li>
					<li><a href="admin/custom-brand">Custom Brand</a></li>
				</ul>
			</div>
			<div class="portlet-title">
				<div class="caption">
					<i class="fa fa-shopping-cart"></i>Custom Brand
				</div>
			</div>

			<!-- END PAGE HEADER-->
			<!-- BEGIN PAGE CONTENT-->
			<c:choose>
			<c:when test="${not empty brand}">
			<div class="col-md-9 col-sm-9">
				<div class="content-form-page">
					<div class="row">
						<div class="col-md-7 col-sm-7">

							<form action="${pageContext.request.contextPath}/admin/edit/list-brand" method="post" id="formLogin" enctype="multipart/form-data"
								class="form-horizontal form-without-legend" role="form">
								<div class="form-group">
									<label for="id" class="col-lg-4 control-label">Brand ID:
										<span class="require">*</span>
									</label>
									<div class="col-lg-8">
										<input type="number" class="form-control" id="brandid"
											name="brandid" placeholder="Brand ID"
											required value = "${brand.bId}" readonly>
									</div>
								</div>
								
								<div class="form-group">
									<label for="email" class="col-lg-4 control-label">Brand Name:
										<span class="require">*</span>
									</label>
									<div class="col-lg-8">
										<input type="text" class="form-control" id="brandname"
											name="brandname" placeholder="Brand Name"
											required autofocus value = "${brand.bName}">
									</div>
								</div>

								<div class="form-group">
									<label for="text" class="col-lg-4 control-label">Image
									</label>
									<div class="col-lg-8">
										<input type="file" id="image" name="image" value = "${brand.bImage}">
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

							<form action="${pageContext.request.contextPath}/admin/insert/list-brand" method="post" id="formLogin" enctype="multipart/form-data"
								class="form-horizontal form-without-legend" role="form">
								<div class="form-group">
									<label for="email" class="col-lg-4 control-label">Brand Name:
										<span class="require">*</span>
									</label>
									<div class="col-lg-8">
										<input type="text" class="form-control" id="brandname"
											name="brandname" placeholder="Brand Name"
											required autofocus>
									</div>
								</div>

								
								<div class="form-group">
									<label for="text" class="col-lg-4 control-label">Image
										<span class="require">*</span>
									</label>
									<div class="col-lg-8">
										<input type="file" id="image" name="image" required>
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
	<!-- END NT -->

</div>
<!-- END CONTAINER -->