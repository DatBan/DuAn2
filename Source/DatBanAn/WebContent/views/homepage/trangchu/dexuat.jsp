<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<div class="container bodydexuat">
		<div class="row">
			<div class="col-md-4">
				<img src="images/dexuat.png" style="margin-top: -22px;" /> <span
					class="giamgia">Đề xuất cho bạn</span>
			</div>
		</div>
		<div class="row">
			<c:if test="${recommend.size() < 1}">
				<div class="text-center" style="color:gray;">
					<span><b>Chưa có dữ liệu</b></span>
				</div>
			</c:if>
			<c:forEach items="${recommend}" var="dx" end="3">
				<c:set var="slug" value="${dx.tinhthanh.slug}/${dx.slug}-r${dx.id}.html"/>
				<div class=col-md-3>
	
					<div class="row">
						<a class="linknhgiamgia" href="${slug}"><img class="hinhgiamgia"
							src="${dx.photopath}${dx.thumbnail}" /></a>
					</div>
					<div class="row text-center giantoptennh">
						<a href="${slug}"><span class="tennhgiamgia">${dx.tennhahang}</span></a>
					</div>
					<div class="row text-center">
						<div class="col-md-1"></div>
						<div class="col-md-10">
							<a href="${slug}"><span class="diachinhgiamgia">${dx.diachifull}</span></a>
						</div>
						<div class="col-md-1"></div>
					</div>
				</div>
			</c:forEach>
		<c:if test="${recommend.size() > 4 }">
			<div class="row">
				<div class="col-md-12 text-center linkxemthemgiamgia">
					<a href="#"><span class="xemthemgiamgia">Xem Thêm</span></a>
				</div>
			</div>
		</c:if>
	</div>
</div>