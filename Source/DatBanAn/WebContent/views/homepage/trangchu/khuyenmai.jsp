<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<div class="row">
	<c:forEach items="${promotion_nh}" var="km" end="3">
		<c:set var="slug" value="${km.slug}-r${km.id}.html"/>
		<div class=col-md-3>
	
			<div class="row">
				<a class="linknhgiamgia" href="${slug}"><img class="hinhgiamgia" src="images/baochau.png" /></a>
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
<div class="row">

	<div class="col-md-12 text-center linkxemthemgiamgia">
		<a href="#"><span class="xemthemgiamgia">Xem Thêm</span></a>
	</div>

</div>