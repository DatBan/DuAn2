<%@ page pageEncoding="utf-8"%>
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
				
				<span style="margin-top: 30px; color: red; ">${message}</span>
			</div> 
			<script type="text/javascript"
						src="http://js.nicedit.com/nicEdit-latest.js"></script>
					<script type="text/javascript">
						//<![CDATA[
						bkLib.onDomLoaded(function() {
							new nicEditor({maxHeight : 300}).panelInstance('area1');
							new nicEditor({maxHeight : 300}).panelInstance('area2');
						});
						//]]>
					</script>
			<form name=themtrangmoi id="themtrangmoi"
				action="dashboard/trang/themtrangmoi.html" method="post">
				
				<div class="row rthemtrangmoi">
					<input style="display:none"  name ="idnd"type="text" value="${sessionScope.id}">
					
					<div class="form-group fullname-custom">
						<div class=" col-md-1"></div>
						<div class="col-md-10">
							<label class="control-label  labeld" for="tieude">Tiêu
								đề:<span style="color: red;">*</span>
							</label> <input type="text" name="tieude" id="tieude"
								placeholder="VD : Liên hệ" class="form-control">
						</div>
					</div>
				</div>
				
				<div class="row rthemtrangmoi">
					<div class="form-group fullname-custom">
						<div class=" col-md-1"></div>
						<div class="col-md-10">
							<label class="control-label  labeld" for="title">Title:<span style="color: red;">*</span>
							</label> <input type="text" name="title" id="title"
								placeholder="Example : Contact" class="form-control">
						</div>
					</div>
				</div>
				<div class="row rthemtrangmoi">
					<div class="form-group fullname-custom">
						<div class=" col-md-1"></div>

						<div class="col-md-10">
							<label class="control-label  labeld" for="slug">Slug:<span
								style="color: red;">*</span>
							</label> <input type="text" name="slug" id="slug" placeholder="Slug theo tiêu đề"
								class="form-control" readonly>
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
							<textarea name="area1" id="area1"  placeholder="Nội dung phải trên 200 ký tự" class="form-control"
								style="margin: 0px; min-height: 300px;" ></textarea>
						</div>
					</div>
				</div>
				<div class="row rthemtrangmoi">
					<div class="form-group fullname-custom">
						<div class=" col-md-1"></div>
						<div class="col-md-10">
							<label class="control-label  labeld" for="content">Content:<span style="color: red;">*</span>
							</label>
							<textarea name="area2" id="area2"  placeholder="Content phải trên 200 ký tự" class="form-control" 
								style="margin: 0px; min-height: 300px;"></textarea>
						</div>
					</div>
				</div>




				<div class="row rthemtrangmoi">
					<div class="col-md-3"></div>
					<div class="col-md-3">
						<input class="btn btn-success btn-block" type="submit"
							value="Thêm mới">
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