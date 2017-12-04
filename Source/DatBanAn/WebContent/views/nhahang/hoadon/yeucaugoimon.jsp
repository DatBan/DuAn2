<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%-- <!DOCTYPE html>
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
				<jsp:include page="/include-dashboard/header-hoadon-xacnhan.jsp"></jsp:include>

				<!--------------- Table, form cac thu ---------------->
				<div class="content-nhe"> --%>
					
					<table id="example" class="table table-striped table-bordered">

						<thead>
							<tr>
								<th>STT</th>
								<th>Hoá đơn</th>
								<th>Bàn</th>
								<th>Tên món</th>
								<th>Hình ảnh</th>
								<th>Thao tác</th>
								
							</tr>
						</thead>

						<tbody>
						<c:set var="dem" value="1"></c:set>	
							<c:forEach var="hd" items="${hoadon}" varStatus="status">
								
								<c:forEach var="cthd" items="${hd.listcthd}" >
											
									<c:if test="${cthd.trangthai == 0}">			
										<tr>
											<td>${dem}</td>
											<td>#${hd.id}</td>
											<td>#${hd.banan.soban}</td>
											<td>${cthd.monan.tenmonan}</td>
											<td><img class="img-responsive"
										src="upload/monan/${cthd.monan.hinhanh}" style="width:60px;height:60px;" /></td>
											<td style="text-align: center"> <a href="datban/duyetmon/${cthd.id}.html"
										style="color: green; padding-left: 15px;">Duyệt</a><a
										href="datban/xoayeucau/${cthd.id}.html"
										onclick="return confirm ('Bạn có thực sự muốn xoá yêu cầu này')"
										style="color: red; padding-left: 30px;">Xoá</a></td>
										</tr>
										<c:set var="dem" value="${dem+1}"></c:set>
									</c:if>	
									
								</c:forEach>
								
							</c:forEach>
						</tbody>
					</table>
					<div class="line"></div>
				<%-- </div>
			</div>
			<!------------------- Footer dashboard------------ -->
			<jsp:include page="/include-dashboard/footer.jsp"></jsp:include>
		</div>
	</div>
</body>
</html> --%>