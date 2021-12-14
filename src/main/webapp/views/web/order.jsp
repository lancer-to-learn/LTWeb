<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div class="page-container">
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
				Order View <small>view order details</small>
			</h3>
			<div class="page-bar">
				<ul class="page-breadcrumb">
					<li><i class="fa fa-home"></i> <a href="index.html">Home</a> <i
						class="fa fa-angle-right"></i></li>
					<li><a href="#">eCommerce</a> <i class="fa fa-angle-right"></i>
					</li>
					<li><a href="#">Order View</a></li>
				</ul>
				<div class="page-toolbar">
					<div class="btn-group pull-right">
						<button type="button"
							class="btn btn-fit-height grey-salt dropdown-toggle"
							data-toggle="dropdown" data-hover="dropdown" data-delay="1000"
							data-close-others="true">
							Actions <i class="fa fa-angle-down"></i>
						</button>
						<ul class="dropdown-menu pull-right" role="menu">
							<li><a href="#">Action</a></li>
							<li><a href="#">Another action</a></li>
							<li><a href="#">Something else here</a></li>
							<li class="divider"></li>
							<li><a href="#">Separated link</a></li>
						</ul>
					</div>
				</div>
			</div>
			<!-- END PAGE HEADER-->
			<!-- BEGIN PAGE CONTENT-->
			<div class="row">
				<div class="col-md-12">
					<!-- Begin: life time stats -->
					<div class="portlet">
						<div class="portlet-title">
							<div class="caption">
								<i class="fa fa-shopping-cart"></i>Order #12313232 <span
									class="hidden-480"> | Dec 27, 2013 7:16:25 </span>
							</div>
							<div class="actions">
								<a href="#" class="btn default yellow-stripe"> <i
									class="fa fa-angle-left"></i> <span class="hidden-480">
										Back </span>
								</a>
								<div class="btn-group">
									<a class="btn default yellow-stripe dropdown-toggle" href="#"
										data-toggle="dropdown"> <i class="fa fa-cog"></i> <span
										class="hidden-480"> Tools </span> <i class="fa fa-angle-down"></i>
									</a>
									<ul class="dropdown-menu pull-right">
										<li><a href="#"> Export to Excel </a></li>
										<li><a href="#"> Export to CSV </a></li>
										<li><a href="#"> Export to XML </a></li>
										<li class="divider"></li>
										<li><a href="#"> Print Invoice </a></li>
									</ul>
								</div>
							</div>
						</div>
						<div class="portlet-body">
							<div class="tabbable">
								<ul class="nav nav-tabs nav-tabs-lg">
									<li class="active"><a href="#tab_1" data-toggle="tab">
											All <span
											class="badge badge-success"> ${ quantity.allQuantity } </span></a></li>
									<li><a href="#tab_2" data-toggle="tab"> Bought <span
											class="badge badge-success"> ${ quantity.soldQuantity } </span>
									</a></li>
									<li><a href="#tab_3" data-toggle="tab"> Pending <span
											class="badge badge-danger"> ${ quantity.waitingQuantity } </span></a></li>
									<li><a href="#tab_4" data-toggle="tab"> Shipping <span
											class="badge badge-danger"> ${ quantity.shippingQuantity } </span>
									</a></li>
									<li><a href="#tab_5" data-toggle="tab"> Canceled <span
											class="badge badge-danger"> ${ quantity.canceledQuantity } </span></a></li>
								</ul>
								<div class="tab-content">
									<div class="tab-pane active" id="tab_1">
										<div class="row">
											<div class="col-md-12 col-sm-12">
												<div class="portlet grey-cascade box">
													<div class="portlet-title">
														<div class="caption">
															<i class="fa fa-cogs"></i>All Orders
														</div>
														<div class="actions">
															<a href="#" class="btn btn-default btn-sm"> <i
																class="fa fa-pencil"></i> Edit
															</a>
														</div>
													</div>
													<div class="portlet-body">
														<div class="table-responsive">
															<table
																class="table table-striped table-bordered table-hover"
																id="datatable_products">
																<thead>
																	<tr role="row" class="heading">
																		<th width="5%">ID</th>
																		<th width="15%">Product&nbsp;Name</th>
																		<th width="10%">Image</th>
																		<th width="10%">Price</th>
																		<th width="5%">Quantity</th>
																		<th width="10%">Total</th>
																		<th width="10%">Date Create</th>
																		<th width="10%">Status</th>
																	</tr>
																	
																	<c:forEach items="${ listDetail }" var="re">
																		<tr role="row" class="filter">
																			<td>${ re.rdId }</td>
																			<td><a href="productdetail?${ re.product.pId }">${ re.product.pName }</a></td>
																			<td><a
																				href="productdetail?pid=${ re.product.pId }"
																				class="fancybox-button" data-rel="fancybox-button">
																					<img class="img-responsive"
																					src="${ re.product.pImage }"
																					alt="${ re.product.pName }"
																					style="width: 50px; height: 50px;">
																			</a></td>
																			<td>${ re.price }</td>
																			<td>${ re.quantity }</td>
																			<td>${ re.price * re.quantity}</td>
																			<td>${ re.receipt.date }</td>
																			<c:if test="${ re.status=='Sold' }">
																			<td><a href="#tab_2" data-toggle="tab"> ${ re.status }</a></td>
																			</c:if>
																			<c:if test="${ re.status=='Waiting'}">
																			<td><a href="#tab_3" data-toggle="tab"> ${ re.status }</a></td>
																			</c:if>
																			<c:if test="${ re.status=='Shipping' }">
																			<td><a href="#tab_4" data-toggle="tab"> ${ re.status }</a></td>
																			</c:if>
																			<c:if test="${ re.status=='Canceled' }">
																			<td><a href="#tab_5" data-toggle="tab"> ${ re.status }</a></td>
																			</c:if>
																		</tr>
																	</c:forEach>
																	
																</thead>
																<tbody>
																</tbody>
															</table>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-6"></div>
											<div class="col-md-6">
												<div class="well">
													<div class="row static-info align-reverse">
														<div class="col-md-8 name">Total Order:</div>
														<div class="col-md-3 value">${ quantity.allQuantity }</div>
													</div>
													<div class="row static-info align-reverse">
														<div class="col-md-8 name">Total Money: </div>
														<div class="col-md-3 value">${ total.allTotal } $</div>
													</div>
												</div>
											</div>
										</div>
									</div>
									<div class="tab-pane" id="tab_2">
										<div class="row">
											<div class="col-md-12 col-sm-12">
												<div class="portlet grey-cascade box">
													<div class="portlet-title">
														<div class="caption">
															<i class="fa fa-cogs"></i>Bought Oders
														</div>
														<div class="actions">
															<a href="#" class="btn btn-default btn-sm"> <i
																class="fa fa-pencil"></i> Edit
															</a>
														</div>
													</div>
													<div class="portlet-body">
														<div class="table-responsive">
															<table
																class="table table-striped table-bordered table-hover"
																id="datatable_products">
																<thead>
																	<tr role="row" class="heading">
																		<th width="5%">ID</th>
																		<th width="15%">Product&nbsp;Name</th>
																		<th width="10%">Image</th>
																		<th width="10%">Price</th>
																		<th width="5%">Quantity</th>
																		<th width="10%">Total</th>
																		<th width="10%">Date Create</th>
																		<th width="10%">Action</th>
																	</tr>
																	<c:forEach items="${ listDetail }" var="re">
																	<c:if test="${ re.status == 'Sold' }">
																		<tr role="row" class="filter">
																			<td>${ re.rdId }</td>
																			<td><a href="productdetail?${ re.product.pId }">${ re.product.pName }</a></td>
																			<td><a
																				href="productdetail?pid=${ re.product.pId }"
																				class="fancybox-button" data-rel="fancybox-button">
																					<img class="img-responsive"
																					src="${ re.product.pImage }"
																					alt="${ re.product.pName }"
																					style="width: 50px; height: 50px;">
																			</a></td>
																			<td>${ re.price }</td>
																			<td>${ re.quantity }</td>
																			<td>${ re.price * re.quantity}</td>
																			<td>${ re.receipt.date }</td>
																			<td><div class="margin-bottom-5">
																					<button onclick="AddtoCart(${ re.product.pId })"
																						class="btn btn-sm yellow">
																						<i class="fa"></i> Buy again
																					</button>
																				</div></td>
																		</tr>
																		</c:if>
																	</c:forEach>
																</thead>
																<tbody>
																</tbody>
															</table>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-6"></div>
											<div class="col-md-6">
												<div class="well">
													<div class="row static-info align-reverse">
														<div class="col-md-8 name">Total Order:</div>
														<div class="col-md-3 value">${ quantity.soldQuantity }</div>
													</div>
													<div class="row static-info align-reverse">
														<div class="col-md-8 name">Total Money: </div>
														<div class="col-md-3 value">${ total.soldTotal } $</div>
													</div>
												</div>
											</div>
										</div>

									</div>
									<div class="tab-pane" id="tab_3">
										<div class="row">
											<div class="col-md-12 col-sm-12">
												<div class="portlet grey-cascade box">
													<div class="portlet-title">
														<div class="caption">
															<i class="fa fa-cogs"></i>Pending Orders
														</div>
														<div class="actions">
															<a href="#" class="btn btn-default btn-sm"> <i
																class="fa fa-pencil"></i> Edit
															</a>
														</div>
													</div>
													<div class="portlet-body">
														<div class="table-responsive">
															<table
																class="table table-striped table-bordered table-hover"
																id="datatable_products">
																<thead>
																	<tr role="row" class="heading">
																		<th width="5%">ID</th>
																		<th width="15%">Product&nbsp;Name</th>
																		<th width="10%">Image</th>
																		<th width="10%">Price</th>
																		<th width="5%">Quantity</th>
																		<th width="10%">Total</th>
																		<th width="10%">Date Create</th>
																		<th width="10%">Action</th>
																	</tr>
																	<c:forEach items="${ listDetail }" var="re">
																	<c:if test="${ re.status == 'Waiting' }">
																		<tr role="row" class="filter">
																			<td>${ re.rdId }</td>
																			<td><a href="productdetail?${ re.product.pId }">${ re.product.pName }</a></td>
																			<td><a
																				href="productdetail?pid=${ re.product.pId }"
																				class="fancybox-button" data-rel="fancybox-button">
																					<img class="img-responsive"
																					src="${ re.product.pImage }"
																					alt="${ re.product.pName }"
																					style="width: 50px; height: 50px;">
																			</a></td>
																			<td>${ re.price }</td>
																			<td>${ re.quantity }</td>
																			<td>${ re.price * re.quantity}</td>
																			<td>${ re.receipt.date }</td>
																			<td><div class="margin-bottom-5">
																					<button onclick="Cancel(${ re.rdId })"
																						class="btn btn-sm yellow">
																						<i class="fa fa-search"></i> Cancel
																					</button>
																				</div></td>
																		</tr>
																		</c:if>
																	</c:forEach>
																</thead>
																<tbody>
																</tbody>
															</table>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-6"></div>
											<div class="col-md-6">
												<div class="well">
													<div class="row static-info align-reverse">
														<div class="col-md-8 name">Total Order:</div>
														<div class="col-md-3 value">${ quantity.waitingQuantity }</div>
													</div>
													<div class="row static-info align-reverse">
														<div class="col-md-8 name">Total Money: </div>
														<div class="col-md-3 value">${ total.waitingTotal } $</div>
													</div>
												</div>
											</div>
										</div>

									</div>
									<div class="tab-pane" id="tab_4">
										<div class="row">
											<div class="col-md-12 col-sm-12">
												<div class="portlet grey-cascade box">
													<div class="portlet-title">
														<div class="caption">
															<i class="fa fa-cogs"></i>Shipping Orders
														</div>
														<div class="actions">
															<a href="#" class="btn btn-default btn-sm"> <i
																class="fa fa-pencil"></i> Edit
															</a>
														</div>
													</div>
													<div class="portlet-body">
														<div class="table-responsive">
															<table
																class="table table-striped table-bordered table-hover"
																id="datatable_products">
																<thead>
																	<tr role="row" class="heading">
																		<th width="5%">ID</th>
																		<th width="15%">Product&nbsp;Name</th>
																		<th width="10%">Image</th>
																		<th width="10%">Price</th>
																		<th width="5%">Quantity</th>
																		<th width="10%">Total</th>
																		<th width="10%">Date Create</th>
																		<th width="10%">Action</th>
																	</tr>
																	<c:forEach items="${ listDetail }" var="re">
																	<c:if test="${ re.status == 'Shipping' }">
																		<tr role="row" class="filter">
																			<td>${ re.rdId }</td>
																			<td><a href="productdetail?${ re.product.pId }">${ re.product.pName }</a></td>
																			<td><a
																				href="productdetail?pid=${ re.product.pId }"
																				class="fancybox-button" data-rel="fancybox-button">
																					<img class="img-responsive"
																					src="${ re.product.pImage }"
																					alt="${ re.product.pName }"
																					style="width: 50px; height: 50px;">
																			</a></td>
																			<td>${ re.price }</td>
																			<td>${ re.quantity }</td>
																			<td>${ re.price * re.quantity}</td>
																			<td>${ re.receipt.date }</td>
																			<td><div class="margin-bottom-5">
																					<button onclick="AddtoCart(${ re.product.pId })"
																						class="btn btn-sm yellow">
																						<i class="fa"></i> Buy again
																					</button>
																				</div></td>
																		</tr>
																		</c:if>
																	</c:forEach>
																</thead>
																<tbody>
																</tbody>
															</table>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-6"></div>
											<div class="col-md-6">
												<div class="well">
													<div class="row static-info align-reverse">
														<div class="col-md-8 name">Total Order:</div>
														<div class="col-md-3 value">${ quantity.shippingQuantity }</div>
													</div>
													<div class="row static-info align-reverse">
														<div class="col-md-8 name">Total Money:</div>
														<div class="col-md-3 value">${ total.shippingTotal } $	</div>
													</div>
												</div>
											</div>
										</div>
									</div>
									<div class="tab-pane" id="tab_5">
										<div class="row">
											<div class="col-md-12 col-sm-12">
												<div class="portlet grey-cascade box">
													<div class="portlet-title">
														<div class="caption">
															<i class="fa fa-cogs"></i>Canceled Orders
														</div>
														<div class="actions">
															<a href="#" class="btn btn-default btn-sm"> <i
																class="fa fa-pencil"></i> Edit
															</a>
														</div>
													</div>
													<div class="portlet-body">
														<div class="table-responsive">
															<table
																class="table table-striped table-bordered table-hover"
																id="datatable_products">
																<thead>
																	<tr role="row" class="heading">
																		<th width="5%">ID</th>
																		<th width="15%">Product&nbsp;Name</th>
																		<th width="10%">Image</th>
																		<th width="10%">Price</th>
																		<th width="5%">Quantity</th>
																		<th width="10%">Total</th>
																		<th width="10%">Date Create</th>
																		<th width="10%">Action</th>
																	</tr>
																	<c:forEach items="${ listDetail }" var="re">
																	<c:if test="${ re.status == 'Canceled' }">
																		<tr role="row" class="filter">
																			<td>${ re.rdId }</td>
																			<td><a href="productdetail?${ re.product.pId }">${ re.product.pName }</a></td>
																			<td><a
																				href="productdetail?pid=${ re.product.pId }"
																				class="fancybox-button" data-rel="fancybox-button">
																					<img class="img-responsive"
																					src="${ re.product.pImage }"
																					alt="${ re.product.pName }"
																					style="width: 50px; height: 50px;">
																			</a></td>
																			<td>${ re.price }</td>
																			<td>${ re.quantity }</td>
																			<td>${ re.price * re.quantity}</td>
																			<td>${ re.receipt.date }</td>
																			<td><div class="margin-bottom-5">
																					<button onclick="AddtoCart(${ re.product.pId })"
																						class="btn btn-sm yellow">
																						<i class="fa"></i> Buy again
																					</button>
																				</div></td>
																		</tr>
																		</c:if>
																	</c:forEach>
																</thead>
																<tbody>
																</tbody>
															</table>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-6"></div>
											<div class="col-md-6">
												<div class="well">
													<div class="row static-info align-reverse">
														<div class="col-md-8 name">Total Order:</div>
														<div class="col-md-3 value">${ quantity.canceledQuantity }</div>
													</div>
													<div class="row static-info align-reverse">
														<div class="col-md-8 name">Total Money:</div>
														<div class="col-md-3 value">${ total.canceledTotal } $</div>
													</div>
												</div>
											</div>
										</div>

									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- End: life time stats -->
				</div>
			</div>
			<!-- END PAGE CONTENT-->
		</div>
	</div>
