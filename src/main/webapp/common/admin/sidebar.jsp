<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

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
				<!-- DOC: Apply "sidebar-search-bordered" class the below search form to have bordered & solid search box -->
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
			<li class="start "><a
				href="${pageContext.request.contextPath}/admin"> <i
					class="icon-home"></i> Home
			</a></li>
			<li class="start "><a href="javascript:;"> <i
					class="icon-home"></i> <span class="title">Brand Manager</span> <span
					class="arrow "></span>
			</a>
				<ul class="sub-menu">
					<li><a
						href="${pageContext.request.contextPath}/admin/list-brand"> <i
							class="icon-bar-chart"></i> Brand List
					</a></li>
					<li><a
						href="${pageContext.request.contextPath}/admin/custom-brand">
							<i class="icon-bulb"></i> Add Brand
					</a></li>
				</ul></li>
			<li class="start"><a href="javascript:;"> <i
					class="icon-home"></i> <span class="title">Product Manager</span> <span
					class="arrow "></span>
			</a>
				<ul class="sub-menu">
					<li><a
						href="${pageContext.request.contextPath}/admin/list-product">
							<i class="icon-bar-chart"></i> List Product
					</a></li>
					<li><a
						href="${pageContext.request.contextPath}/admin/custom-product">
							<i class="icon-bulb"></i> Add Product
					</a></li>
				</ul></li>
			<li class="start "><a href="javascript:;"> <i
					class="icon-home"></i> <span class="title">Order Manager</span> <span
					class="arrow "></span>
			</a>
				<ul class="sub-menu">
					<li><a href="${pageContext.request.contextPath}/admin/order">
							<i class="icon-bar-chart"></i> List Order
					</a></li>
					<li><a href="${pageContext.request.contextPath}/admin/order">
							<i class="icon-bulb"></i> Canceled Order
					</a></li>
				</ul></li>
			<li class="start "><a href="javascript:;"> <i
					class="icon-home"></i> <span class="title">Shipping</span> <span
					class="arrow "></span>
			</a>
				<ul class="sub-menu">
					<li><a
						href="${pageContext.request.contextPath}/admin/list-city"> <i
							class="icon-bar-chart"></i> List City
					</a></li>
					<li><a
						href="${pageContext.request.contextPath}/admin/custom-city"> <i
							class="icon-bulb"></i> Add City
					</a></li>
				</ul></li>
			<li class="start "><a href=""> <i class="icon-home"></i> <span
					class="title">Income</span> <span class="arrow "></span>
			</a>
				<ul class="sub-menu">
					<li><a
						href="${pageContext.request.contextPath}/admin/stats-month"> <i
							class="icon-bar-chart"></i> Brand
					</a></li>
					<li><a
						href="${pageContext.request.contextPath}/admin/stats-year"> <i
							class="icon-bulb"></i> Month & Year
					</a></li>


				</ul></li>

		</ul>

		<!-- END SIDEBAR MENU -->
	</div>
</div>
<!-- END SIDEBAR -->