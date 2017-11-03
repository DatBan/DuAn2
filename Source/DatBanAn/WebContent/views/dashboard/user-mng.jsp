<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Quản lý người dùng</title>
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
							<jsp:include page="/include-dashboard/header-content.jsp"></jsp:include>
							
							<!--------------- Table, form cac thu ---------------->
							<div class="content-nhe">
	                			<table id="example" class="table table-striped table-bordered" cellspacing="0" width="100%">
								        <thead>
								            <tr>
								                <th>Họ tên</th>
								                <th>Tên đăng nhập</th>
								                <th>Điện thoại</th>
								                <th>Email</th>
								                <th>Vai trò</th>
								                <th>Trạng thái</th>
								                <th>Hành động</th>
								            </tr>
								        </thead>
								        <tfoot>
								            <tr>
								                <th>Họ tên</th>
								                <th>Tên đăng nhập</th>
								                <th>Điện thoại</th>
								                <th>Email</th>
								                <th>Vai trò</th>
								                <th>Trạng thái</th>
								                <th>Hành động</th>
								            </tr>
								        </tfoot>
								        <tbody>
								        	<c:forEach var="nd" items="${nguoidunglist}" varStatus="status">
									            <tr>
									                <td>${nd.hoten}</td>
									                <td>${nd.tendangnhap}</td>
									                <td>${nd.sdt}</td>
									                <td>${nd.email}</td>
									                <td>${nd.quyennd.tenquyen}</td>
									                <td>${nd.trangthai == 0 ? '<span class="label label-success">Online</span>' : 1}</td>
									                <td>
									                	<a href="dashboard/edit-user.html?id=${nd.id}"
														class="btn btn-info"><i class="fa fa-edit"></i></a> 
														<a href="dashboard/delete-user.html?idxoa=${nd.id}" onclick="return confirm('sdkj')"
														class="btn btn-danger"><i class="fa fa-remove"></i></a>
													</td>
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