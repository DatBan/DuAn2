<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%-- <!DOCTYPE html>
<html>
<head>
<meta content="text/html; charset=UTF-8">
<title>Đặt Bàn</title>
<jsp:include page="/include/headtag.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="/include/header.jsp"></jsp:include> --%>
	<div class="container cdatban">
		<div class="row rdatban">
			<div class="col-md-1"></div>
			<div class="col-md-7 coldatban">
				<div class="row">
					<p style="font-size: 24px;">
						<b>Nhà Hàng: <span class="dbtennhahang">${nhahang.tennhahang}</span></b>
					</p>
				</div>
				<div class="row rdcnhdb">
					<span>${nhahang.diachi}</span>
				</div>
				<div class="row text-center "
					style="margin-bottom: 20px; color: #00b100; font-size: 18px;">

					<div class="col-md-10">
						<span><b>${message}</b></span>
					</div>

					<div class="col-md-2"></div>
				</div>
				<div class="row formdatban col-md-11">
					<form name="datban" id="datban" action="datban/xacnhandatban.html"
						method="post" class="">
						<input style="display: none" name="idkhuyenm" type="text"
							value="${khuyenmai.id}">
						<input style="display: none" name="idnhahang" type="text"
							value="${nhahang.id}"> <input style="display: none"
							name="idnguoidung" type="text" value="${sessionScope.id}">
							<c:choose>
								<c:when test="${sessionScope.tdn != null}">
									<div class="row text-center cotkrdn">
										<span>Có tài khoản rồi? <a href="javascript:;"
											class="linkdangnhap"
											style="padding-top: 6px; padding-left: 10px; padding-bottom: 6px; padding-right: 10px; margin-top: 9px; color: #057ee6; font-size: 15px; border: none; margin-right: 10px;"
											data-toggle="modal" data-target="#myModal"> <b>Đăng nhập</b></a></span>
									</div>
								</c:when>
								<c:otherwise>
								
								</c:otherwise>
							</c:choose>
						<div class="row rdbho">
							<div class="col-md-1"></div>
							<div class="col-md-5">
								<input class="form-control" type="text" name="ho" placeholder="Họ" value="${sessionScope.nd.ho}"  />
							</div>
							<div class="col-md-5">
								<input class="form-control" type="text" name="ten" placeholder="Tên" value="${sessionScope.nd.ten}"/>
							</div>
							<div class="col-md-1"></div>
						</div>
						<div class="row rdbho">
							<div class="col-md-1"></div>
							<div class="col-md-5">
								<input class="form-control" type="text" name="ngaythang" id="ngaythang1"
									placeholder="Chọn ngày" readonly="readonly"
									style="cursor: pointer;  background-color: #FFFFFF">
							</div>
							<div class="col-md-5">
								<input class="form-control" type="time" class="timepicker chontg" id="thoigian">
							</div>
							<div class="col-md-1"></div>
						</div>
						<div class="row rdbho">
							<div class="col-md-1"></div>
							<div class="col-md-5">
								<select  name="songuoi" class="optionheight so-nguoi form-control">
									<!-- <option value="1">1 người</option>
									<option value="2">2 người</option> -->
								</select>
							</div>
							<div class="col-md-5">
								<select name="nhandip" class="optionheight nhan-dip form-control">
									<option value="Kỷ niệm">Kỷ niệm</option>
									<option value="Sinh Nhật">Sinh Nhật</option>
									<option value="Khác">Khác</option>
								</select>
							</div>
							<div class="col-md-1"></div>
						</div>
						<div class="row rdbho">
							<div class="col-md-1"></div>
							<div class="col-md-5">
								<input class="form-control" type="text" name="sdt" placeholder="Số điện thoại" value="${sessionScope.nd.sdt}"/>
							</div>
							<div class="col-md-5">
								<input class="form-control" type="text" name="email" placeholder="Email" value="${sessionScope.nd.email}"/>
							</div>
							<div class="col-md-1"></div>
						</div>
						<div class="row rdbho">
							<div class="col-md-1"></div>
							<div class="col-md-10">
								<textarea  name="ghichu" id="ghichu" placeholder="Ghi chú"
									class="form-control"
									style="min-height: 120px; max-height: 120px; min-width: 100%; max-width: 100%;"></textarea>
							</div>

							<div class="col-md-1"></div>
						</div>
						<div class="row rdbho">
							<div class="col-md-1"></div>
							<div class="col-md-10">
								<input type="checkbox" name="check" checked="checked" /> Nhận
								email thông báo khuyến mãi từ nhà hàng này
							</div>
							<div class="col-md-1"></div>
						</div>
						<div class="row">
							<div class="col-md-1"></div>
							<div class="col-md-10 xndatcho">
								<input class="btn btn-success btn-block" type="submit"
									value="Xác nhận đặt chỗ">
							</div>
							<div class="col-md-1"></div>

						</div>

					</form>

				</div>
				<div class="col-md-1"></div>
			</div>
			<div class="col-md-4">
				<div class="col-md-11 ">
					<div class="row dbttkm cdbthongtin">
						<div class="col-md-12">
							<p class="pdatbanttkm">
								<b>Thông tin khuyến mãi</b>
							</p>
							<span>Theo chân Chrome, Firefox, Opera, trình duyệt Edge
								của Microsoft giờ cũng có khả năng tắt tiếng trên các tab đang
								mở, tiện khi cần tắt nhạc tạm thời hay tắt những tab nào phát âm
								thanh quảng cáo dưới nền. Những tab nào đang phát âm thanh sẽ có
								một icon hình cái loa dễ nhận biết. Ngoài việc nhấn từ tab, bạn
								cũng có thể dùng menu chuột phải như hình trên. Thay đổi này
								xuất hiện trong bản Windows 10 Build 17035 mới được phát hành
								cho người dùng Insider hồi sáng nay, chưa rõ khi nào thì sẽ
								update cho những người dùng chính thức. Hóng cái này ghê vì mình
								thích dùng Edge do nhẹ và nhanh.</span>
						</div>
					</div>
					<div class="row dbttkm cdbthongtin">
						<div class="col-md-12">
							<p class="pdatbanttkm">
								<b>Chú ý của nhà hàng</b>
							</p>
							<span>Theo chân Chrome, Firefox, Opera, trình duyệt Edge
								của Microsoft giờ cũng có khả năng tắt tiếng trên các tab đang
								mở, tiện khi cần tắt nhạc tạm thời hay tắt những tab nào phát âm
								thanh quảng cáo dưới nền. Những tab nào đang phát âm thanh sẽ có
								một icon hình cái loa dễ nhận biết. Ngoài việc nhấn từ tab, bạn
								cũng có thể dùng menu chuột phải như hình trên. Thay đổi này
								xuất hiện trong bản Windows 10 Build 17035 mới được phát hành
								cho người dùng Insider hồi sáng nay, chưa rõ khi nào thì sẽ
								update cho những người dùng chính thức. Hóng cái này ghê vì mình
								thích dùng Edge do nhẹ và nhanh.</span>
						</div>
					</div>
				</div>
				<div class="col-md-1"></div>
			</div>
		</div>
	</div>
	<%-- <jsp:include page="/include/footer.jsp"></jsp:include> --%>
	<script>
		/* $(document).ready(function(){ */
		$(document).ready(function() {
			var so_nguoi = document.getElementsByClassName('so-nguoi');
			$('.so-nguoi').empty();
			for (var i = 1; i < 100; i++) {
				var opt = document.createElement('option');
				opt.innerHTML = i + " người";
				opt.value = i;
				$('.so-nguoi').append(opt);
			}
		});
		$(function() {
			$('#thoigian').qcTimepicker({
				'format' : 'H:mm',
				'minTime' : '7:00:00',
				'maxTime' : '23:30:00',
				'step' : 900,
				'placeholder' : 'halo halo'
			});
			
			$("#thoigian-qcTimepicker").attr({"class": "chontg form-control", "name": "thoigian"});
			$("#ngaythang1").datepicker({
				dateFormat : "dd/mm/yy",
				gotoCurrent : true,
				minDate : 0
			}).datepicker("setDate", new Date());
		});
		/* }); */
	</script>
<!-- </body>
</html> -->