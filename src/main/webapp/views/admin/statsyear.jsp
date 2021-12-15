<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div class="clearfix"></div>

	<c:if test="${ sessionScope.acc.getRole()==1 }"><li><%@include file = "/common/admin/sidebar.jsp" %></li></c:if>
	  <c:if test="${ sessionScope.acc.getRole()==2 }"><li><%@include file = "/common/seller/sidebar.jsp" %></li></c:if>min/sidebar.jsp" %> 


<!-- BEGIN CONTENT -->
<div class="page-content-wrapper">
	<div class="page-content">


		<!-- BEGIN PAGE HEADER-->
		<h3 class="page-title">Income</h3>
		<div class="page-bar">
			<ul class="page-breadcrumb">
				<li><i class="fa fa-home"></i> <a
					href="${pageContext.request.contextPath}/admin">Admin</a> <i
					class="fa fa-angle-right"></i></li>
				<li><a href="">Income</a> <i class="fa fa-angle-right"></i></li>
				<li><a href="">Month & Year</a></li>
			</ul>
		</div>


		<!-- END PAGE HEADER-->
		<div class="row">
			<div class="col-md-12">
				<!-- BEGIN CHART PORTLET-->
				<div class="portlet light bordered">
					<div class="portlet-title">
						<div class="caption">
							<i class="icon-bar-chart font-green-haze"></i> <span
								class="caption-subject bold uppercase font-green-haze">
								2D Chart</span> <span class="caption-helper">2d bar chart</span>
						</div>
					</div>
					<div class="row">
						<div class="col-md-5 col-xs-12">
							<table class="table">
								<tr>
									<th>Year</th>
									<th>Month</th>
									<th>Total</th>
								</tr>
								<c:forEach items = "${stat}" var = "st">
								<tr>
									<td>${st.year}</td>
									<td>${st.month}</td>
									<td>${st.total}</td>
								</tr>
								</c:forEach>
							</table>
						</div>
						<div class="col-md-7 col-xs-12">
							<form action="${pageContext.request.contextPath}/admin/stats-year">
								<div class="row">
									<div class="col-md-3">
										<input type="submit" value="Calculate" class="btn btn-danger">
									</div>
									<div class="col-md-9">
										<input type="number" name="year"
											placeholder="Enter a year...." class="form-control" />
									</div>
								</div>
							</form>
							<canvas id="productStatsId"></canvas>
						</div>
					</div>

				</div>
				<!-- END CHART PORTLET-->
			</div>
		</div>
		<!-- BEGIN PAGE CONTENT-->

		<!-- END PAGE CONTENT-->
	</div>
</div>
<!-- END CONTENT -->
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script>
let labels = [], info = [];

<c:forEach items = "${stat}" var = "st">
	labels.push("${st.month}")
	info.push("${st.total}")
</c:forEach>

let colors = []
<c:forEach items = "${color}" var = "cl">
	colors.push(`rgb(${cl.color1}, ${cl.color2}, ${cl.color3})`)
</c:forEach>

const data = {
    labels: labels,
    datasets: [{
      label: 'Month & Year Stat',
      data: info,
      backgroundColor: colors,
      hoverOffset: 4
    }]
  };

  const config = {
  type: 'bar',
  data: data,
};

window.onload = function() {
  let ctx = document.getElementById("productStatsId").getContext('2d')
  new Chart(ctx, config)
}
</script>