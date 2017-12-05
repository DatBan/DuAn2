<%@ page pageEncoding="utf-8"%>
<div class="container col-md-12" id="bl-section">
	<div class="tieu-de-bl">
		<span class="tieudegtctnh">Bình luận (${ctbv.countcmt})</span>
	</div>
	<br/>
	<div class="row">
		<form id="bl-moi">
			<input type="hidden" id="idbaiviet" value="${ctbv.id}" name="idbaiviet"/>
			<div class="row">
				<div class="form-group col-md-12">
					<textarea id="noidung" name="noidung" class="comment form-control"
						placeholder="Viết bình luận của bạn"
						style="-moz-box-sizing: border-box; min-width: 100%; min-height: 80px; max-width: 100%"></textarea>
				</div>
			</div>
			
			<div class="row">
				<div class="form-group col-md-12">
					<button type="submit" id="btn-bl" class="btn btn-info">Gửi bình luận</button>
				</div>
			</div>
		</form>
	</div>
	<div class="row">
		<div class="col-md-3 filter-bl" style=" padding-left: 0px;">
			<select class="form-control sap-xep-bl">
				<option value="newest">Mới nhất</option>
				<option value="oldest">Cũ nhất</option>
				<option value="popular">Phổ biến nhất</option>
			</select>
		</div>
	</div>
	<br>

	<!-- Nested media object -->
	<div id="load-bl-section">
	</div>
	<br/>
	<a href="#" id="load-more-cmts">Xem thêm bình luận khác</a>
	<hr>

	<!-- Right-aligned media object -->
</div>