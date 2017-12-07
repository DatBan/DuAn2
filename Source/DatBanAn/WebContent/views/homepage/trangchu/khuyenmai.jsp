<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<div class="row">
	<c:if test="${promotion_nh.size() < 1}">
		<div class="text-center" style="color:gray;">
			<span><b>Chưa có dữ liệu</b></span>
		</div>
	</c:if>
	<c:forEach items="${promotion_nh}" var="km" end="3">
		<c:set var="slug" value="${km.tinhthanh.slug}/${km.slug}-r${km.id}.html"/>
		<div class=col-md-3>
	
			<div class="row">
				<a class="linknhgiamgia" href="${slug}"><img class="hinhgiamgia" src="${km.photopath}${km.thumbnail}" /></a>
			</div>
			<div class="row text-center giantoptennh">
				<a href="${slug}"><span class="tennhgiamgia">${km.tennhahang}</span></a>
			</div>
			<div class="row text-center">
				<div class="col-md-1"></div>
				<div class="col-md-10">
					<a href="${slug}"><span class="diachinhgiamgia">${km.diachifull}</span></a>
				</div>
				<div class="col-md-1"></div>
			</div>
		</div>
	</c:forEach>
</div>
<c:if test="${promotion_nh.size() > 4 }">
	<div class="row">
		<div class="col-md-12 text-center linkxemthemgiamgia">
			<a href="#"><span class="xemthemgiamgia">Xem Thêm</span></a>
		</div>
	</div>
</c:if>