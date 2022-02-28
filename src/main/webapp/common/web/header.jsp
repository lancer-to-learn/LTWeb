<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<!-- BEGIN TOP BAR -->
<div class="pre-header">
	<div class="container">
		<div class="row">
			<!-- BEGIN TOP BAR LEFT PART -->
			<div class="col-md-6 col-sm-6 additional-shop-info">
				<ul class="list-unstyled list-inline">
					<li><i class="fa fa-phone"></i><span>+1 456 6717</span></li>
					<li><i class="fa fa-envelope-o"></i><span>info@keenthemes.com</span></li>
				</ul>
			</div>
			<!-- END TOP BAR LEFT PART -->
			<!-- BEGIN TOP BAR MENU -->
			<c:choose>
				<c:when test="${sessionScope.acc == null}">
					<div class="col-md-6 col-sm-6 additional-nav">
						<ul class="list-unstyled list-inline pull-right">
							<li><a href="${pageContext.request.contextPath }/login">Login</a></li>
							<li><a href="signup">Register</a></li>
						</ul>
					</div>
				</c:when>
				<c:otherwise>
					<li class="dropdown dropdown-user col-md-4 col-sm-4 additional-nav">
						<c:choose>
							<c:when test="${fn:contains(acc.image, 'https')}">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown"
									data-hover="dropdown" data-close-others="true"> <img alt=""
									class="img-circle" src="${ acc.image }"
									style="width: 30px; height: 30px;" /> <span
									class="username username-hide-on-mobile"> ${ acc.user }
								</span> <i class="fa fa-angle-down"></i>
								</a>
							</c:when>
							<c:otherwise>
								<c:url value="/admin/image?fname=${sessionScope.acc.image}"
									var="imgUrl"></c:url>
								<a href="#" class="dropdown-toggle" data-toggle="dropdown"
									data-hover="dropdown" data-close-others="true"> <img alt=""
									class="img-circle" src="${ imgUrl}"
									style="width: 30px; height: 30px;" /> <span
									class="username username-hide-on-mobile"> ${ acc.user }
								</span> <i class="fa fa-angle-down"></i>
								</a>
							</c:otherwise>
						</c:choose>
						<ul class="dropdown-menu dropdown-menu-default">
							<li><a href="myaccount"> <i class="icon-user"></i> My
									Profile
							</a></li>
							<li class="divider"></li>

							<li><a href="logout"> <i class="icon-key"></i> Log Out
							</a></li>
						</ul>
					</li>

				</c:otherwise>
			</c:choose>
			<!-- END TOP BAR MENU -->
		</div>
	</div>
</div>
<!-- END TOP BAR -->
<!-- BEGIN HEADER -->
<div class="header">
	<div class="container">
		<a class="site-logo" href="index.html"><img
			src="${ url }/frontend/layout/img/logos/logo-corp-red.png"
			alt="Metronic FrontEnd"></a> <a href="javascript:void(0);"
			class="mobi-toggler"><i class="fa fa-bars"></i></a>

		<!-- BEGIN NAVIGATION -->
		<div class="header-navigation pull-right font-transform-inherit">
			<ul>
				<li><a href="home">Home</a></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" data-target="#" href="#"> Brand </a>
					<ul class="dropdown-menu">
						<c:forEach items="${ allBrand }" var="ab">
							<li class="${tagactive==ab.bId ? "active" : ""}"><a
								href="product?bid=${ab.bId}">${ab.bName}</a></li>
						</c:forEach>
					</ul></li>
				<li><a href="product?bid=0">Product</a></li>
				<c:if test="${ sessionScope.acc != null }">
					<li><a href="order">Orders</a></li>

				</c:if>
				<c:if test="${ sessionScope.acc.getRole()==2 }">
					<li><a href="seller">Seller Chanel</a></li>
				</c:if>
				<li class="dropdown"><a href="cart-item"> Cart <c:choose>
							<c:when test="${ sessionScope.cart_quantity != null }">
								<span class="badge badge-info" id="cart_quantity">${ sessionScope.cart_quantity }</span>
							</c:when>
							<c:otherwise>
								<span class="badge badge-info" id="cart_quantity">0</span>
							</c:otherwise>
						</c:choose> <!-- <span class="badge badge-info" id="cart_quantity">0</span> -->
				</a></li>

				<!-- BEGIN TOP SEARCH -->
				<li class="menu-search"><span class="sep"></span> <i
					class="fa fa-search search-btn"></i>
					<div class="search-box">
						<form action="product" method="get">
							<div class="input-group">
								<input type="text" placeholder="Tìm kiếm" class="form-control" name="kw">
								<span class="input-group-btn">
									<button class="btn btn-primary" type="submit">Search</button>
								</span>
							</div>
						</form>
					</div></li>
				<!-- END TOP SEARCH -->
			</ul>
		</div>
		<!-- END NAVIGATION -->
	</div>
</div>
<!-- Header END -->

