<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
				<jsp:include page="/include-dashboard/nutbam-header.jsp"></jsp:include>

				<!--------------- Table, form cac thu ---------------->
			<div class="content-nhe"> --%>
			<div class="row tieudethemtrang">
				<span style="margin-top: 30px; color: red; ">${message}</span>
			</div> 
			<script type="text/javascript" src="http://js.nicedit.com/nicEdit-latest.js"></script>
			<!-- <script type="text/javascript">
				//<![CDATA[
					bkLib.onDomLoaded(function() {
					new nicEditor({maxHeight : 300}).panelInstance('gioithieu');
					/* new nicEditor({maxHeight : 300}).panelInstance('area2');
					new nicEditor({maxHeight : 300}).panelInstance('area3'); */
				});
				//]]>
			</script> -->
			<form class="clearfix" id="themnhahang"
				action="dashboard/restaurants-mng/themnhahang.html" enctype="multipart/form-data"  method="post">
				<div class="row">
					<div class="form-group col-md-6 clearfix">
						<label class="" for="number">
							Tên nhà hàng <span class="required">*</span>
						</label>
						<input type="text" class="form-control" id="tennhahang" name="tennhahang"/>
					</div>
					
					<div class="form-group col-md-6 clearfix">
						<label class="" for="number">
							Loại ẩm thực <span class="required">*</span>
						</label>
						<input type="hidden" class="form-control" id="slug" name="slug"/>
						<select id="loaiamthuc" class="form-control" name="loaiamthuc.id">
							<option value="">-Lựa chọn-</option>
							<c:forEach items="${loaiamthuc}" var="lat">
								<option value="${lat.id}">${lat.tenloai}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-6 clearfix">
						<label class="" for="number">
							Địa chỉ <span class="required">*</span>
						</label>
						<input type="text" class="form-control" name="diachi" id="diachi" placeholder="Số nhà và tên đường"/>
					</div>
					
					<div class="form-group col-md-6 clearfix">
						<label class="" for="number">
							Tỉnh/thành phố <span class="required">*</span>
						</label>
						<select id="province" class="form-control" name="tinhthanh.id">
							<option value="">-Lựa chọn-</option>
							<c:forEach items="${tinhthanh}" var="tp">
								<option value="${tp.provinceid}">${tp.name}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-6 clearfix">
						<label class="" for="number">
							Quận/huyện <span class="required">*</span>
						</label>
						<select id="district" class="form-control" name="quanhuyen.id">
							<option>-Chọn tỉnh/thành-</option>
						</select>
					</div>				
					
					<div class="form-group col-md-6 clearfix">
						<label class="" for="number">
							Phường/xã <span class="required">*</span>
						</label>
						<select id="ward" class="form-control" name="phuongxa.id">
							<option>-Chọn quận/huyện-</option>
						</select>
					</div>
				</div>
				
				<div class="row">
					<div class="form-group col-md-6 clearfix">
						<label class="" for="number">
							SĐT <span class="required">*</span>
						</label>
						<input type="text" class="form-control" name="sdt" placeholder="0123456789"/>
					</div>
					
					<div class="form-group col-md-6 clearfix">
						<label class="" for="number">
							Người dùng <span class="required">*</span>
						</label>
						<select class="form-control" name="nguoidung.id">
							<option value="">-Lựa chọn-</option>
							<c:forEach items="${listnd}" var="tp">
								<option value="${tp.id}">${tp.hoTen}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				
				<div class="row">
					<div class="form-group col-md-6 clearfix">
						<label class="" for="number">
							Mở cửa <span class="required">*</span>
						</label>
						<input type="time" class="timepicker form-control"/>
					</div>
					<div class="form-group col-md-6 clearfix">
						<label class="" for="number">
							Đóng cửa <span class="required">*</span>
						</label>
						<input type="time" class="timepicker form-control"/>
					</div>
				</div>
				
				<div class="row">
					<div class="form-group col-md-6 clearfix">
						<label class="" for="number">
							Hình đại diện <span class="required">*</span>
						</label>
						<input type="file" class="form-control" id="thumbnail" name="thumbnail"/>
						<img id="output"/>
					</div>
				</div>
				
				<div class="row">
					<div class="form-group col-md-12 clearfix">
						<label class="" for="number">
							Giới thiệu nhà hàng <span class="required">*</span>
						</label>
						<textarea class="form-control" id="gioithieu" rows="10" name="gioithieu"></textarea>
					</div>
				</div>
								
				<div class="item form-group col-md-12 clearfix">
					<input class="btn btn-success" type="submit" value="Submit">
					<a href="${btn_back}" class="btn btn-warning" type="button">Huỷ</a>
				</div>

			</form>
			<%-- </div>
			</div>
			<!------------------- Footer dashboard------------ -->
						<jsp:include page="/include-dashboard/footer.jsp"></jsp:include>
		</div>
	</div> --%>
	<script type="text/javascript">
		$(document).ready(function(){
			$('.timepicker').qcTimepicker({
				'format': 'HH:mm',
				'minTime': '7:00:00',
				'maxTime': '23:30:00',
				'step': 900,
				'placeholder': 'halo halo'
			});
			$("#qcTimepicker-0").attr({"class": "form-control", "name": "giomocua"});
			$("#qcTimepicker-1").attr({"class": "form-control", "name": "giodongcua"});
		});
	</script>
<!-- </body>

</html> -->