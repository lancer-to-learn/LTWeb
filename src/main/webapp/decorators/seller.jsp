<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html lang="en">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
<meta charset="utf-8" />
<title>Admin</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta http-equiv="Content-type" content="text/html; charset=utf-8">
<meta content="" name="description" />
<meta content="" name="author" />

<link href = "https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.css"/>
<link href = "https://cdn.datatables.net/1.11.3/css/dataTables.bootstrap4.min.css"/>
<link href = "https://cdn.datatables.net/fixedheader/3.2.0/css/fixedHeader.bootstrap4.min.css"/>

<script src = "https://code.jquery.com/jquery-3.5.1.js"></script>
<script src = "https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
<script src = "https://cdn.datatables.net/1.11.3/js/dataTables.bootstrap4.min.js"></script>
<script src = "https://cdn.datatables.net/fixedheader/3.2.0/js/dataTables.fixedHeader.min.js"></script>

<!-- BEGIN GLOBAL MANDATORY STYLES -->
<link
	href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all"
	rel="stylesheet" type="text/css" />
<link
	href="${ url }/global/plugins/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
<link
	href="${ url }/global/plugins/simple-line-icons/simple-line-icons.min.css"
	rel="stylesheet" type="text/css" />
<link href="${ url }/global/plugins/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="${ url }/global/plugins/uniform/css/uniform.default.css"
	rel="stylesheet" type="text/css" />
<link
	href="${ url }/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css"
	rel="stylesheet" type="text/css" />
<!-- END GLOBAL MANDATORY STYLES -->
<!-- BEGIN PAGE LEVEL STYLES -->
<link rel="stylesheet" type="text/css"
	href="${ url }/global/plugins/select2/select2.css" />
<link rel="stylesheet" type="text/css"
	href="${ url }/global/plugins/datatables/extensions/Scroller/css/dataTables.scroller.min.css" />
<link rel="stylesheet" type="text/css"
	href="${ url }/global/plugins/datatables/extensions/ColReorder/css/dataTables.colReorder.min.css" />
<link rel="stylesheet" type="text/css"
	href="${ url }/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="${ url }/global/plugins/bootstrap-datepicker/css/datepicker.css" />
<!-- END PAGE LEVEL STYLES -->
<!-- BEGIN THEME STYLES -->
<link href="${ url }/global/css/components-rounded.css"
	id="style_components" rel="stylesheet" type="text/css">
<link href="${ url }/global/css/components.css" id="style_components"
	rel="stylesheet" type="text/css" />
<link href="${ url }/global/css/plugins.css" rel="stylesheet"
	type="text/css" />
<link href="${ url }/admin/layout/css/layout.css" rel="stylesheet"
	type="text/css" />
<link id="style_color"
	href="${ url }/admin/layout/css/themes/darkblue.css" rel="stylesheet"
	type="text/css" />
<link href="${ url }/admin/layout/css/custom.css" rel="stylesheet"
	type="text/css" />
<!-- END THEME STYLES -->
<link rel="shortcut icon" href="favicon.ico" />
</head>
<body class="page-header-fixed page-quick-sidebar-over-content ">
	<!--header-->
	<%@ include file="/common/admin/header.jsp"%>
	<!--end header-->

	<!-- content -->
	<dec:body />
	<!-- end content -->


	<!-- footer -->
	<%@ include file="/common/web/footer.jsp"%>
	<!--end footer-->
	<!-- BEGIN CORE PLUGINS -->
	<!--[if lt IE 9]>
