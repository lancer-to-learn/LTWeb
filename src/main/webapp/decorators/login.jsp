<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<!-- Site meta -->
<meta charset="utf-8">
  <title>Metronic Frontend (Header Fixed)</title>

  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

  <meta content="Metronic Shop UI description" name="description">
  <meta content="Metronic Shop UI keywords" name="keywords">
  <meta content="keenthemes" name="author">

  <meta property="og:site_name" content="-CUSTOMER VALUE-">
  <meta property="og:title" content="-CUSTOMER VALUE-">
  <meta property="og:description" content="-CUSTOMER VALUE-">
  <meta property="og:type" content="website">
  <meta property="og:image" content="-CUSTOMER VALUE-"><!-- link to image for socio -->
  <meta property="og:url" content="-CUSTOMER VALUE-">

  <link rel="shortcut icon" href="favicon.ico">
<!-- CSS -->
<!-- Fonts START -->
  <link href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700|PT+Sans+Narrow|Source+Sans+Pro:200,300,400,600,700,900&amp;subset=all" rel="stylesheet" type="text/css">
  <!-- Fonts END -->

  <!-- Global styles START -->          
  <link href="${ url }/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  <link href="${ url }/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Global styles END --> 
   
  <!-- Page level plugin styles START -->
  <link href="${ url }/global/plugins/fancybox/source/jquery.fancybox.css" rel="stylesheet">
  <link href="${ url }/global/plugins/carousel-owl-carousel/owl-carousel/owl.carousel.css" rel="stylesheet">
  <link href="${ url }/global/plugins/slider-revolution-slider/rs-plugin/css/settings.css" rel="stylesheet">
  <!-- Page level plugin styles END -->

  <!-- Theme styles START -->
  <link href="${ url }/global/css/components.css" rel="stylesheet">
  <link href="${ url }/frontend/layout/css/style.css" rel="stylesheet">
  <link href="${ url }/frontend/pages/css/style-revolution-slider.css" rel="stylesheet"><!-- metronic revo slider styles -->
  <link href="${ url }/frontend/layout/css/style-responsive.css" rel="stylesheet">
  <link href="${ url }/frontend/layout/css/themes/red.css" rel="stylesheet" id="style-color">
  <link href="${ url }/frontend/layout/css/custom.css" rel="stylesheet">
  <!-- Theme styles END -->
</head>

<body class="corporate">
<div class="color-panel hidden-sm">
      <div class="color-mode-icons icon-color"></div>
      <div class="color-mode-icons icon-color-close"></div>
      <div class="color-mode">
        <p>THEME COLOR</p>
        <ul class="inline">
          <li class="color-red current color-default" data-style="red"></li>
          <li class="color-blue" data-style="blue"></li>
          <li class="color-green" data-style="green"></li>
          <li class="color-orange" data-style="orange"></li>
          <li class="color-gray" data-style="gray"></li>
          <li class="color-turquoise" data-style="turquoise"></li>
        </ul>
      </div>
    </div>
	<!--header-->
	<%@ include file="/common/login/header.jsp"%>
	<!--end header-->

	<!-- content -->
	<dec:body />
	<!-- end content -->


	<!-- footer -->
	<%@ include file="/common/login/footer.jsp"%>
	<!--end footer-->


	<!-- JS -->
	<script src="//code.jquery.com/jquery-3.2.1.slim.min.js"
		type="text/javascript"></script>
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		type="text/javascript"></script>
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		type="text/javascript"></script>

</body>
</html>
