<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%-- <!DOCTYPE html>
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
							<div class="content-nhe"> --%>
								<c:if test="${restorestt == 'error'}">
									<div class="alert alert-danger">
										<span>Mở khóa người dùng</span> <strong>thất bại</strong>! Vui lòng thử lại<br/>
									</div>
								</c:if>
								<c:if test="${restorestt == 'success'}">
									<div class="alert alert-success">
										<span>Mở khóa người dùng</span> <strong>thành công</strong>!<br/>
										<span style="font-style: italic;">Bạn vừa mở khóa người dùng với Email: <span style="text-decoration: underline;">${emailr}</span></span>
									</div>
								</c:if>
								<c:if test="${deletestt == 'error'}">
									<div class="alert alert-danger">
										<span>Khóa người dùng</span> <strong>thất bại</strong>! Vui lòng thử lại<br/>
									</div>
								</c:if>
								<c:if test="${deletestt == 'error1'}">
									<div class="alert alert-danger">
										<span>Khóa người dùng</span> <strong>thất bại</strong>!<br/>
										<span style="font-style: italic;">Phải có ít nhất 1 tài khoản với quyền <strong>ADMIN</strong> đang sử dụng trong Hệ thống</span>
									</div>
								</c:if>
								<c:if test="${deletestt == 'success'}">
									<div class="alert alert-success">
										<span>Khóa người dùng</span> <strong>thành công</strong>!<br/>
										<span style="font-style: italic;">Bạn vừa khóa người dùng với Email: <span style="text-decoration: underline;">${emailx}</span></span>
									</div>
								</c:if>
	                			<table id="example" class="table table-striped table-bordered" cellspacing="0" width="100%">
								        <thead>
								            <tr>
								            	<th>#</th>
								                <th>Họ tên</th>
								                <th>Tên đăng nhập</th>
								                <th>Email</th>
								                <th>Vai trò</th>
								                <th>Mạng xã hội</th>
								                <th>Trạng thái</th>
								                <th>Hành động</th>
								            </tr>
								        </thead>
								        <tfoot>
								            <tr>
								            	<th>#</th>
								                <th>Họ tên</th>
								                <th>Tên đăng nhập</th>
								                <th>Email</th>
								                <th>Vai trò</th>
								                <th>Mạng xã hội</th>
								                <th>Trạng thái</th>
								                <th>Hành động</th>
								            </tr>
								        </tfoot>
								        <tbody>
								        	<c:forEach var="nd" items="${nguoidunglist}" varStatus="status">
									            <c:if test="${nd.id == idndmoi}">
								        		<tr class="moi">
								        		</c:if>
									            	<td>${status.index + 1}</td>
									                <td>${nd.hoTen}</td>
									                <td>${nd.tendangnhap}</td>
									                <td>${nd.email}</td>
									                <td>${nd.quyennd.tenquyen}</td>
									                <td class="social-c text-center">
									                	<c:choose>
									                		<c:when test="${nd.idgoogle != null}">
									                			<i class="fa fa-google-plus-square" style="font-size: 18px;" data-toggle="tooltip" title="Google!"><span>google</span></i>
									                		</c:when>
									                		<c:when test="${nd.idfacebook != null}">
									                			<i class="fa fa-facebook-square" data-toggle="tooltip"style="font-size: 18px;" title="Facebook!"><span>facebook</span></i>
									                		</c:when>
									                		<c:otherwise><span class="label label-default" data-toggle="tooltip" title="Tài khoản thường!"><i class="fa fa-user"><span>thường</span></i></span></c:otherwise>
									                	</c:choose>
									                </td>
									                <td>${nd.trangthai == 1 ? '<span class="label label-info" data-toggle="tooltip" title="Click vào nút thùng rác để đổi trạng thái!">Đang sử dụng</span>' : '<span class="label label-danger" data-toggle="tooltip" title="Click vào nút khôi phục để đổi trạng thái!">Đã khóa</span>'}</td>
									                <td>
									                	<c:choose>
									                		<c:when test="${tthai == 1}">
									                			<a href="dashboard/user-management.html?edit&id=${nd.id}"
																class="btn btn-info" data-toggle="tooltip" title="Chỉnh sửa thông tin người dùng"><i class="fa fa-edit"></i></a> 
																<a href="dashboard/user-management.html?delete&idxoa=${nd.id}" onclick="return confirm('sdkj')"
																class="btn btn-danger" data-toggle="tooltip" title="Khóa tài khoản"><i class="fa fa-ban"></i></a>
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
	                			<%-- <div class="line"></div>
                			</div>
						</div>
						<!------------------- Footer dashboard------------ -->
						<jsp:include page="/include-dashboard/footer.jsp"></jsp:include>
					</div>
		</div>
	</body>
</html> --%>