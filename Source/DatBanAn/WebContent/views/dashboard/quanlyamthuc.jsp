<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Dashboard</title>
<jsp:include page="/include-dashboard/headtag.jsp"></jsp:include>
</head>
<body>
	<div class="wrapper">
		<!----------------------------- Sidebar ----------------------------------->
		<jsp:include page="/include-dashboard/sidebar.jsp"></jsp:include>

		<!-- Menu top, content -->
		<div id="content">
			<!---------------------------- header-top------------------------------->
			<jsp:include page="/include-dashboard/header.jsp"></jsp:include>

			<!-- main content -->
			<div class="main-content">
				<!------------- Breadcrumb, nut bam cac thu -------------->
				<jsp:include page="/include-dashboard/header-amthuc.jsp"></jsp:include>

				<!--------------- Table, form cac thu ---------------->
				<div class="content-nhe">
					<div class="row tieudethemtrang">
						<span style="margin-top: 30px; color: red;">${message}</span>
					</div>
					<table id="example" class="table table-striped table-bordered">

						<thead>
							<tr>
								<th>STT</th>
								<th>Tên loại</th>
								<th>Name</th>
								<th>Mô tả</th>
								<th>description</th>							
								<th>Thao tác</th>

							</tr>
						</thead>

						<tbody>
							<c:forEach var="t" items="${amthuc}" varStatus="status">
								<c:set var="dem" value="${status.index+1}"></c:set>								
								<tr>
									<td>${dem}</td>
									<td>${t.tenloai}</td>
									<td>${t.name}</td>									
									<td>${t.mota}</td>	
									<td>${t.description}</td>										
										
									<td style="text-align: center"> <a href="dashboard/amthuc/edit/${t.id}.html"
										style="color: green; padding-left: 30px;">Sửa</a> <a
										href="dashboard/amthuc/delete/${t.id}.html"
										onclick="return confirm ('Bạn có thực sự muốn xoá loại ẩm thực này')"
										style="color: red; padding-left: 30px;">Xoá</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div class="line"></div>
				</div>
			</div>
			<!------------------- Footer dashboard------------ -->
			<jsp:include page="/include-dashboard/footer.jsp"></jsp:include>
		</div>
	</div>
</body>
</html>