</div>
<script src="//ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>    
function Cancel(id) {	
	/*  tạo viên amount để Gọi và đếm classname là product */
	$.ajax({
		url : "/Laptop/order-canceled",
		type : "get", //send it through get method
		data : {
			rid : id
		},
		success : function(data) {
			//cách 1
			//$('#cart_quantity').val(data);
			//cách 2
			//$("#cart_quantity").append(data);
			//var row = document.getElementById('cart_quantity');
			//row.innerText = data; 
			if (data=="404")
				alert("Some error occur!");
			else
				location.reload();
			//alert("ok");
			
		},
		error : function(xhr) {
			alert("Error")
		}
	});
 };
 function AddtoCart(pid) {	
		/*  tạo viên amount để Gọi và đếm classname là product */
		$.ajax({
			url : "/Laptop/cart-add",
			type : "get", //send it through get method
			data : {
				quantity : 1,
				pid : pid
			},
			success : function(data) {
				//cách 1
				//$('#cart_quantity').val(data);
				//cách 2
				//$("#cart_quantity").append(data);
				//var row = document.getElementById('cart_quantity');
				//row.innerText = data; 
				if (data=="404")
					alert("There are not enough products!");
				else
					location.reload();
				//alert("ok");
				
			},
			error : function(xhr) {
				alert("Error")
			}
		});
	 };
