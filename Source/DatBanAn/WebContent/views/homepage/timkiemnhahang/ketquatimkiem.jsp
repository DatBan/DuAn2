<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
	<!-- form tim kiem -->
	<div class="container-full conff">
		<div class="container timkiemm">
			<jsp:include page="/include/form-timkiem.jsp"></jsp:include>
		</div>
	</div>

	<div class="container bodydexuat">
		<div class="row">
			<div class="col-md-4">
				<span class="giamgia">${listsize} kết quả tìm kiếm "${tukhoa}"</span>
			</div>
			<div class="col-md-2 dropdown pull-right">
				<select class="form-control sap-xep-tk">
					<option value="newest">Mới nhất</option>
					<option value="oldest">Cũ nhất</option>
					<option value="popular">Phổ biến nhất</option>
				</select>
			</div>
		</div>
		<c:if test="${listnh.size() < 1}">
			<div class="text-center" style="color:gray;">
				<span><b>Chưa có dữ liệu</b></span>
			</div>
		</c:if>
		<div class="row list-timkiem" style="min-height: 106px;" id="list-timkiem">
			<c:forEach var="listf" items="${listnh}">
				<c:set var="slug" value="${listf.tinhthanh.slug}/${listf.slug}-r${listf.id}.html"/>
				<div class="col-md-3">
					<div class="row">
						<a class="linknhgiamgia" href="${slug}">
							<img class="hinhgiamgia" src="images/baochau.png" />
						</a>
					</div>
					<div class="row text-center giantoptennh">
						<a href="${slug}"><span class="tennhgiamgia">${listf.tennhahang}</span></a>
					</div>
					<div class="row text-center">
						<div class="col-md-1"></div>
						<div class="col-md-10">
							<a href="${slug}">
								<span class="diachinhgiamgia">
									${listf.diachifull}
								</span>
							</a>
						</div>
						<div class="col-md-1"></div>
					</div>
				</div>
			</c:forEach>
		</div>
		<c:if test="${listsize > 8}">
			<hr/>
			<div class="row">
				<div class="col-md-12 text-center linkxemthemgiamgia">
					<a style="cursor: pointer;" id="xem-them-tk"><span class="xemthemgiamgia">Xem Thêm</span></a>
				</div>
			</div>
		</c:if>
	</div>