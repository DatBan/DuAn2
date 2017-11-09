<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="modal fade" id="Modaldanhgia" role="dialog">
	<div class="modal-dialog">
	
		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title" style="text-align: center;">
					<b>Đánh giá nhà hàng</b>
				</h4>
			</div>
			<form action="danh-gia.html" method="POST" id="danh-gia">
				<div class="modal-body">
						<div class="row">
							<div class="col-md-12 col-sm-6">
								<label for="tieudedg">Tiêu đề đánh giá</label>
								<p>
									<input type="text" class="form-control" name="tieudedg" id="tieudedg" placeholder="Ví dụ chất lượng phục vụ quá tốt"/>
								</p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<label for="tieuchi">Các tiêu chí đánh giá</label>
							</div>
						</div>
						<div class="row">
							<div class="col-md-2"></div>
							<div class="col-md-3">
								<p style="line-height: 3;">Đồ ăn</p>
							</div>
							<div class="col-md-7">
								<select id="do-an" name="doan">
									<option value="1" data-html="good">1</option>
									<option value="2" data-html="better">2</option>
									<option value="3" data-html="best">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
								</select>
							</div>
							<div class="col-md-7"></div>
						</div>
						<div class="row">
							<div class="col-md-2"></div>
							<div class="col-md-3">
								<p style="line-height: 3;">Phục vụ</p>
							</div>
							<div class="col-md-7">
								<select id="phuc-vu" name="phucvu">
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
								</select>
							</div>
							<div class="col-md-7"></div>
						</div>
						<div class="row">
							<div class="col-md-2"></div>
							<div class="col-md-3">
								<p style="line-height: 3;">Không gian</p>
							</div>
							<div class="col-md-7">
								<select id="khong-gian" name="khong-gian">
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
								</select>
							</div>
							<div class="col-md-7"></div>
						</div>
						<div class="row">
							<div class="col-md-2"></div>
							<div class="col-md-3">
								<p style="line-height: 3;">Giá cả</p>
							</div>
							<div class="col-md-7">
								<select id="gia-ca" name="giaca">
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
								</select>
							</div>
							<div class="col-md-7"></div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<label for="noidungdg">Nội dung đánh giá</label>
								<p>
									<textarea class="form-control" id="noidungdg" name="noidungdg" rows="4" cols="2" placeholder="Suy nghĩ của bạn về nhà hàng..."></textarea>
								</p>
							</div>
						</div>
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-warning pull-left" id="btn-danhgia">Đánh giá</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</form>
		</div>

	</div>
</div>
<div id="dialog" title="Thông báo">
  <p>Cảm ơn bạn đã đánh giá!</p>
</div>