</script>
<script src=".${ url }/global/plugins/jquery.min.js"
	type="text/javascript"></script>
<script src=".${ url }/global/plugins/jquery-migrate.min.js"
	type="text/javascript"></script>
<!-- IMPORTANT! Load jquery-ui-1.10.3.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
<script
	src=".${ url }/global/plugins/jquery-ui/jquery-ui-1.10.3.custom.min.js"
	type="text/javascript"></script>
<script src=".${ url }/global/plugins/bootstrap/js/bootstrap.min.js"
	type="text/javascript"></script>
<script
	src=".${ url }/global/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js"
	type="text/javascript"></script>
<script
	src=".${ url }/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js"
	type="text/javascript"></script>
<script src=".${ url }/global/plugins/jquery.blockui.min.js"
	type="text/javascript"></script>
<script src=".${ url }/global/plugins/jquery.cokie.min.js"
	type="text/javascript"></script>
<script src=".${ url }/global/plugins/uniform/jquery.uniform.min.js"
	type="text/javascript"></script>
<script
	src=".${ url }/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js"
	type="text/javascript"></script>
<!-- END CORE PLUGINS -->
<!-- BEGIN PAGE LEVEL PLUGINS -->
<script type="text/javascript"
	src=".${ url }/global/plugins/select2/select2.min.js"></script>
<script type="text/javascript"
	src=".${ url }/global/plugins/datatables/media/js/jquery.dataTables.min.js"></script>
<script type="text/javascript"
	src=".${ url }/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.js"></script>
<script type="text/javascript"
	src=".${ url }/global/plugins/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
<script type="text/javascript"
	src=".${ url }/global/plugins/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src=".${ url }/global/scripts/metronic.js"
	type="text/javascript"></script>
<script src=".${ url }/admin/layout/scripts/layout.js"
	type="text/javascript"></script>
<script src=".${ url }/admin/layout/scripts/quick-sidebar.js"
	type="text/javascript"></script>
<script src=".${ url }/admin/layout/scripts/demo.js"
	type="text/javascript"></script>
<script src=".${ url }/global/scripts/datatable.js"></script>
<script src=".${ url }/admin/pages/scripts/ecommerce-orders-view.js"></script>
<!-- END PAGE LEVEL SCRIPTS -->
<script>
	jQuery(document).ready(function() {
		Metronic.init(); // init metronic core components
		Layout.init(); // init current layout
		QuickSidebar.init(); // init quick sidebar
		Demo.init(); // init demo features
		EcommerceOrdersView.init();
	});
</script>
<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
