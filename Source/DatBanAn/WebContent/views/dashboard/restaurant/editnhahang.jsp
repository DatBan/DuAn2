<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%-- <!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>Cập nhật thông tin nhà hàng</title>
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
				<c:if test="${updatestt == 'error'}">
					<div class="alert alert-danger">
						<span>Cập nhật</span> <strong>thất bại</strong>! Vui lòng thử lại.
					</div>
				</c:if>
				<c:if test="${updatestt == 'success'}">
					<div class="alert alert-success">
						<span>Cập nhật</span> <strong>thành công</strong>!
					</div>
				</c:if>
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
			<form:form class="clearfix" id="editnhahang"
				action="dashboard/restaurants-mng/editnhahang.html" enctype="multipart/form-data" modelAttribute="nhahango" method="post">
				<div class="row">
					<div class="form-group col-md-6 clearfix">
						<label class="" for="number">
							Tên nhà hàng <span class="required">*</span>
						</label>
						<form:input path="tennhahang" cssClass="form-control" id="tennhahang"/>
					</div>
					<div class="form-group col-md-6 clearfix">
						<label class="" for="number">
							Loại ẩm thực <span class="required">*</span>
						</label>
						<form:hidden path="slug" class="form-control" id="slug"/>
						<form:select path="loaiamthuc.id" id="loaiamthuc" class="form-control" items="${loaiamthuc}" itemLabel="tenloai" itemValue="id"/>
							<!-- <option value="">-Lựa chọn-</option> -->
					</div>
				</div>
				
				<div class="row">
					<div class="form-group col-md-6 clearfix">
						<label class="" for="number">
							Địa chỉ <span class="required">*</span>
						</label>
						<form:input path="diachi" class="form-control"/>
					</div>
					
					<div class="form-group col-md-6 clearfix">
						<label class="" for="number">
							Tỉnh/thành phố <span class="required">*</span>
						</label>
						<form:select path="tinhthanh.provinceid" id="province" cssClass="form-control">
							<form:option value="" label="-Lựa chọn-"/>
							<form:options items="${tinhthanh}" itemValue="provinceid" itemLabel="name"/>
						</form:select>
						<%-- <select id="province" class="form-control" name="tinhthanh.id">
							<option value="">-Lựa chọn-</option>
							<c:forEach items="${tinhthanh}" var="tp">
								<option value="${tp.provinceid}">${tp.name}</option>
							</c:forEach>
						</select> --%>
					</div>
				</div>
				
				<div class="row">
					<div class="form-group col-md-6 clearfix">
						<label class="" for="number">
							Quận/huyện <span class="required">*</span>
						</label>
						<form:select path="quanhuyen.districtid" id="district" cssClass="form-control">
							<form:option value="" label="-Lựa chọn-"/>
							<form:options items="${quanhuyen}" itemValue="districtid" itemLabel="labelfull"></form:options>
						</form:select>
					</div>
					
					<div class="form-group col-md-6 clearfix">
						<label class="" for="number">
							Phường/xã <span class="required">*</span>
						</label>
						<form:select path="phuongxa.wardid" id="ward" cssClass="form-control">
							<form:option value="" label="-Lựa chọn-"/>
							<form:options items="${phuongxa}" itemValue="wardid" itemLabel="labelfull"></form:options>
						</form:select>
					</div>
				</div>
				
				<div class="row">
					<div class="form-group col-md-6 clearfix">
						<label class="" for="number">
							SĐT <span class="required">*</span>
						</label>
						<form:input path="sdt" class="form-control"/>
					</div>
					
					<div class="form-group col-md-6 clearfix">
						<label class="" for="number">
							Người dùng <span class="required">*</span>
						</label>
						<select class="form-control" name="nguoidung.id">
							<c:forEach items="${listnd}" var="tp">
								<c:choose>
									<c:when test="${tp.quyennd.id == 2 && tp.nhahang.id == nhahango.id}">
										<option value="${tp.id}" selected="selected">${tp.hoTen}</option>
									</c:when>
									<c:otherwise><option value="${tp.id}">${tp.hoTen}</option></c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</div>
				</div>
				
				<div class="row">
					<div class="form-group col-md-6 clearfix">
						<label class="" for="number">
							Mở cửa <span class="required">*</span>
						</label>
						<input type="hidden" value="${nhahango.giomocua}" id="start_time"/>
						<input type="time" class="timepicker form-control"/>
					</div>
					<div class="form-group col-md-6 clearfix">
						<label class="" for="number">
							Đóng cửa <span class="required">*</span>
						</label>
						<input type="hidden" value="${nhahango.giodongcua}" id="end_time"/>
						<input type="hidden" name="idnhahang" readonly="readonly" value="${nhahango.id}"/>
						<input type="time" class="timepicker form-control"/>
					</div>
				</div>
				
				<div class="row">
					<div class="form-group col-md-6 clearfix">
						<label class="" for="number">
							Hình đại diện <span class="required">*</span>
						</label>
						<input type="file" class="form-control" id="thumbnail" name="thumbnail"/>
						<img id="output" src="${nhahango.photopath}${nhahango.thumbnail}" class="img-response" style="width: 200px;"/>
					</div> 
					
					<div class="form-group col-md-6 clearfix">
						<label class="" for="number">
							Ngày tạo <span class="required">*</span>
						</label>
						<input type="text" disabled class="form-control"
										placeholder='<fmt:formatDate value="${nhahango.ngaytao}" pattern="dd/MM/yyyy HH:mm:ss"/>'>
					</div>
				</div>
				<div class="form-group col-md-12 clearfix">
					<label class="" for="number">
						Giới thiệu nhà hàng <span class="required">*</span>
					</label>
					<form:textarea path="gioithieu" class="form-control" id="gioithieu" rows="10"></form:textarea>
				</div>
								
				<div class="item form-group col-md-12 clearfix">
					<input class="btn btn-success" type="submit" value="Submit">
					<a href="${btn_back}" class="btn btn-warning" type="button">Huỷ</a>
				</div>

			</form:form>
			<%-- </div>
			</div>
			<!------------------- Footer dashboard------------ -->
						<jsp:include page="/include-dashboard/footer.jsp"></jsp:include>
		</div>
	</div> --%>
	<script type="text/javascript">
		$(document).ready(function () {
			$('.timepicker').qcTimepicker({
				'format': 'HH:mm',
				'minTime': '7:00:00',
				'maxTime': '23:30:00',
				'step': 900,
				'placeholder': 'halo halo'
			});
			$("#qcTimepicker-0").attr({"class": "form-control", "name": "giomocua"});
			$("#qcTimepicker-1").attr({"class": "form-control", "name": "giodongcua"});
			
			$("#qcTimepicker-0").val($("#start_time").val());
			$("#qcTimepicker-1").val($("#end_time").val());
		});
	</script>
<!-- </body>

</html> -->