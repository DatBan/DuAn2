<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<div class="row">
	<c:if test="${best_book.size() < 1}">
		<div class="text-center" style="color:gray;">
			<span><b>Chưa có dữ liệu</b></span>
		</div>
	</c:if>
	<c:forEach items="${best_book}" var="noibat" end="3">
		<c:set var="slug" value="${noibat.tinhthanh.slug}/${noibat.slug}-r${noibat.id}.html"/>
		<div class=col-md-3>
	
			<div class="row">
				<a class="linknhgiamgia" href="${slug}"><img class="hinhgiamgia" src="${noibat.photopath}${noibat.thumbnail}" /></a>
			</div>
			<div class="row text-center giantoptennh">
				<a href="${slug}"><span class="tennhgiamgia">${noibat.tennhahang}</span></a>
			</div>
			<div class="row text-center">
				<div class="col-md-1"></div>
				<div class="col-md-10">
					<a href="${slug}"><span class="diachinhgiamgia">${noibat.diachifull}</span></a>
				</div>
				<div class="col-md-1"></div>
			</div>
		</div>
	</c:forEach>
</div>
<c:if test="${best_book.size() > 4}">
	<div class="row">
		<div class="col-md-12 text-center linkxemthemgiamgia">
			<a href="#"><span class="xemthemgiamgia">Xem Thêm</span></a>
		</div>
	</div>
</c:if>