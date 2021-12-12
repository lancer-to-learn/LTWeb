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
		<!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->
		<div class="modal fade" id="portlet-config" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true"></button>
						<h4 class="modal-title">Modal title</h4>
					</div>
					<div class="modal-body">Widget settings form goes here</div>
					<div class="modal-footer">
						<button type="button" class="btn blue">Save changes</button>
						<button type="button" class="btn default" data-dismiss="modal">Close</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!-- /.modal -->
		<!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->
		<!-- BEGIN STYLE CUSTOMIZER -->
		<div class="theme-panel hidden-xs hidden-sm">
			<div class="toggler"></div>
			<div class="toggler-close"></div>
			<div class="theme-options">
				<div class="theme-option theme-colors clearfix">
					<span> THEME COLOR </span>
					<ul>
						<li class="color-default current tooltips" data-style="default"
							data-container="body" data-original-title="Default"></li>
						<li class="color-darkblue tooltips" data-style="darkblue"
							data-container="body" data-original-title="Dark Blue"></li>
						<li class="color-blue tooltips" data-style="blue"
							data-container="body" data-original-title="Blue"></li>
						<li class="color-grey tooltips" data-style="grey"
							data-container="body" data-original-title="Grey"></li>
						<li class="color-light tooltips" data-style="light"
							data-container="body" data-original-title="Light"></li>
						<li class="color-light2 tooltips" data-style="light2"
							data-container="body" data-html="true"
							data-original-title="Light 2"></li>
					</ul>
				</div>
				<div class="theme-option">
					<span> Layout </span> <select
						class="layout-option form-control input-sm">
						<option value="fluid" selected="selected">Fluid</option>
						<option value="boxed">Boxed</option>
					</select>
				</div>
				<div class="theme-option">
					<span> Header </span> <select
						class="page-header-option form-control input-sm">
						<option value="fixed" selected="selected">Fixed</option>
						<option value="default">Default</option>
					</select>
				</div>
				<div class="theme-option">
					<span> Top Menu Dropdown</span> <select
						class="page-header-top-dropdown-style-option form-control input-sm">
						<option value="light" selected="selected">Light</option>
						<option value="dark">Dark</option>
					</select>
				</div>
				<div class="theme-option">
					<span> Sidebar Mode</span> <select
						class="sidebar-option form-control input-sm">
						<option value="fixed">Fixed</option>
						<option value="default" selected="selected">Default</option>
					</select>
				</div>
				<div class="theme-option">
					<span> Sidebar Menu </span> <select
						class="sidebar-menu-option form-control input-sm">
						<option value="accordion" selected="selected">Accordion</option>
						<option value="hover">Hover</option>
					</select>
				</div>
				<div class="theme-option">
					<span> Sidebar Style </span> <select
						class="sidebar-style-option form-control input-sm">
						<option value="default" selected="selected">Default</option>
						<option value="light">Light</option>
					</select>
				</div>
				<div class="theme-option">
					<span> Sidebar Position </span> <select
						class="sidebar-pos-option form-control input-sm">
						<option value="left" selected="selected">Left</option>
						<option value="right">Right</option>
					</select>
				</div>
				<div class="theme-option">
					<span> Footer </span> <select
						class="page-footer-option form-control input-sm">
						<option value="fixed">Fixed</option>
						<option value="default" selected="selected">Default</option>
					</select>
				</div>
			</div>
		</div>
		<!-- END STYLE CUSTOMIZER -->
		<!-- BEGIN PAGE HEADER-->
		<h3 class="page-title">
			Product Edit <small>create & edit product</small>
		</h3>
		<div class="page-bar">
			<ul class="page-breadcrumb">
				<li><i class="fa fa-home"></i> <a href="index.html">Home</a> <i
					class="fa fa-angle-right"></i></li>
				<li><a href="#">eCommerce</a> <i class="fa fa-angle-right"></i>
				</li>
				<li><a href="#">Product Custom</a></li>
			</ul>
		</div>
		<!-- END PAGE HEADER-->
		<!-- BEGIN PAGE CONTENT-->
		<div class="row">
			<div class="col-md-12">
				<form class="form-horizontal form-row-seperated" action="#">
					<div class="portlet">
						<div class="portlet-title">
							<div class="caption">
								<i class="fa fa-shopping-cart"></i>Custom Product
							</div>
							<div class="actions btn-set">
								<button type="button" name="back" class="btn default">
									<i class="fa fa-angle-left"></i> Back
								</button>
								<button class="btn default">
									<i class="fa fa-reply"></i> Reset
								</button>
								<button class="btn green">
									<i class="fa fa-check"></i> Save
								</button>
								<button class="btn green">
									<i class="fa fa-check-circle"></i> Save & Continue Edit
								</button>
							</div>
						</div>
						<div class="portlet-body">
							<div class="tabbable">
								<ul class="nav nav-tabs">
									<li class="active"><a href="#tab_general"
										data-toggle="tab"> General </a></li>
									<li><a href="#tab_meta" data-toggle="tab"> Detail </a></li>

								</ul>
								<div class="tab-content no-space">
									<div class="tab-pane active" id="tab_general">
										<div class="form-body">
											<div class="form-group">
												<label class="col-md-2 control-label">Name: <span
													class="required"> * </span>
												</label>
												<div class="col-md-10">
													<input type="text" class="form-control" value=""
														name="name" placeholder="Enter product's name">
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-2 control-label">Price: <span
													class="required"> * </span>
												</label>
												<div class="col-md-10">
													<input type="text" class="form-control" value=""
														name="price" placeholder="Enter product's price">
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-2 control-label">Brand: <span
													class="required"> * </span>
												</label>
												<div class="col-md-10">
													<select
														class="table-group-action-input form-control input-medium"
														name="brand">
														<option value="">Select...</option>
														<option value="1">None</option>
														<option value="0">Taxable Goods</option>
														<option value="0">Shipping</option>
														<option value="0">USA</option>
													</select>
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-2 control-label">Amount: <span
													class="required"> * </span>
												</label>
												<div class="col-md-10">
													<input type="text" class="form-control" value=""
														name="amount" placeholder="Enter product's amount">
												</div>
											</div>
											<div class="form-group">
									<label class="col-md-2 control-label">Image:
										<span class="require">*</span>
									</label>
									<div class="col-lg-8">
										<input type="file" id="image" name="image"  value="" required>
									</div>
								</div>
										</div>
									</div>
									<div class="tab-pane" id="tab_meta">
										<div class="form-body">
											<div class="form-group">
												<label class="col-md-2 control-label">Screen: <span
													class="required"> * </span>
												</label>
												<div class="col-md-10">
													<input type="text" class="form-control" value=""
														name="screen" placeholder="Enter product's screen">
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-2 control-label">OS: <span
													class="required"> * </span>
												</label>
												<div class="col-md-10">
													<input type="text" class="form-control" value=""
														name="os" placeholder="Enter product's OS">
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-2 control-label">Chip: <span
													class="required"> * </span>
												</label>
												<div class="col-md-10">
													<input type="text" class="form-control" value=""
														name="chip" placeholder="Enter product's chip">
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-2 control-label">RAM: <span
													class="required"> * </span>
												</label>
												<div class="col-md-10">
													<input type="text" class="form-control" value=""
														name="ram" placeholder="Enter product's RAM">
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-2 control-label">ROM: <span
													class="required"> * </span>
												</label>
												<div class="col-md-10">
													<input type="text" class="form-control" value=""
														name="rom" placeholder="Enter product's ROM">
												</div>
											</div>
											<div class="form-group">
												<label class="col-md-2 control-label">Weight: <span
													class="required"> * </span>
												</label>
												<div class="col-md-10">
													<input type="text" class="form-control"
														name="weight" placeholder="Enter product's weight">
												</div>
											</div>
										
											<div class="form-group">
												<label class="col-md-2 control-label">Description:</label>
												<div class="col-md-10">
													<textarea class="form-control maxlength-handler" rows="8" 
														name="description" maxlength="1000"></textarea>
													<span class="help-block"> max 1000 chars </span>
												</div>
											</div>
										<div class="form-group">
												<label class="col-md-2 control-label">Warranty: <span
													class="required"> * </span>
												</label>
												<div class="col-md-10">
													<input type="text" class="form-control" value=""
														name="warranty" placeholder="Enter time warranty">
												</div>
											</div>
										
										</div>
									</div>
									<div class="table-container"></div>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>

		</div>

	</div>
	<!-- END PAGE CONTENT-->
</div>
<!-- END CONTAINER -->