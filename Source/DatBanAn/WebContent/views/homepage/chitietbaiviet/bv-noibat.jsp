<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div class="col-md-4">
	<div class="panel panel-default">
			<div class="panel-heading">
				<p style="font-size: 18px;">
					<b>Bài viết nổi bật</b>
				</p>
			</div>
		<div class="panel-body">
		<c:forEach var="bv" items="${bv}">
			<c:set var="slug" value="bai-viet/${bv.slug}-p${bv.id}.html"></c:set>
			<div class="row rbv">
				<div class="col-md-5">
					<a href="${slug}"><img class="img-responsive" alt="" src="upload/baiviet/${bv.hinh}"></a>
				</div>
	
				<div class="col-md-7">
					<div class="row" style="margin-bottom: 10px;">
						<a href="${slug}"><span>${fn:substring(bv.tieude,0,80)}...</span></a>
					</div>
				</div>
	
			</div>
			<div class="row">
				<img src="images/linekm.png" style="width: 99%; padding-left: 15px; opacity: 0.1;" />
			</div>
	
		</c:forEach>
		</div>
	</div>
</div>