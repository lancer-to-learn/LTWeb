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
				<li class="start "><a href="javascript:;"> <i
						class="icon-home"></i> <span class="title">Quản lý đơn hàng</span>
						<span class="arrow "></span>
				</a>
					<ul class="sub-menu">
						<li><a href="index.html"> <i class="icon-bar-chart"></i>
								Tất cả
						</a></li>
						<li><a href="index_2.html"> <i class="icon-bulb"></i> Đơn
								hủy
						</a></li>
						<li><a href="index_2.html"> <i class="icon-bulb"></i> Trả
								hàng/Hoàn tiền
						</a></li>

					</ul></li>
				<li class="start "><a href="javascript:;"> <i
						class="icon-home"></i> <span class="title">Quản lý sản phẩm</span>
						<span class="arrow "></span>
				</a>
					<ul class="sub-menu">
						<li><a href="index.html"> <i class="icon-bar-chart"></i>
								Thêm sản phẩm
						</a></li>
						<li><a href="index_2.html"> <i class="icon-bulb"></i>
								Danh sách sản phẩm
						</a></li>

					</ul></li>
				<li class="start "><a href="javascript:;"> <i
						class="icon-home"></i> <span class="title">Doanh thu</span> <span
						class="arrow "></span>
				</a>
					<ul class="sub-menu">
						<li><a href="index.html"> <i class="icon-bar-chart"></i>
								Tháng
						</a></li>
						<li><a href="index_2.html"> <i class="icon-bulb"></i> Năm
						</a></li>

					</ul></li>
			</ul>
			<!-- END SIDEBAR MENU -->
		</div>
	</div>
	<!-- END SIDEBAR -->
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
					<li><i class="fa fa-home"></i> <a href="index.html">Home</a> <i
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