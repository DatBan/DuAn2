<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%-- <!DOCTYPE html>
<html>
<head>
<meta content="text/html; charset=UTF-8">
<title>Insert title here</title>

<jsp:include page="/include/headtag.jsp"></jsp:include>

</head>
<body> --%>

<div class="container conbv">
	<div class="row">
		<div class="col-md-8">
			<c:forEach var="bv" items="${bv}">
				<div class="row rbv">
					<div class="col-md-5">
						<a href="chitietbaiviet.html?idbv=${bv.id}"><img class="img-responsive" alt="" src="upload/baiviet/${bv.hinh}"></a>
					</div>
					<div class="col-md-7">
						<div class="row" style="margin-bottom: 10px;">
							<a href="chitietbaiviet.html?idbv=${bv.id}"><span style="font-size: 16px;"><b>${fn:substring(bv.tieude,0,55)}...</b></span></a>
						</div>
						<div class="row">
							<a href="chitietbaiviet.html?idbv=${bv.id}"><span>${fn:substring(bv.noidung,0,630)}...</span></a>
						</div>

					</div>

				</div>
				<div class="row">
					<img src="images/linekm.png"
						style="width: 99%; padding-left: 15px; opacity: 0.1;" />
				</div>

			</c:forEach>
			<div class="row">

				<div class="col-md-12 text-center linkxemthemgiamgia">
					<a href="#"><span class="xemthemdg">Xem Thêm</span></a>
				</div>

			</div>
		</div>

		<div class="col-md-4">
		
			<div class="row text-center rbv">
				<p style="font-size: 20px;">
					<b>Bài viết nổi bật</b>
				</p>
			</div>

			<c:forEach var="bv" items="${bv}">
				<div class="row rbv">
					<div class="col-md-5">
						<a href="chitietbaiviet.html?idbv=${bv.id}"><img class="img-responsive" alt="" src="upload/baiviet/${bv.hinh}"></a>
					</div>
					
					<div class="col-md-7">
						<div class="row" style="margin-bottom: 10px;">
							<a href="chitietbaiviet.html?idbv=${bv.id}"><span>${fn:substring(bv.tieude,0,80)}...</span></a>
							
						</div>


					</div>
					
				</div>
				<div class="row">
					<img src="images/linekm.png"
						style="width: 99%; padding-left: 15px; opacity: 0.1;" />
				</div>

			</c:forEach>
			
		</div>
		
	</div>
	
</div>


<!-- 



	
</body>
</html> -->