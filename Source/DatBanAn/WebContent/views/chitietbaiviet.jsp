<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta content="text/html; charset=UTF-8">
<title>Insert title here</title>

<jsp:include page="/include/headtag.jsp"></jsp:include>

</head>
<body>
	<jsp:include page="/include/header.jsp"></jsp:include>

	<div class="wrap">
		<div class="about">
			<div class="services-sidebar">
				<h4>Nổi bật</h4>
				<ul>
					<li><img src="images/pointer.jpg" title="pointer" /><a
						href="#">Quán ăn hà nội</a></li>
					<li><img src="images/pointer.png" title="pointer" /><a
						href="#">Món ăn đặc sắc</a></li>
					<li><img src="images/pointer.png" title="pointer" /><a
						href="#">Hương vị đặc biệt</a></li>
					<li><img src="images/pointer.png" title="pointer" /><a
						href="#">Luôn giữ vị trí dẫn đầu</a></li>
					<li><img src="images/pointer.png" title="pointer" /><a
						href="#">Giam giá mỗi ngày</a></li>
					<li><img src="images/pointer.png" title="pointer" /><a
						href="#">Phục vụ luôn chu đáo</a></li>
					<li><img src="images/pointer.png" title="pointer" /><a
						href="#">Gía cả hợp lý</a></li>
					<li><img src="images/pointer.png" title="pointer" /><a
						href="#">Quán ăn giá rẻ HCM</a></li>
					<li><img src="images/pointer.png" title="pointer" /><a
						href="#">Địa chỉ luôn được quan tâm</a></li>
				</ul>
				<br>
				<h4>Archives</h4>
				<ul>
					<li><img src="images/pointer.jpg" title="pointer" /><a
						href="#">Jan, 2012</a></li>
					<li><img src="images/pointer.jpg" title="pointer" /><a
						href="#">Feb, 2012</a></li>
					<li><img src="images/pointer.jpg" title="pointer" /><a
						href="#">March, 2012</a></li>
					<li><img src="images/pointer.jpg" title="pointer" /><a
						href="#">April, 2012</a></li>
				</ul>
			</div>
			<div class="bloder-content">

				<div class="blog-box1">
					<h3
						style="font-size: 25px; font-family: Arial, Helvetica, sans-serif; color: blue;">Bánh
						đúc nóng thơm ngon</h3>
					</br>
					<div class="blog-box-image">
						<img src="images/pre.jpg" title="priview" />
					</div>
					<div class="blog-box-content">

						<p>Có dịp đi công việc ngang qua khu này nên ghé ăn thử. Bé
							chủ quán khá trẻ mà không hiểu sao bảng hiệu lại ghi "Bà già" nhỉ
							:)) Bé quảng cáo món Cháo em nấu ngon lắm, chị ăn thử nên mình
							quyết định ăn cháo và mua bánh đúc mang về. Cháo nấu nhuyễn và
							khá thơm, nguyên liệu sạch. Nêm nếm rất vừa miệng. Miếng sườn sụn
							ninh vừa chín tới. Nói chung ăn ngon. Bánh đúc thì ăn tàm tạm
							thôi, không biết là do mang về để lâu không còn nóng nữa. Có thể
							ăn ngay ở quán sẽ ngon hơn"</p>

					</div>
				</div>

				<div class="clear"></div>
			</div>


		</div>
		<div class="container">
			<form>
				<div class="form-group">
					<label for="comment">Nguyễn văn tèo</label>
					</br>
					<textarea style="height: 77px;width: 91%;" class="form-control" rows="5" id="comment"></textarea>
				</div>
				<button style="height: 40px;" class="btn btn-primary" type="submit">Bình luận</button>
			</form>
		</div>
	</div>





</body>
</html>