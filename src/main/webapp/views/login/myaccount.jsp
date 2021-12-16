<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div class="page-container">
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
		<!-- BEGIN PAGE HEADER-->
		<div class="page-bar">
			<ul class="page-breadcrumb">
				<li><i class="fa fa-home"></i> <a href="index.html">Home</a> <i
					class="fa fa-angle-right"></i></li>
				<li><a href="#">Pages</a> <i class="fa fa-angle-right"></i></li>
				<li><a href="#">Profile</a></li>
			</ul>
			<div class="page-toolbar">
				<div class="btn-group">
					<button type="button"
						class="btn btn-sm btn-default dropdown-toggle"
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
		<div class="row margin-top-20">
			<div class="col-md-12">
				<!-- BEGIN PROFILE SIDEBAR -->
				<div class="profile-sidebar">
					<!-- PORTLET MAIN -->
					<div class="portlet light profile-sidebar-portlet">
						<!-- SIDEBAR USERPIC -->
						<c:choose>
						<c:when test="${fn:contains(sessionScope.acc.image, 'https')}">
						<div class="profile-userpic">
							<img src="${ sessionScope.acc.image }"
								class="img-responsive" alt="${ sessionScope.acc.user }">
						</div>
						</c:when>
						<c:otherwise>
						<c:url value = "/admin/image?fname=${sessionScope.acc.image}" var = "imgUrl"></c:url>
						<div class="profile-userpic">
							<img src="${ imgUrl}"
								class="img-responsive" alt="${ sessionScope.acc.user }">
						</div>
						</c:otherwise>
						</c:choose>
						<!-- END SIDEBAR USERPIC -->
						<!-- SIDEBAR USER TITLE -->
						<div class="profile-usertitle">
							<div class="profile-usertitle-name">${ sessionScope.acc.user }
							</div>
							<div class="profile-usertitle-job">${ role }</div>
						</div>
						<!-- END SIDEBAR USER TITLE -->
						<!-- SIDEBAR BUTTONS -->
						<c:if test="${ role == 'Customer' }">
							<div class="profile-userbuttons">
								<a type="button" class="btn btn-circle green-haze btn-sm" href="user-to-seller">Register
									For Seller</a>
							</div>
							<div class="profile-usermenu">
								<ul class="nav">
									<li><a href="home"> <i class="icon-home"></i> Home
									</a></li>
									<li class="active"><a href="order"> <i
											class="icon-settings"></i> Order
									</a></li>
								</ul>
							</div>
						</c:if>
						<!-- END SIDEBAR BUTTONS -->
						<!-- SIDEBAR MENU -->

						<!-- END MENU -->
					</div>
					<!-- END PORTLET MAIN -->

				</div>
				<!-- END BEGIN PROFILE SIDEBAR -->
				<!-- BEGIN PROFILE CONTENT -->
				<div class="profile-content">
					<div class="row">
						<div class="col-md-12">
							<div class="portlet light">
								<div class="portlet-title tabbable-line">
									<div class="caption caption-md">
										<i class="icon-globe theme-font hide"></i> <span
											class="caption-subject font-blue-madison bold uppercase">Profile
											Account</span>
									</div>
									<ul class="nav nav-tabs">
										<li class="active"><a href="#tab_1_1" data-toggle="tab">Personal
												Info</a></li>
										<li><a href="#tab_1_2" data-toggle="tab">Change
												Avatar</a></li>
										<li><a href="#tab_1_3" data-toggle="tab">Change
												Password</a></li>

									</ul>
								</div>
								<div class="portlet-body">
									<div class="tab-content">
										<!-- PERSONAL INFO TAB -->
										<div class="tab-pane active" id="tab_1_1">
											<c:if test="${ mess!=null }">
												<div class="alert alert-success mess" role="alert">
													${mess}</div>
											</c:if>
											<c:if test="${ mess1!=null }">
												<div class="alert alert-danger mess" role="alert">
													${mess1}</div>
											</c:if>
											<form role="form" action="user-edit" method="post">
												<div class="form-group">
													<label class="control-label">Email</label> <input
														type="email" name="email"
														value="${ sessionScope.acc.getEmail() }"
														placeholder="Email" class="form-control" />
												</div>
												<div class="form-group">
													<label class="control-label">Phone</label> <input
														type="text" name="phone"
														value="${ sessionScope.acc.getPhone() }"
														placeholder="Phone" class="form-control" />
												</div>

												<div class="margiv-top-10">
													<button type="submit" class="btn green-haze">Save
														Changes</button>
													<a href="myaccount" class="btn default"> Cancel </a>
												</div>
											</form>
										</div>
										<!-- END PERSONAL INFO TAB -->
										<!-- CHANGE AVATAR TAB -->
										<div class="tab-pane" id="tab_1_2">
											<c:if test="${ mess2!=null }">
												<div class="alert alert-success mess" role="alert">
													${mess2}</div>
											</c:if>

											<form action="user-image" method="post" role="form" enctype="multipart/form-data">
												<div class="form-group">
												
														
													<div class="fileinput fileinput-new"
														data-provides="fileinput">
													<c:choose>
													<c:when test="${fn:contains(sessionScope.acc.image, 'https')}">
														<div class="fileinput-new thumbnail"
															style="width: 200px; height: 150px;">
															<img
																src="${ sessionScope.acc.image }"
																alt="" />
														</div>
													</c:when>
													<c:otherwise>
													<c:url value = "/admin/image?fname=${sessionScope.acc.image}" var = "imgUrl"></c:url>
														<img class="img-responsive center" src="${imgUrl}"
															style="width: 100px; height: 100px;" alt="Image Error">
													</c:otherwise>
													</c:choose>
														<div class="fileinput-preview fileinput-exists thumbnail"
															style="max-width: 200px; max-height: 150px;"></div>
														<div>
															<span class="btn default btn-file"> <span
																class="fileinput-new"> Select image </span> <span
																class="fileinput-exists"> Change </span> <input
																type="file" name="image">
															</span> <a href="#" class="btn default fileinput-exists"
																data-dismiss="fileinput"> Remove </a>
														</div>
													</div>
												</div>
												<div class="margin-top-10">
													<button type="submit" class="btn green-haze">
														Submit</button>
													<a href="myaccount" class="btn default"> Cancel </a>
												</div>
											</form>
										</div>
										<!-- END CHANGE AVATAR TAB -->
										<!-- CHANGE PASSWORD TAB -->
										<div class="tab-pane" id="tab_1_3">
											<c:if test="${ mess4!=null }">
												<div class="alert alert-success mess" role="alert">
													${mess4}</div>
											</c:if>
											<c:if test="${ mess5!=null }">
												<div class="alert alert-danger mess" role="alert">
													${mess5}</div>
											</c:if>
											<c:if test="${ mess6!=null }">
												<div class="alert alert-danger mess" role="alert">
													${mess6}</div>
											</c:if>
											<form action="user-change-password" method="post">
												<div class="form-group">
													<label class="control-label">Current Password</label> <input
														type="password" name="current" class="form-control" />
												</div>
												<div class="form-group">
													<label class="control-label">New Password</label> <input
														type="password" name="new" class="form-control" />
												</div>
												<div class="form-group">
													<label class="control-label">Re-type New Password</label> <input
														type="password" name="renew" class="form-control" />
												</div>
												<div class="margin-top-10">
													<button type="submit" class="btn green-haze">
														Change Password</button>
													<a href="myaccount" class="btn default"> Cancel </a>
												</div>
											</form>
										</div>
										<!-- END CHANGE PASSWORD TAB -->

									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- END PROFILE CONTENT -->
			</div>
		</div>
		<!-- END PAGE CONTENT-->
	</div>
</div>
<script>
	jQuery(document).ready(function() {
		// initiate layout and plugins
		Metronic.init(); // init metronic core components
		Layout.init(); // init current layout
		QuickSidebar.init(); // init quick sidebar
		Demo.init(); // init demo features
		Profile.init(); // init page demo
	});
</script>