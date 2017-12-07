<%@ page pageEncoding="utf-8"%>
<div class="container bodydexuat">
	<div class="row rodk">
		<div id='error-page'>
			<div id='error-404'>
				<div class='box-404'>500</div>
				<h1>LỖI 500</h1>
				<p>Máy chủ bị lỗi, vui lòng thử lại sau</p>
				<!-- <p>Trang đã bị xóa hoặc địa chỉ url không đúng!</p> -->
				<p>
					Trở về <a href="trang-chu.html">trang chủ</a>
				</p>
			</div>
		</div>
		<h1>${errorMsg}</h1>
	</div>
</div>
<style>
/* Error 404 Rip By Tips24h.net */
#error-page {
	background-color: #e9e9e9;
	position: fixed !important;
	position: absolute;
	text-align: center;
	top: 0;
	right: 0;
	bottom: 0;
	left: 0;
	z-index: 99999
}

#error-404 {
	margin: 11% auto
}

#error-404 .box-404 {
	width: 200px;
	height: 200px;
	background: #21afa4;
	color: #fff;
	font-size: 80px;
	line-height: 200px;
	border-radius: 10px;
	margin: 0 auto 50px;
	position: relative
}

#error-404 .box-404::after {
	content: "width:0;
	height: 0;
	bottom: -8px;
	border-color: #21afa4 transparent transparent;
	border-style: solid;
	border-width: 9px 9px 0;
	position: absolute;
	left: 47%
}

#error-404 h1 {
	text-transform: uppercase
}

#error-404 p {
	line-height: 1.7em;
	font-size: 15px;
	font-family: arial
}
</style>