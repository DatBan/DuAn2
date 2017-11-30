<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%-- <!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Dashboard</title>
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
					<div class="row tieudethemtrang">

						<span style="margin-top: 30px; color: red;">${message}</span>
					</div>
					<script type="text/javascript"
						src="http://js.nicedit.com/nicEdit-latest.js"></script>
					<script type="text/javascript">
						//<![CDATA[
						bkLib.onDomLoaded(function() {
							new nicEditor({
								maxHeight : 300
							}).panelInstance('area1');
							new nicEditor({
								maxHeight : 300
							}).panelInstance('area2');
						});
						//]]>
					</script>
					<form name=editbaiviet id="editbaiviet"
						action="nguoidung/baiviet/suabv.html" method="post"
						enctype="multipart/form-data">
						<input style="display: none" name="idbv" type="text"
							value="${bv.id}" id="idbv">
						<div class="row rthemtrangmoi">

							<div class="form-group fullname-custom">
								<div class=" col-md-1"></div>
								<div class="col-md-10">
									<label class="control-label  labeld" for="td">Tiêu đề:<span
										style="color: red;">*</span>
									</label> <input type="text" name="tieude" id="tieude"
										value="${bv.tieude}"
										placeholder="VD: Tên món ăn hoặc tên nhà hàng"
										class="form-control">
								</div>
							</div>
						</div>

						<div class="row rthemtrangmoi">
							<div class="form-group fullname-custom">
								<div class=" col-md-1"></div>
								<div class="col-md-10">
									<label class="control-label  labeld" for="title">Name:<span
										style="color: red;">*</span>
									</label> <input type="text" name="name" id="name" value="${bv.name}"
										placeholder="Example : Name of food or restaurant"
										class="form-control">
								</div>
							</div>
						</div>
						<div class="row rthemtrangmoi">
							<div class="form-group fullname-custom">
								<div class=" col-md-1"></div>

								<div class="col-md-10">
									<label class="control-label  labeld" for="slug">Slug:<span
										style="color: red;">*</span>
									</label> <input type="text" name="slug" id="slug" value="${bv.slug}"
										placeholder="Slug theo tiêu đề" class="form-control" readonly>
								</div>
							</div>
						</div>
						<div class="row rthemtrangmoi">
							<div class="form-group fullname-custom">
								<div class=" col-md-1"></div>

								<div class="col-md-10">
									<label class="control-label  labeld" for="slug">Loại
										bài viết:<span style="color: red;">*</span>
									</label> <select class="from-control" name="idloai"
										style="margin-left: 10px;">
										<c:forEach var="loai" items="${loaibv}">
											<c:choose>
												<c:when test="${bv.loaibv.id == loai.id}">
													<option value="${loai.id}" selected>
														${loai.tenloai}</option>
												</c:when>
												<c:otherwise>
													<option value="${loai.id}">${loai.tenloai}</option>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</select>
								</div>
							</div>
						</div>
						<div class="row rthemtrangmoi">
							<div class="form-group fullname-custom">
								<div class=" col-md-1"></div>
								<div class="col-md-10">
									<label class="control-label  labeld " style="float: left;"
										for="hinh">Chọn ảnh:<span style="color: red;">*</span>
									</label>
									<div class="col-md-6 col-sm-6 col-xs-12">
										<input type="file" name="hinh" id="hinh"
											class="form-control col-md-7 col-xs-12" style="border: none;" />
										<img
											src="${pageContext.servletContext.contextPath }/upload/baiviet/${bv.hinh}"
											id="viewhinh" class="img-responsive hinh" />
									</div>
								</div>
							</div>
						</div>
						<div class="row rthemtrangmoi">
							<div class="form-group fullname-custom">
								<div class=" col-md-1"></div>
								<div class="col-md-10">
									<label class="control-label  labeld" for="noidung">Nội
										dung:<span style="color: red;">*</span>
									</label>
									<textarea name="area1" id="area1" placeholder=""
										class="form-control" style="margin: 0px; min-height: 300px;">${bv.noidung}</textarea>
								</div>
							</div>
						</div>
						<div class="row rthemtrangmoi">
							<div class="form-group fullname-custom">
								<div class=" col-md-1"></div>
								<div class="col-md-10">
									<label class="control-label  labeld" for="content">Content:<span
										style="color: red;">*</span>
									</label>
									<textarea name="area2" id="area2" placeholder=""
										class="form-control" style="margin: 0px; min-height: 300px;">${bv.noidung}</textarea>
								</div>
							</div>
						</div>
						<div class="row rthemtrangmoi">
							<div class="form-group fullname-custom">
								<div class=" col-md-1"></div>

								<div class="col-md-10">
									<label class="control-label  labeld" for="slug">Mô tả:
									</label> <input type="text" name="mota" id="mota" value="${bv.mota}"
										placeholder="Mô tả bài viết" class="form-control">
								</div>
							</div>
						</div>



						<div class="row rthemtrangmoi">
							<div class="col-md-3"></div>
							<div class="col-md-3">
								<input class="btn btn-success btn-block" type="submit"
									value="Sửa bài viết">
							</div>
							<div class="col-md-3">
								<a href="${btn_back}" class="btn btn-warning btn-block"
									type="button">Huỷ</a>
							</div>
							<div class="col-md-3"></div>

						</div>

					</form>
				<%-- </div>
			</div>
			<!------------------- Footer dashboard------------ -->
			<jsp:include page="/include-dashboard/footer.jsp"></jsp:include>
		</div>
	</div>

</body>

</html> --%>