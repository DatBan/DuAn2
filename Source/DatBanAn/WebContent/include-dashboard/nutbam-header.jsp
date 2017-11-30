<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<div class="row content-header">
	<!-- Breadcrumb -->
	<ul class="breadcrumb col-sm-8">
		<li><a href="#"><i class="fa fa-dashboard"></i> Dashboard</a></li>
		<c:if test="${tenbreadcrumb2 != null}">
			<li><a href="${urlbreadcrumb2}">${tenbreadcrumb2}</a></li>
		</c:if>
		<li class="active text-uppercase"><b>${tenbreadcrumb}</b></li>
	</ul>
	<!--Nut bam -->
	<div class="col-sm-4 btn-thao-tac">
		<c:if test="${btn_add != null}">
			<a href="${btn_add}" class="btn btn-info">
				<i class="glyphicon glyphicon-plus"></i> Thêm mới
			</a>
		</c:if>
		<c:set var="vback" value="dashboard/index.html"></c:set>
		<c:if test="${btn_back != null}">
			<c:set var="vback" value="${btn_back}"></c:set>
		</c:if>
		<a href="${vback}" class="btn btn-default">
			<i class="glyphicon glyphicon-arrow-left"></i> Trở về
		</a>
	</div>
</div>