<script src="${ url }/global/plugins/respond.min.js"/>"></script>
<script src="${ url }/global/plugins/excanvas.min.js"/>"></script> 
<![endif]-->
	<script src="${ url }/global/plugins/respond.min.js"></script>
	<script src="${ url }/global/plugins/excanvas.min.js"></script>
	<script src="${ url }/global/plugins/jquery.min.js"
		type="text/javascript"></script>
	<script src="${ url }/global/plugins/jquery-migrate.min.js"
		type="text/javascript"></script>
	<!-- IMPORTANT! Load jquery-ui-1.10.3.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
	<script
		src="${ url }/global/plugins/jquery-ui/jquery-ui-1.10.3.custom.min.js"
		type="text/javascript"></script>
	<script src="${ url }/global/plugins/bootstrap/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script
		src="${ url }/global/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js"
		type="text/javascript"></script>
	<script
		src="${ url }/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js"
		type="text/javascript"></script>
	<script src="${ url }/global/plugins/jquery.blockui.min.js"
		type="text/javascript"></script>
	<script src="${ url }/global/plugins/jquery.cokie.min.js"
		type="text/javascript"></script>
	<script src="${ url }/global/plugins/uniform/jquery.uniform.min.js"
		type="text/javascript"></script>
	<script
		src="${ url }/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js"
		type="text/javascript"></script>
	<!-- END CORE PLUGINS -->
	<!-- BEGIN PAGE LEVEL PLUGINS -->
	<script type="text/javascript"
		src="${ url }/global/plugins/select2/select2.min.js"></script>
	<script type="text/javascript"
		src="${ url }/global/plugins/datatables/media/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript"
		src="${ url }/global/plugins/datatables/extensions/TableTools/js/dataTables.tableTools.min.js"></script>
	<script type="text/javascript"
		src="${ url }/global/plugins/datatables/extensions/ColReorder/js/dataTables.colReorder.min.js"></script>
	<script type="text/javascript"
		src="${ url }/global/plugins/datatables/extensions/Scroller/js/dataTables.scroller.min.js"></script>
	<script type="text/javascript"
		src="${ url }/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.js"></script>
	<script type="text/javascript"
		src="${ url }/global/plugins/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
	<!-- END PAGE LEVEL PLUGINS -->
	<script
		src="${ url }/global/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js"
		type="text/javascript"></script>
	<script src="${ url }/global/plugins/amcharts/amcharts/amcharts.js"
		type="text/javascript"></script>
	<script src="${ url }/global/plugins/amcharts/amcharts/serial.js"
		type="text/javascript"></script>
	<script src="${ url }/global/plugins/amcharts/amcharts/pie.js"
		type="text/javascript"></script>
	<script src="${ url }/global/plugins/amcharts/amcharts/radar.js"
		type="text/javascript"></script>
	<script src="${ url }/global/plugins/amcharts/amcharts/themes/light.js"
		type="text/javascript"></script>
	<script
		src="${ url }/global/plugins/amcharts/amcharts/themes/patterns.js"
		type="text/javascript"></script>
	<script src="${ url }/global/plugins/amcharts/amcharts/themes/chalk.js"
		type="text/javascript"></script>
	<script src="${ url }/global/plugins/amcharts/ammap/ammap.js"
		type="text/javascript"></script>
	<script
		src="${ url }/global/plugins/amcharts/ammap/maps/js/worldLow.js"
		type="text/javascript"></script>
	<script src="${ url }/global/plugins/amcharts/amstockcharts/amstock.js"
		type="text/javascript"></script>
	<script src="${ url }/admin/pages/scripts/charts-amcharts.js"></script>


	<!-- BEGIN PAGE LEVEL SCRIPTS -->
	<script src="${ url }/global/scripts/metronic.js"
		type="text/javascript"></script>
	<script src="${ url }/admin/layout/scripts/layout.js"
		type="text/javascript"></script>
	<script src="${ url }/admin/layout/scripts/quick-sidebar.js"
		type="text/javascript"></script>
	<script src="${ url }/admin/layout/scripts/demo.js"
		type="text/javascript"></script>
	<script src="${ url }/admin/pages/scripts/table-advanced.js"></script>
	<script src="${ url }/global/scripts/datatable.js"></script>
	<script src="${ url }/admin/pages/scripts/ecommerce-orders-view.js"></script>
	<script src="${ url }/admin/pages/scripts/ecommerce-products.js"></script>
	<script>
		jQuery(document).ready(function() {
			Metronic.init(); // init metronic core components
			Layout.init(); // init current layout
			QuickSidebar.init(); // init quick sidebar
			Demo.init(); // init demo features
			EcommerceOrdersView.init();
			EcommerceProducts.init();
			ChartsAmcharts.init();
			TableAdvanced.init();
		});
	</script>
</body>