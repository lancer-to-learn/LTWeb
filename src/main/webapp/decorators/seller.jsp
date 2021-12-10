<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="/common/taglib.jsp"%>
 
<!DOCTYPE html>
<html lang="en">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
<meta charset="utf-8">
<title>Metronic | Metronic | Admin Dashboard Template</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1" name="viewport">
<meta content="" name="description">
<meta content="" name="author">
<!-- BEGIN GLOBAL MANDATORY STYLES -->
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet" type="text/css">
<link href="${ url }/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="${ url }/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css">
<link href="${ url }/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="${ url }/global/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css">
<!-- END GLOBAL MANDATORY STYLES -->
<!-- BEGIN PAGE LEVEL PLUGIN STYLES -->
<link href="${ url }/global/plugins/jqvmap/jqvmap/jqvmap.css" rel="stylesheet" type="text/css">
<link href="${ url }/global/plugins/morris/morris.css" rel="stylesheet" type="text/css">
<!-- END PAGE LEVEL PLUGIN STYLES -->
<!-- BEGIN PAGE STYLES -->
<link href="${ url }/admin/pages/css/tasks.css" rel="stylesheet" type="text/css"/>
<!-- END PAGE STYLES -->
<!-- BEGIN THEME STYLES -->
<!-- DOC: To use 'rounded corners' style just load 'components-rounded.css' stylesheet instead of 'components.css' in the below style tag -->
<link href="${ url }/global/css/components-rounded.css" id="style_components" rel="stylesheet" type="text/css">
<link href="${ url }/global/css/plugins.css" rel="stylesheet" type="text/css">
<link href="${ url }/admin/layout3/css/layout.css" rel="stylesheet" type="text/css">
<link href="${ url }/admin/layout3/css/themes/default.css" rel="stylesheet" type="text/css" id="style_color">
<link href="${ url }/admin/layout3/css/custom.css" rel="stylesheet" type="text/css">
<!-- END THEME STYLES -->
<link rel="shortcut icon" href="favicon.ico">
</head>
<body class="page-header-fixed page-quick-sidebar-over-content ">
<!--header-->
	<%@ include file="/common/admin/header.jsp"%>
	<!--end header-->

	<!-- content -->
	<dec:body />
	<!-- end content -->


	<!-- footer -->
	<%@ include file="/common/admin/footer.jsp"%>
	<!--end footer-->
	<!-- BEGIN CORE PLUGINS -->
<!--[if lt IE 9]>
<script src="${ url }/global/plugins/respond.min.js"/>"></script>
<script src="${ url }/global/plugins/excanvas.min.js"/>"></script> 
<![endif]-->
<script src="${ url }/global/plugins/jquery.min.js" type="text/javascript"></script>
<script src="${ url }/global/plugins/jquery-migrate.min.js" type="text/javascript"></script>
<!-- IMPORTANT! Load jquery-ui-1.10.3.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
<script src="${ url }/global/plugins/jquery-ui/jquery-ui-1.10.3.custom.min.js" type="text/javascript"></script>
<script src="${ url }/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${ url }/global/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js" type="text/javascript"></script>
<script src="${ url }/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="${ url }/global/plugins/jquery.blockui.min.js" type="text/javascript"></script>
<script src="${ url }/global/plugins/jquery.cokie.min.js" type="text/javascript"></script>
<script src="${ url }/global/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>
<script src="${ url }/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js" type="text/javascript"></script>
<!-- END CORE PLUGINS -->
<!-- BEGIN PAGE LEVEL PLUGINS -->
<script type="text/javascript" src="${ url }/global/plugins/select2/select2.min.js"></script>
<script type="text/javascript" src="${ url }/global/plugins/datatables/media/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${ url }/global/plugins/datatables/extensions/TableTools/js/dataTables.tableTools.min.js"></script>
<script type="text/javascript" src="${ url }/global/plugins/datatables/extensions/ColReorder/js/dataTables.colReorder.min.js"></script>
<script type="text/javascript" src="${ url }/global/plugins/datatables/extensions/Scroller/js/dataTables.scroller.min.js"></script>
<script type="text/javascript" src="${ url }/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.js"></script>
<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="${ url }/global/scripts/metronic.js" type="text/javascript"></script>
<script src="${ url }/admin/layout/scripts/layout.js" type="text/javascript"></script>
<script src="${ url }/admin/layout/scripts/quick-sidebar.js" type="text/javascript"></script>
<script src="${ url }/admin/layout/scripts/demo.js" type="text/javascript"></script>
<script src="${ url }/admin/pages/scripts/table-advanced.js"></script>
<script>
jQuery(document).ready(function() {       
   Metronic.init(); // init metronic core components
Layout.init(); // init current layout
QuickSidebar.init(); // init quick sidebar
Demo.init(); // init demo features
   TableAdvanced.init();
});
</script>
</body>