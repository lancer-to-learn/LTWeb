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
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
					<img alt="" class="img-circle" src="https://th.bing.com/th/id/OIP.EkgwTH-cHmdPFfz6UR8ywgHaHa?w=203&h=203&c=7&r=0&o=5&dpr=1.5&pid=1.7"
					style="width:30px;height:30px;"/>
					<span class="username username-hide-on-mobile">
					${ acc.getUser() } </span>
					<i class="fa fa-angle-down"></i>
					</a>
					<ul class="dropdown-menu dropdown-menu-default">
						<li>
							<a href="extra_profile.html">
							<i class="icon-user"></i> My Profile </a>
						</li>					
						<li class="divider">
						</li>
						
						<li>
							<a href="logout">
							<i class="icon-key"></i> Log Out </a>
						</li>
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
        <a class="site-logo" href="index.html"><img src="${ url }/frontend/layout/img/logos/logo-corp-red.png" alt="Metronic FrontEnd"></a>

        <a href="javascript:void(0);" class="mobi-toggler"><i class="fa fa-bars"></i></a>

        <!-- BEGIN NAVIGATION -->
        <div class="header-navigation pull-right font-transform-inherit">
          <ul>
            <li><a href="home">Home</a></li>
            <li class="dropdown">
              <a class="dropdown-toggle" data-toggle="dropdown" data-target="#" href="#">
                Brand             
	          </a>  
              <ul class="dropdown-menu">
              <c:forEach items="${ allBrand }" var="ab">
                <li class="${tagactive==ab.bId ? "active" : ""}"><a href="product?bid=${ab.bId}">${ab.bName}</a></li>   
                </c:forEach>          
              </ul>
            </li>
            <li><a href="product?bid=0">Product</a></li>
            <c:if test="${ sessionScope.acc != null }">
            <li><a href="order">Orders</a></li>
            </c:if>
            <li class="dropdown">
              <a href="cart-item">
                Cart     
               <c:choose>    
               <c:when test="${ sessionScope.cart_quantity != null }">      
              <span class="badge badge-info" id="cart_quantity">${ sessionScope.cart_quantity }</span>
              </c:when>
              <c:otherwise>
              <span class="badge badge-info" id="cart_quantity">0</span>
              </c:otherwise>
              </c:choose>
              </a>
            </li>
            
            <!-- BEGIN TOP SEARCH -->
            <li class="menu-search">
              <span class="sep"></span>
              <i class="fa fa-search search-btn"></i>
              <div class="search-box">
                <form action="#">
                  <div class="input-group">
                    <input type="text" placeholder="Tìm kiếm" class="form-control">
                    <span class="input-group-btn">
                      <button class="btn btn-primary" type="submit">Search</button>
                    </span>
                  </div>
                </form>
              </div> 
            </li>
            <!-- END TOP SEARCH -->
          </ul>
        </div>
        <!-- END NAVIGATION -->
      </div>
    </div>
    <!-- Header END -->
<!-- <script src="//ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>    
function AddtoCart(pid) {	
	/*  tạo viên amount để Gọi và đếm classname là product */
	var quantity = $('#qty').val();
	$.ajax({
		url : "/cart-add",
		type : "post", //send it through get method
		data : {
			quantity : quantity,
			pid : pid
		},
		success : function(data) {
			//cách 1
			$('#cart_quantity').val(data);
			//cách 2
			//$("#qty").append(data);
			
		},
		error : function(xhr) {
			alert("Error")
		}
	});
 };
 function deleteItem() {	
		/*  tạo viên amount để Gọi và đếm classname là product */
		var quantity = $('#qty').val();
		$.ajax({
			url : "/BanHang/substract-quantity",
			type : "get", //send it through get method
			data : {
				amount : quantity
			},
			success : function(data) {
				//cách 1
				$('#qty').val(data);
				//cách 2
				//$("#qty").append(data);
				
			},
			error : function(xhr) {
				//Do Something to handle error
			}
		});
	 };
</script>
 -->