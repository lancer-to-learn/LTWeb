<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div class="clearfix"></div>

	<c:if test="${ sessionScope.acc.getRole()==1 }"><li><%@include file = "/common/admin/sidebar.jsp" %></li></c:if>
	  <c:if test="${ sessionScope.acc.getRole()==2 }"><li><%@include file = "/common/seller/sidebar.jsp" %></li></c:if>min/sidebar.jsp" %> 


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
