<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div class="clearfix"></div>
<!-- BEGIN CONTAINER -->
<div class="page-container">
	<!-- BEGIN SIDEBAR -->
	<div class="page-sidebar-wrapper">
		<!-- DOC: Set data-auto-scroll="false" to disable the sidebar from auto scrolling/focusing -->
		<!-- DOC: Change data-auto-speed="200" to adjust the sub menu slide up/down speed -->
		<div class="page-sidebar navbar-collapse collapse">
			<!-- BEGIN SIDEBAR MENU -->
			<ul class="page-sidebar-menu" data-keep-expanded="false"
				data-auto-scroll="true" data-slide-speed="200">
				<!-- DOC: To remove the sidebar toggler from the sidebar you just need to completely remove the below "sidebar-toggler-wrapper" LI element -->
				<li class="sidebar-toggler-wrapper">
					<!-- BEGIN SIDEBAR TOGGLER BUTTON -->
					<div class="sidebar-toggler"></div> <!-- END SIDEBAR TOGGLER BUTTON -->
				</li>
				<!-- DOC: To remove the search box from the sidebar you just need to completely remove the below "sidebar-search-wrapper" LI element -->
				<li class="sidebar-search-wrapper">
					<!-- BEGIN RESPONSIVE QUICK SEARCH FORM --> <!-- DOC: Apply "sidebar-search-bordered" class the below search form to have bordered search box -->
					<!-- DOC: Apply "sidebar-search-bordered sidebar-search-solid" class the below search form to have bordered & solid search box -->
					<form class="sidebar-search " action="#" method="POST">
						<a href="javascript:;" class="remove"> <i class="icon-close"></i>
						</a>
						<div class="input-group">
							<input type="text" class="form-control" placeholder="Search...">
							<span class="input-group-btn"> <a href="javascript:;"
								class="btn submit"><i class="icon-magnifier"></i></a>
							</span>
						</div>
					</form> <!-- END RESPONSIVE QUICK SEARCH FORM -->
				</li>
				<li class="start "><a href="admin"> <i
						class="icon-home"></i> Home</a>
				</li>
				<li class="start "><a href="javascript:;"> <i
						class="icon-home"></i> <span class="title">Brand Manager</span> <span
						class="arrow "></span>
				</a>
					<ul class="sub-menu">
						<li><a href="${pageContext.request.contextPath}/admin/list-brand"> <i class="icon-bar-chart"></i>
								Brand List
						</a></li>
						<li><a href="${pageContext.request.contextPath}/admin/custom-brand"> <i class="icon-bulb"></i>
								Add Brand
						</a></li>					
					</ul>
					</li>
				<li class="start"><a href="javascript:;"> <i
						class="icon-home"></i> <span class="title">Product Manager</span> <span
						class="arrow "></span>
				</a>
					<ul class="sub-menu">
						<li><a href="${pageContext.request.contextPath}/admin/list-product"> <i class="icon-bar-chart"></i>
								List Product
						</a></li>
						<li><a href="${pageContext.request.contextPath}/admin/custom"> <i class="icon-bulb"></i>
								Add Product
						</a></li>
					</ul></li>
				<li class="start "><a href="javascript:;"> <i
						class="icon-home"></i> <span class="title">Order Manager</span> <span
						class="arrow "></span>
				</a>
					<ul class="sub-menu">
						<li><a href="${pageContext.request.contextPath}/admin/order"> <i class="icon-bar-chart"></i>
								List Order
						</a></li>
						<li><a href="${pageContext.request.contextPath}/admin/order"> <i class="icon-bulb"></i>
								Canceled Order
						</a></li>
					</ul></li>
					<li class="start "><a href="javascript:;"> <i
						class="icon-home"></i> <span class="title">Shipping</span> <span
						class="arrow "></span>
				</a>
					<ul class="sub-menu">
						<li><a href="${pageContext.request.contextPath}/admin/list-city"> <i class="icon-bar-chart"></i>
								List City
						</a></li>
						<li><a href="${pageContext.request.contextPath}/admin/custom-city"> <i class="icon-bulb"></i>
								Add City
						</a></li>
					</ul></li>
					<li class="start "><a href="javascript:;"> <i
						class="icon-home"></i> <span class="title">Income</span> <span
						class="arrow "></span>
				</a>
					<ul class="sub-menu">
						<li><a href="${pageContext.request.contextPath}/admin/stats-month"> <i class="icon-bar-chart"></i>
								Month
						</a></li>
						<li><a href="${pageContext.request.contextPath}/admin/stats-year"> <i class="icon-bulb"></i>
								Year
						</a></li>

						
					</ul>
					</li>
				
			</ul>

			<!-- END SIDEBAR MENU -->
		</div>
	</div>
	<!-- END SIDEBAR -->
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
			<div class="col-md-9 col-sm-9">
				<div class="content-form-page">
					<div class="row">
						<div class="col-md-7 col-sm-7">

							<form action="signup" method="post" id="formLogin" enctype="multipart/form-data"
								class="form-horizontal form-without-legend" role="form">
								<div class="form-group">
									<label for="email" class="col-lg-4 control-label">Brand Name:
										<span class="require">*</span>
									</label>
									<div class="col-lg-8">
										<input type="text" class="form-control" id="brandname"
											name="brandname" class="form-control" placeholder="Brand Name"
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
			
			<!-- END PAGE CONTENT-->
		</div>
	</div>
	<!-- END NT -->

</div>
<!-- END CONTAINER -->