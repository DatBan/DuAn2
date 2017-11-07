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
				<jsp:include page="/include-dashboard/header-bv.jsp"></jsp:include>

				<!--------------- Table, form cac thu ---------------->
				<div class="content-nhe">
					<div class="row tieudethemtrang">
						<span style="margin-top: 30px; color: red;">${message}</span>
					</div>
					<script type="text/javascript">
						function check(source) {
							checkboxes = document
									.getElementsByName('idbaiviet');
							for (var i = 0; i < checkboxes.length; i++) {
								checkboxes[i].checked = source.checked;
							}
						}
					</script>
					<div>
						<!-- <p style="text-align: center"><a type="button" class="btn btn-danger"
										href="baiviet/deletemulti.html"
										style="color: white; float:left;">Xoá nhiều</a></p></div> -->
						<form method="post" action="baiviet/deletemulti.html">
							<input type="submit" type="button" class="btn btn-danger"
								style="color: white; float: left;" value="Xoá nhiều"
								onclick="return confirm('Bạn có muốn xoá hết?')" />
							<table id="example" class="table table-striped table-bordered">
								<thead>
									<tr>
										<th><input type="checkbox" onclick="check(this)" /></th>
										<th>STT</th>
										<th>Tiêu đề</th>
										<th>Người đăng</th>
										<th>Loại bài viết</th>
										<th>Hình</th>
										<th>Trạng thái</th>
										<th>Ngày tạo</th>
										<th>Ngày sửa</th>
										<th>Thao tác</th>

									</tr>
								</thead>

								<tbody>
									<c:forEach var="bv" items="${baiviet}" varStatus="status">
										<c:set var="dem" value="${status.index+1}"></c:set>
										<fmt:formatDate var="nt" value="${bv.ngaytao}"
											pattern="dd-MM-yyyy" />
										<fmt:formatDate var="ns" value="${bv.ngaysua}"
											pattern="dd-MM-yyyy" />
										<tr>
											<td><input type="checkbox" name="idbaiviet"
												value="${bv.id}" /></td>

											<td>${dem}</td>
											<td>${bv.tieude}</td>

											<td>${bv.nguoiviet.hoten}</td>
											<td>${bv.loaibv.tenloai}</td>
											<td><img class="img-responsive"
												src="upload/baiviet/${bv.hinh}"
												style="width: 60px; height: 60px" /></td>
											<c:if test="${bv.trangthai==1}">
												<td>Đã duyệt</td>
											</c:if>
											<c:if test="${bv.trangthai==0}">
												<td><a href="baiviet/duyet/${bv.id}.html"
													style="color: Green;">Duyệt</a></td>
											</c:if>
											<td>${nt}</td>
											<td>${ns}</td>


											<td style="text-align: center"><a
												href="baiviet/xem/${bv.id}.html"
												style="color: green; padding-left: 30px;">Xem</a> <a
												href="baiviet/deletee/${bv.id}.html"
												onclick="return confirm ('Bạn có thực sự muốn xoá trang này')"
												style="color: red; padding-left: 30px;">Xoá</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</form>
						<div class="line"></div>
					</div>
				</div>
				<!------------------- Footer dashboard------------ -->
				<jsp:include page="/include-dashboard/footer.jsp"></jsp:include>
			</div>
		</div>
</body>
</html>