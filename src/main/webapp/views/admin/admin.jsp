<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div class="clearfix"></div>
<!-- BEGIN CONTAINER -->
<div class="page-container">
	 <c:if test="${ sessionScope.acc.getRole()==1 }"><li><%@include file = "/common/admin/sidebar.jsp" %></li></c:if>
	  <c:if test="${ sessionScope.acc.getRole()==2 }"><li><%@include file = "/common/seller/sidebar.jsp" %></li></c:if>
		
	<!-- BEGIN CONTENT -->
	<div class="page-content-wrapper">
		<div class="page-content">


			<!-- BEGIN PAGE HEADER-->
			<!-- END PAGE HEADER-->
			<!-- BEGIN PAGE CONTENT-->
			<h3 class="page-title">
				Dashboard <small>reports & statistics</small>
			</h3>
			<div class="page-bar">
				<ul class="page-breadcrumb">
					<li><i class="fa fa-home"></i> <a href="${pageContext.request.contextPath}/admin">Home</a> <i
						class="fa fa-angle-right"></i></li>
					<li><a href="#">Dashboard</a></li>
				</ul>
				<div class="page-toolbar">
					<div id="dashboard-report-range"
						class="pull-right tooltips btn btn-fit-height grey-salt"
						data-placement="top"
						data-original-title="Change dashboard date range">
						<i class="icon-calendar"></i>&nbsp; <span
							class="thin uppercase visible-lg-inline-block">&nbsp;</span>&nbsp;
						<i class="fa fa-angle-down"></i>
					</div>
				</div>
			</div>
			<!-- END PAGE HEADER-->
			<!-- BEGIN DASHBOARD STATS -->
			<div class="row">
				<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
					<div class="dashboard-stat blue-madison">
						<div class="visual">
							<i class="fa fa-comments"></i>
						</div>
						<div class="details">
							<div class="number">1349</div>
							<div class="desc">New Feedbacks</div>
						</div>
						<a class="more" href="#"> View more <i
							class="m-icon-swapright m-icon-white"></i>
						</a>
					</div>
				</div>
				<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
					<div class="dashboard-stat red-intense">
						<div class="visual">
							<i class="fa fa-bar-chart-o"></i>
						</div>
						<div class="details">
							<div class="number">12,5M$</div>
							<div class="desc">Total Profit</div>
						</div>
						<a class="more" href="#"> View more <i
							class="m-icon-swapright m-icon-white"></i>
						</a>
					</div>
				</div>
				<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
					<div class="dashboard-stat green-haze">
						<div class="visual">
							<i class="fa fa-shopping-cart"></i>
						</div>
						<div class="details">
							<div class="number">549</div>
							<div class="desc">New Orders</div>
						</div>
						<a class="more" href="#"> View more <i
							class="m-icon-swapright m-icon-white"></i>
						</a>
					</div>
				</div>
				<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
					<div class="dashboard-stat purple-plum">
						<div class="visual">
							<i class="fa fa-globe"></i>
						</div>
						<div class="details">
							<div class="number">+89%</div>
							<div class="desc">Brand Popularity</div>
						</div>
						<a class="more" href="#"> View more <i
							class="m-icon-swapright m-icon-white"></i>
						</a>
					</div>
				</div>
			</div>
			<!-- END PAGE CONTENT-->
		</div>
	</div>
	<!-- END CONTENT -->

</div>
<!-- END CONTAINER -->