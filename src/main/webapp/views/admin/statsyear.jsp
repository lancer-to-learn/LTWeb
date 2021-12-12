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
				Income 
			</h3>
			<div class="page-bar">
				<ul class="page-breadcrumb">
					<li><i class="fa fa-home"></i> <a href="admin">Admin</a> <i
						class="fa fa-angle-right"></i></li>
					<li><a href="admin/list-brand">Income</a> <i class="fa fa-angle-right"></i>
					</li>
					<li><a href="admin/custom-brand">Month</a></li>
				</ul>
			</div>
			

			<!-- END PAGE HEADER-->
			<div class="row">
						<div class="col-md-12">
							<!-- BEGIN CHART PORTLET-->
							<div class="portlet light bordered">
								<div class="portlet-title">
									<div class="caption">
										<i class="icon-bar-chart font-green-haze"></i>
										<span class="caption-subject bold uppercase font-green-haze"> 3D Chart</span>
										<span class="caption-helper">3d cylinder chart</span>
									</div>
									<div class="tools">
										<a href="javascript:;" class="collapse">
										</a>
										<a href="#portlet-config" data-toggle="modal" class="config">
										</a>
										<a href="javascript:;" class="reload">
										</a>
										<a href="javascript:;" class="fullscreen">
										</a>
										<a href="javascript:;" class="remove">
										</a>
									</div>
								</div>
								<div class="portlet-body">
									<div id="chart_5" class="chart" style="height: 400px;">
									</div>
									<div class="well margin-top-20">
										<div class="row">
											<div class="col-sm-3">
												<label class="text-left">Top Radius:</label>
												<input class="chart_5_chart_input" data-property="topRadius" type="range" min="0" max="1.5" value="1" step="0.01"/>
											</div>
											<div class="col-sm-3">
												<label class="text-left">Angle:</label>
												<input class="chart_5_chart_input" data-property="angle" type="range" min="0" max="89" value="30" step="1"/>
											</div>
											<div class="col-sm-3">
												<label class="text-left">Depth:</label>
												<input class="chart_5_chart_input" data-property="depth3D" type="range" min="1" max="120" value="40" step="1"/>
											</div>
										</div>
									</div>
								</div>
							</div>
							<!-- END CHART PORTLET-->
						</div>
					</div>
			<!-- BEGIN PAGE CONTENT-->
			
			<!-- END PAGE CONTENT-->
		</div>
	</div>
	<!-- END CONTENT -->

</div>
<!-- END CONTAINER -->
