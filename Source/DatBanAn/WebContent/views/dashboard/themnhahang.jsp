<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Dashboard</title>
<jsp:include page="/include-dashboard/headtag.jsp"></jsp:include>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Dashboard</title>
<jsp:include page="/include/headtag.jsp"></jsp:include>
<jsp:include page="/include/form-timkiem.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="/include/header.jsp"></jsp:include>

	<div class="wrapper">
		<!----------------------------- Sidebar ----------------------------------->


		<!-- Menu top, content -->
		<div id="content">
			<!---------------------------- header-top------------------------------->

			<!-- main content -->
			<div class="main-content">
				<!------------- Breadcrumb, nut bam cac thu -------------->

				<!--------------- Table, form cac thu ---------------->
			<div class="content-nhe">
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
							new nicEditor({maxHeight : 300}).panelInstance('area3');
						});
						//]]>
					</script>
			<form name=themnhahang id="themnhahang"
				action="nhahang/themnhahang.html" enctype="multipart/form-data"  method="post">
				
				<div class="row rthemtrangmoi">
					<input style="display:none"  name ="idnd"type="text" value="${sessionScope.id}">
					<div class="form-group fullname-custom">
						<div class=" col-md-1"></div>
						<div class="col-md-10">
							<label class="control-label  labeld" for="tieude"> Tên nhà hàng:
								<span style="color: red;">*</span>
							</label> <input type="text" name="tennhahang" id="tennhahang"
								placeholder="VD : Liên hệ" class="form-control">
						</div>
					</div>
				</div>
				
				<div class="row rthemtrangmoi">
					<div class="form-group fullname-custom">
						<div class=" col-md-1"></div>
						<div class="col-md-10">
							<label class="control-label  labeld" for="title">Tên:<span style="color: red;">*</span>
							</label> <input type="text" name="name" id="name"
								placeholder="VD : Contact" class="form-control">
						</div>
					</div>
				</div>
				<div class="row rthemtrangmoi">
					<div class="form-group fullname-custom">
						<div class=" col-md-1"></div>
						<div class="col-md-10">
							<label class="control-label  labeld" for="title">Địa chỉ:<span style="color: red;">*</span>
							</label> <input type="text" name="diachi" id="diachi"
								placeholder="VD : Contact" class="form-control">
						</div>
					</div>
				</div>
				<div class="row rthemtrangmoi">
					<div class="form-group fullname-custom">
						<div class=" col-md-1"></div>
						<div class="col-md-10">
							<label class="control-label  labeld" for="title">Địa chỉ 2:<span style="color: red;">*</span>
							</label> <input type="text" name="address" id="address"
								placeholder="VD : Contact" class="form-control">
						</div>
					</div>
				</div>
				<div class="row rthemtrangmoi">
					<div class="form-group fullname-custom">
						<div class=" col-md-1"></div>
						<div class="col-md-10">
							<label class="control-label  labeld" for="title">Tỉnh thành:<span style="color: red;">*</span>
							</label> <input type="text" name="tinhthanh" id="tinhthanh"
								placeholder="VD : Contact" class="form-control">
						</div>
					</div>
				</div>
				<div class="row rthemtrangmoi">
					<div class="form-group fullname-custom">
						<div class=" col-md-1"></div>
						<div class="col-md-10">
							<label class="control-label  labeld" for="title">Thành phố:<span style="color: red;">*</span>
							</label> <input type="text" name="city" id="city"
								placeholder="VD : Contact" class="form-control">
						</div>
					</div>
				</div>
				<div class="row rthemtrangmoi">
					<div class="form-group fullname-custom">
						<div class=" col-md-1"></div>
						<div class="col-md-10">
							<label class="control-label  labeld" for="title">Quận huyện:<span style="color: red;">*</span>
							</label> <input type="text" name="quanhuyen" id="quanhuyen"
								placeholder="VD : Contact" class="form-control">
						</div>
					</div>
				</div>
				<div class="row rthemtrangmoi">
					<div class="form-group fullname-custom">
						<div class=" col-md-1"></div>
						<div class="col-md-10">
							<label class="control-label  labeld" for="title">Huyện:<span style="color: red;">*</span>
							</label> <input type="text" name="district" id="district"
								placeholder="VD : Contact" class="form-control">
						</div>
					</div>
				</div>
				<div class="row rthemtrangmoi">
					<div class="form-group fullname-custom">
						<div class=" col-md-1"></div>
						<div class="col-md-10">
							<label class="control-label  labeld" for="title">Phường xã:<span style="color: red;">*</span>
							</label> <input type="text" name="phuongxa" id="phuongxa"
								placeholder="VD : Contact" class="form-control">
						</div>
					</div>
				</div>
				<div class="row rthemtrangmoi">
					<div class="form-group fullname-custom">
						<div class=" col-md-1"></div>
						<div class="col-md-10">
							<label class="control-label  labeld" for="title">Khu:<span style="color: red;">*</span>
							</label> <input type="text" name="ward" id="ward"
								placeholder="VD : Contact" class="form-control">
						</div>
					</div>
				</div>
				<div class="row rthemtrangmoi">
					<div class="form-group fullname-custom">
						<div class=" col-md-1"></div>
						<div class="col-md-10">
							<label class="control-label  labeld" for="title">Số điện thoại:<span style="color: red;">*</span>
							</label> <input type="text" name="sdt" id="sdt"
								placeholder="VD : Contact" class="form-control">
						</div>
					</div>
				</div>
				<div class="row rthemtrangmoi">
					<div class="form-group fullname-custom">
						<div class=" col-md-1"></div>
						<div class="col-md-10">
							<label class="control-label  labeld" for="title">Hình ảnh:<span style="color: red;">*</span>
							</label> <input type="file"  name="thumbnail" id="thumbnail"
							
								placeholder="VD : Contact" class="form-control">
							
						</div>
					</div>
				</div>
				<div class="row rthemtrangmoi">
					<div class="form-group fullname-custom">
						<div class=" col-md-1"></div>
						<div class="col-md-10">
							<label class="control-label  labeld" for="title">Trạng thái:<span style="color: red;">*</span>
							</label> <input type="text" name="name" id="name"
								placeholder="VD : Contact" class="form-control">
						</div>
					</div>
				</div>
				<div class="row rthemtrangmoi">
					<div class="form-group fullname-custom">
						<div class=" col-md-1"></div>

						<div class="col-md-10">
							<label class="control-label  labeld" for="slug">Slug:<span
								style="color: red;">*</span>
							</label> <input type="text" name="slug" id="slug" placeholder="Nhập Slug"
								class="form-control">
						</div>
					</div>
				</div>
				<div class="row rthemtrangmoi">
					<div class="form-group fullname-custom">
						<div class=" col-md-1"></div>
						<div class="col-md-10">
							<label class="control-label  labeld" for="noidung">Về chúng tôi:<span style="color: red;">*</span>
							</label>
							<textarea name="area1" id="area1"  placeholder="" class="form-control"
								style="margin: 0px; min-height: 300px;" ></textarea>
						</div>
					</div>
				</div>
				<div class="row rthemtrangmoi">
					<div class="form-group fullname-custom">
						<div class=" col-md-1"></div>
						<div class="col-md-10">
							<label class="control-label  labeld" for="content">Giới thiệu:<span style="color: red;">*</span>
							</label>
							<textarea name="area2" id="area2"  placeholder="" class="form-control" 
								style="margin: 0px; min-height: 300px;"></textarea>
						</div>
					</div>
				</div>
				<div class="row rthemtrangmoi">
					<div class="form-group fullname-custom">
						<div class=" col-md-1"></div>
						<div class="col-md-10">
							<label class="control-label  labeld" for="content">Mô tả:<span style="color: red;">*</span>
							</label>
							<textarea name="area3" id="area3"  placeholder="" class="form-control" 
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
						<a href="trang/index.html" class="btn btn-warning btn-block"
							type="button">Huỷ</a>
					</div>
					<div class="col-md-3"></div>

				</div>

			</form>
			</div>
			</div>
			<!------------------- Footer dashboard------------ -->
						<jsp:include page="/include-dashboard/footer.jsp"></jsp:include>
		</div>
	</div>

</body>

</html>