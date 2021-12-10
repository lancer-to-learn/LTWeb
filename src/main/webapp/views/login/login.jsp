<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div class="container">
    	    
<div class="main">
      <div class="container">
        <ul class="breadcrumb">
            <li><a href="home">Home</a></li>
            <li><a href="#">Pages</a></li>
            <li class="active">Login</li>
        </ul>
        <!-- BEGIN SIDEBAR & CONTENT -->
        <div class="row margin-bottom-40">
          <!-- BEGIN SIDEBAR -->
          <div class="sidebar col-md-3 col-sm-3">
            <ul class="list-group margin-bottom-25 sidebar-menu">
              <li class="list-group-item clearfix"><a href="#"><i class="fa fa-angle-right"></i> Đăng ký</a></li>
              <li class="list-group-item clearfix"><a href="#"><i class="fa fa-angle-right"></i> Khôi phục mật khẩu</a></li>
                </ul>
          </div>
          <!-- END SIDEBAR -->

          <!-- BEGIN CONTENT -->
          <div class="col-md-9 col-sm-9">
            <h1>Đăng nhập</h1>
            <div class="content-form-page">
              <div class="row">
                <div class="col-md-7 col-sm-7">
                
                  <form action="login" method="post" id="formLogin" class="form-horizontal form-without-legend" role="form">
                    <div class="form-group">
                      <label for="email" class="col-lg-4 control-label">Tên đăng nhập <span class="require">*</span></label>
                      <div class="col-lg-8">
                        <input type="text" class="form-control" id="username" name="username"
                        class="form-control" placeholder="Username" required autofocus>
                      </div>
                    </div>
                          <input type="hidden" class="form-control" value="login" name="action">
                  
                    <div class="form-group">
                      <label for="password" class="col-lg-4 control-label">Mật khẩu <span class="require">*</span></label>
                      <div class="col-lg-8">
                        <input type="password" class="form-control" id="password" name="password"
                        class="form-control" placeholder="Password" required>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-lg-8 col-md-offset-4 padding-left-0">
                        <a href="page-forgotton-password.html">Quên mật khẩu?</a>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-20">
                        <button type="submit" class="btn btn-primary">Đăng nhập</button>
                      </div>
                    </div>
                    
                  </form>
                </div>
                <div class="col-md-4 col-sm-4 pull-right">
                  <div class="form-info">
                    <c:if test="${not empty message}">
					<div class="alert alert-${alert}">
							${message}
					</div>
				</c:if>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <!-- END CONTENT -->
        </div>
        <!-- END SIDEBAR & CONTENT -->
      </div>
    </div>
    </div>
