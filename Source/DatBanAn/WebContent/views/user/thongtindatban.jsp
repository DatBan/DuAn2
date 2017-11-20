<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta content="text/html; charset=UTF-8">
<title>Thông tin đặt bàn</title>
<jsp:include page="/include/headtag.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="/include/header.jsp"></jsp:include>
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
				<div class="row  text-center "
					style="margin-bottom: 20px; color: #00b100; font-size: 18px;">

					<div class="col-md-10">
						<span><b>Đặt bàn thành công vui lòng chờ nhà hàng xác
								nhận!</b></span>
					</div>

					<div class="col-md-2"></div>
				</div>
				<div class="row cdbthongtin col-md-11">
					<div class="row text-center cotkrdn">
						<span><b>Thông tin đặt bàn của bạn</b></span>
					</div>
					<div class="row rdbho">
						<div class="col-md-1"></div>
						<div class="col-md-5">
							<span><b>Mã hoá đơn: </b></span>
						</div>
						<div class="col-md-5">
							<span style="color: red">${hoadon.id} </span>
						</div>
						<div class="col-md-1"></div>
					</div>
					<div class="row rdbho">
						<div class="col-md-1"></div>
						<div class="col-md-5">
							<span><b>Họ tên: </b></span>
						</div>
						<div class="col-md-5">
							<span>${hoadon.ho} ${hoadon.ten}</span>
						</div>
						<div class="col-md-1"></div>
					</div>
					<div class="row rdbho">
						<div class="col-md-1"></div>
						<div class="col-md-5">
							<span><b>Số điện thoại: </b></span>
						</div>
						<div class="col-md-5">
							<span>${hoadon.dienthoai}</span>
						</div>
						<div class="col-md-1"></div>
					</div>	
					<div class="row rdbho">
						<div class="col-md-1"></div>
						<div class="col-md-5">
							<span><b>Email: </b></span>
						</div>
						<div class="col-md-5">
							<span>${hoadon.email}</span>
						</div>
						<div class="col-md-1"></div>
					</div>
					<div class="row rdbho">
						<div class="col-md-1"></div>
						<div class="col-md-5">
							<span><b>Nhân dịp: </b></span>
						</div>
						<div class="col-md-5">
							<span>${hoadon.nhandip}</span>
						</div>
						<div class="col-md-1"></div>
					</div>
					<div class="row rdbho">
						<div class="col-md-1"></div>
						<div class="col-md-5">
							<span><b>Số người:</b> </span>
						</div>
						<div class="col-md-5">
							<span>${hoadon.songuoi}</span>
						</div>
						<div class="col-md-1"></div>
					</div>
					<div class="row rdbho">
						<div class="col-md-1"></div>
						<div class="col-md-5">							
							<span><b>Đặt ngày: </b></span>
						</div>
						<div class="col-md-5">
							<fmt:formatDate var="ngaythang" value="${hoadon.ngaythang}"
									pattern="dd-MM-yyyy" />
							<span>${ngaythang}</span>
						</div>
						<div class="col-md-1"></div>
					</div>
					<div class="row rdbho">
						<div class="col-md-1"></div>
						<div class="col-md-5">							
							<span><b>Thời gian: </b></span>
						</div>
						<div class="col-md-5">
							
							<span>${hoadon.thoigian}</span>
						</div>
						<div class="col-md-1"></div>
					</div>
					<div class="row rdbho">
						<div class="col-md-1"></div>
						<div class="col-md-5">
							<span><b>Mọi thông tin xin liên hệ nhà hàng qua số điện thoại: </b></span>
						</div>
						<div class="col-md-5">
							<span style="color: red">${nhahang.sdt}</span>
						</div>
						<div class="col-md-1"></div>
					</div>
					<div class="row">
							<div class="col-md-1"></div>
							<div class="col-md-10 xndatcho">
								<a href="trang-chu.html" class="btn btn-success btn-block" type="submit"
									>Trở lại trang chủ</a>
							</div>
							<div class="col-md-1"></div>

						</div>
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
	<jsp:include page="/include/footer.jsp"></jsp:include>

</body>
</html>