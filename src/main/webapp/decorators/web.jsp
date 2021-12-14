<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
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
<meta property="og:image" content="-CUSTOMER VALUE-">
<!-- link to image for socio -->
<meta property="og:url" content="-CUSTOMER VALUE-">
<!-- BEGIN GLOBAL MANDATORY STYLES -->
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet" type="text/css"/>
<link href="${ url }/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
<link href="${ url }/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css"/>
<link href="${ url }/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="${ url }/global/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css"/>
<link href="${ url }/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css"/>
<!-- END GLOBAL MANDATORY STYLES -->
<!-- BEGIN PAGE LEVEL STYLES -->
<link href="${ url }/global/plugins/bootstrap-fileinput/bootstrap-fileinput.css" rel="stylesheet" type="text/css"/>
<link href="${ url }/admin/pages/css/profile.css" rel="stylesheet" type="text/css"/>
<link href="${ url }/admin/pages/css/tasks.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" type="text/css" href="${ url }/global/plugins/select2/select2.css"/>
<link rel="stylesheet" type="text/css" href="${ url }/global/plugins/datatables/extensions/Scroller/css/dataTables.scroller.min.css"/>
<link rel="stylesheet" type="text/css" href="${ url }/global/plugins/datatables/extensions/ColReorder/css/dataTables.colReorder.min.css"/>
<link rel="stylesheet" type="text/css" href="${ url }/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.css"/>
<link rel="stylesheet" type="text/css" href="${ url }/global/plugins/bootstrap-datepicker/css/datepicker.css"/>
<!-- END PAGE LEVEL STYLES -->
<!-- BEGIN THEME STYLES -->
<link href="${ url }/global/css/components-rounded.css" id="style_components" rel="stylesheet" type="text/css">
<link href="${ url }/global/css/components.css" id="style_components" rel="stylesheet" type="text/css"/>
<link href="${ url }/global/css/plugins.css" rel="stylesheet" type="text/css"/>
<link href="${ url }/admin/layout/css/layout.css" rel="stylesheet" type="text/css"/>
<link id="style_color" href="${ url }/admin/layout/css/themes/darkblue.css" rel="stylesheet" type="text/css"/>
<link href="${ url }/admin/layout/css/custom.css" rel="stylesheet" type="text/css"/>
<link rel="shortcut icon" href="favicon.ico">

<!-- Fonts START -->
<link
	href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700|PT+Sans+Narrow|Source+Sans+Pro:200,300,400,600,700,900&amp;subset=all"
	rel="stylesheet" type="text/css">
<link
	href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900&amp;subset=all"
	rel="stylesheet" type="text/css">
<!--- fonts for slider on the index page -->

<!-- Fonts END -->

<!-- Global styles START -->
<link
	href="${ url }/global/plugins/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<link href="${ url }/global/plugins/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Global styles END -->

<!-- Page level plugin styles START -->
<link href="${ url }/global/plugins/fancybox/source/jquery.fancybox.css"
	rel="stylesheet">
<link
	href="${ url }/global/plugins/carousel-owl-carousel/owl-carousel/owl.carousel.css"
	rel="stylesheet">
<link
	href="${ url }/global/plugins/slider-revolution-slider/rs-plugin/css/settings.css"
	rel="stylesheet">
<link
	href="${ url }/global/plugins/slider-layer-slider/css/layerslider.css"
	rel="stylesheet">
	<link href="${ url }/global/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css">
<!-- Page level plugin styles END -->

<!-- Theme styles START -->
<link href="${ url }/global/css/components.css" rel="stylesheet">
<link href="${ url }/frontend/layout/css/style.css" rel="stylesheet">
<link href="${ url }/frontend/pages/css/style-revolution-slider.css"
	rel="stylesheet">
<!-- metronic revo slider styles -->
<link href="${ url }/frontend/layout/css/style-responsive.css"
	rel="stylesheet">
<link href="${ url }/frontend/layout/css/themes/red.css"
	rel="stylesheet" id="style-color">
<link href="${ url }/frontend/layout/css/custom.css" rel="stylesheet">
<link href="${ url }/frontend/pages/css/style-shop.css" rel="stylesheet"
	type="text/css">
<link href="${ url }/frontend/pages/css/style-layer-slider.css"
	rel="stylesheet">
<!-- Theme styles END -->
</head>

<body class="corporate">
	<div class="color-panel hidden-sm">
		<!-- BEGIN STYLE CUSTOMIZER -->
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
	</div>
	<!-- END BEGIN STYLE CUSTOMIZER -->
	<!--header-->
	<%@ include file="/common/web/header.jsp"%>
	<!--end header-->

	<!-- content -->
	<dec:body />
	<!-- end content -->


	<!-- footer -->
	<%@ include file="/common/web/footer.jsp"%>
	<!--end footer-->

