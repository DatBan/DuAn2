<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%-- <!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Trang chu</title>
<jsp:include page="/include/headtag.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="/include/header.jsp"></jsp:include> --%>
	<!-- form tim kiem -->
	<div class="container-full conf">
		<div class="container timkiem">
			<div class="row">
				<div class="col-md-12 text-center">			
					<span class="dbmp"><b>ĐẶT BÀN MIỄN PHÍ</b></span>
				</div>		
			</div>
			<jsp:include page="/include/form-timkiem.jsp"></jsp:include>
		</div>
	</div>
	<div class="container bodygiamgia">
	<c:if test="${km!=null}">
		<div class="row">
			<div class="col-md-3">
				<img src="images/icongiamgia.png" style="margin-top: -22px;" /> <span
					class="giamgia">Khuyến mãi</span>
			</div>
		</div>
		
		
		<div class="row">
			<c:forEach var="km" items="${km}">
				<div class=col-md-3>
					<div class="row">
						<a class="linknhgiamgia" href="chitietnhahang.html"><img
							class="hinhgiamgia" src="images/baochau.png" /></a>
					</div>
					<div class="row text-center giantoptennh">
						<a href="${km.nhahang.id}"><span class="tennhgiamgia">${km.nhahang.tennhahang}</span></a>
					</div>
					<div class="row text-center">
						<div class="col-md-1"></div>
						<div class="col-md-10">
							<a href="#"><span class="diachinhgiamgia">${km.nhahang.diachi}</span></a>
						</div>
						<div class="col-md-1"></div>
					</div>
					
					<div class="row text-center">
						<div class="col-md-1"></div>
						<div class="col-md-10">
							<a href="${km.id}"><span class="ndgiamgia">${km.thongtin}</span></a>
						</div>
						<div class="col-md-1"></div>
	
					</div>
				</div>
			</c:forEach>		
		</div>
		
		<div class="row">

			<div class="col-md-12 text-center linkxemthemgiamgia">
				<a href="#"><span class="xemthemgiamgia">Xem Thêm</span></a>
			</div>

		</div>
		
		</c:if>
		<c:if test="${km==null}">
			<div class="row">
			<div class="col-md-12 text-center linkxemthemgiamgia">
				<span class="xemthemgiamgia">Hiện tại không có khuyến mãi nào</span>
			</div>

		</div>
		</c:if>
	</div>
	<%-- <jsp:include page="/include/footer.jsp"></jsp:include>
</body>
</html> --%>