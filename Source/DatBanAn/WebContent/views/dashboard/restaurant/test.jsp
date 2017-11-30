<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<table id="example" class="table table-striped table-bordered" cellspacing="0" width="100%">
	<thead>
		<tr>
			<th>#</th>
			<th>Tên nhà hàng</th>
			<th>Địa chỉ</th>
			<th>Quản lý</th>
			<th>Trạng thái</th>
			<th>Ngày tạo</th>
			<th>Hành động</th>
		</tr>
	</thead>
	<tfoot>
		<tr>
			<th>#</th>
			<th>Tên nhà hàng</th>
			<th>Địa chỉ</th>
			<th>Quản lý</th>
			<th>Trạng thái</th>
			<th>Ngày tạo</th>
			<th>Hành động</th>
		</tr>
	</tfoot>
	<tbody>
		<c:forEach var="nh" items="${dsnhahang}" varStatus="status">
			<c:if test="${nh.id == idnhmoi}">
				<tr class="moi">
			</c:if>
				<td>${status.index + 1}</td>
				<td>${nh.tennhahang}</td>
				<td>${nh.diachifull}</td>
				<td>${nh.ndowner.hoTen} ${nh.ndowner.tendangnhap}</td>
				<td>${nh.trangthai == 1 ? '<span class="label label-info" data-toggle="tooltip" title="Click vào nút thùng rác để đổi trạng thái!">Đang hoạt động</span>' : '<span class="label label-danger" data-toggle="tooltip" title="Click vào nút khôi phục để đổi trạng thái!">Đã khóa</span>'}</td>
				<td>
					<img src="${nh.photopath}${nh.thumbnail}" class="img-response" width="90px" />
				</td>
				<td><c:choose>
						<c:when test="${tthai == 1}">
							<a href="${urlurl}?edit&idnhahang=${nh.id}" class="btn btn-info" data-toggle="tooltip" title="Chỉnh sửa thông tin người dùng">
								<i class="fa fa-edit"></i>
							</a>
							<a href="${urlurl}?trash&idxoa=${nh.id}" onclick="return confirm('sdkj')" class="btn btn-danger" data-toggle="tooltip" title="Bỏ vào thùng rác">
								<i class="fa fa-ban"></i>
							</a>
						</c:when>
						<c:otherwise>
							<a href="${urlurl}?restore&idxoa=${nh.id}" onclick="return confirm('khoi phuc hihi')" class="btn btn-success" data-toggle="tooltip" title="Khôi phục nhà hàng">
								<i class="fa fa-refresh"></i>
							</a>
							<a href="${urlurl}?delete&idxoa=${nh.id}" onclick="return confirm('xoa luon')" class="btn btn-danger" data-toggle="tooltip" title="Xóa dữ liệu nhà hàng">
								<i class="fa fa-trash-o"></i>
							</a>
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>