<!-- END CORE PLUGINS -->
	<script src="${ url }/global/plugins/jquery.min.js"
		type="text/javascript"></script>
	<script src="${ url }/global/plugins/jquery-migrate.min.js"
		type="text/javascript"></script>
	<script src="${ url }/global/plugins/bootstrap/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script src="${ url }/frontend/layout/scripts/back-to-top.js"
		type="text/javascript"></script>
	<script
		src="${ url }/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js"
		type="text/javascript"></script>
<script src="${ url }/global/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>
<script src="${ url }/global/plugins/jquery.blockui.min.js" type="text/javascript"></script>
<script src="${ url }/global/plugins/jquery.cokie.min.js" type="text/javascript"></script>
<script src="${ url }/global/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js" type="text/javascript"></script>
<script src="${ url }/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="${ url }/global/plugins/jquery-ui/jquery-ui-1.10.3.custom.min.js" type="text/javascript"></script>
<script src="${ url }/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
	<!-- END CORE PLUGINS -->
<script src="${ url }/global/plugins/bootstrap-fileinput/bootstrap-fileinput.js" type="text/javascript"></script>
<script src="${ url }/global/plugins/jquery.sparkline.min.js" type="text/javascript"></script>
<script src="${ url }/global/scripts/metronic.js" type="text/javascript"></script>
<script src="${ url }/admin/layout/scripts/layout.js" type="text/javascript"></script>
<script src="${ url }/admin/layout/scripts/quick-sidebar.js" type="text/javascript"></script>
<script src="${ url }/admin/layout/scripts/demo.js" type="text/javascript"></script>
<script src="${ url }/admin/pages/scripts/profile.js" type="text/javascript"></script>

	<!-- BEGIN PAGE LEVEL JAVASCRIPTS (REQUIRED ONLY FOR CURRENT PAGE) -->
	<script
		src="${ url }/global/plugins/fancybox/source/jquery.fancybox.pack.js"
		type="text/javascript"></script>
	<!-- pop up -->
	<script
		src="${ url }/global/plugins/carousel-owl-carousel/owl-carousel/owl.carousel.min.js"
		type="text/javascript"></script>
	<!-- slider for products -->

	<!-- BEGIN RevolutionSlider -->

	<script
		src="${ url }/global/plugins/slider-revolution-slider/rs-plugin/js/jquery.themepunch.plugins.min.js"
		type="text/javascript"></script>
	<script
		src="${ url }/global/plugins/slider-revolution-slider/rs-plugin/js/jquery.themepunch.revolution.min.js"
		type="text/javascript"></script>
	<script
		src="${ url }/global/plugins/slider-revolution-slider/rs-plugin/js/jquery.themepunch.tools.min.js"
		type="text/javascript"></script>
	<script src="${ url }/frontend/pages/scripts/revo-slider-init.js"
		type="text/javascript"></script>
	<!-- END RevolutionSlider -->

	<script src="${ url }/frontend/layout/scripts/layout.js"
		type="text/javascript"></script>
	<script type="text/javascript">
		jQuery(document).ready(function() {
			Layout.init();
			Layout.initOWL();
			RevosliderInit.initRevoSlider();
			Layout.initTwitter();
			Layout.initFixHeaderWithPreHeader(); /* Switch On Header Fixing (only if you have pre-header) */
			Layout.initNavScrolling();
		});
	</script>
	<script
		src="${ url }/global/plugins/fancybox/source/jquery.fancybox.pack.js"
		type="text/javascript"></script>
	<!-- pop up -->
	<script
		src="${ url }/global/plugins/carousel-owl-carousel/owl-carousel/owl.carousel.min.js"
		type="text/javascript"></script>
	<!-- slider for products -->
	<script src='${ url }/global/plugins/zoom/jquery.zoom.min.js'
		type="text/javascript"></script>
	<!-- product zoom -->
	<script
		src="${ url }/global/plugins/bootstrap-touchspin/bootstrap.touchspin.js"
		type="text/javascript"></script>
	<!-- Quantity -->
	<!-- BEGIN LayerSlider -->
	<script
		src="${ url }/global/plugins/slider-layer-slider/js/greensock.js"
		type="text/javascript"></script>
	<!-- External libraries: GreenSock -->
	<script
		src="${ url }/global/plugins/slider-layer-slider/js/layerslider.transitions.js"
		type="text/javascript"></script>
		<script src="${ url }/admin/pages/scripts/ecommerce-orders-view.js"></script>
	<!-- LayerSlider script files -->
	<script
		src="${ url }/global/plugins/slider-layer-slider/js/layerslider.kreaturamedia.jquery.js"
		type="text/javascript"></script>
	<!-- LayerSlider script files -->
	<script src="${ url }/frontend/pages/scripts/layerslider-init.js"
	
		type="text/javascript"></script>
	<!-- END LayerSlider -->
	<script type="text/javascript">
		jQuery(document).ready(function() {
			Layout.init();
			Layout.initOWL();
			LayersliderInit.initLayerSlider();
			Layout.initImageZoom();
			Layout.initTouchspin();
			Layout.initTwitter();
			EcommerceOrdersView.init();
		});
	</script>
</body>
</html>


