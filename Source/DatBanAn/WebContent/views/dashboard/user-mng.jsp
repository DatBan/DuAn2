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
								            	<th>#</th>
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
								            	<th>#</th>
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
									            	<td>${status.index + 1}</td>
									                <td>${nd.hoten}</td>
									                <td>${nd.tendangnhap}</td>
									                <td>${nd.sdt}</td>
									                <td>${nd.email}</td>
									                <td>${nd.quyennd.tenquyen}</td>
									                <td>${nd.trangthai == 1 ? '<span class="label label-info">Đang sử dụng</span>' : '<span class="label label-danger">Đã khóa</span>'}</td>
									                <td>
									                	<c:choose>
									                		<c:when test="${tthai == 1}">
									                			<a href="dashboard/user-management.html?edit&id=${nd.id}"
																class="btn btn-info" data-toggle="tooltip" title="Chỉnh sửa thông tin người dùng"><i class="fa fa-edit"></i></a> 
																<a href="dashboard/user-management.html?delete&idxoa=${nd.id}" onclick="return confirm('sdkj')"
																class="btn btn-danger" data-toggle="tooltip" title="Bỏ vào thùng rác"><i class="fa fa-trash-o"></i></a>
									                		</c:when>
									                		<c:otherwise>
									                			<a href="dashboard/user-management.html?restore&idxoa=${nd.id}" onclick="return confirm('khoi phuc hihi')"
																class="btn btn-success" data-toggle="tooltip" title="Khôi phục người dùng"><i class="fa fa-refresh"></i></a>
									                		</c:otherwise>
									                	</c:choose>
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