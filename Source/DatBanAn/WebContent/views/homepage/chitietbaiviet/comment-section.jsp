<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
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
					<c:set var="vbreak" value="#Modaldanhgia"></c:set>
					<c:if test="${sessionScope.nd == null}">
						<button type="button" data-toggle="modal" class="btn btn-info" data-target="#myModal">Gửi bình luận</button>
					</c:if>
					<c:if test="${sessionScope.nd != null}">
						<button type="submit" id="btn-bl" class="btn btn-info">Gửi bình luận</button>
					</c:if>
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
	<a href="#" id="load-more-cmts"><i class="fa-li fa fa-spinner fa-spin" style="position: initial;"></i> Đang tải</a>
	<hr>

	<!-- Right-aligned media object -->
</div>
<div id="edit_cmt" class="modal fade" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Đăng nhập</h4>
			</div>
			<div class="modal-body clearfix">
				<form id="form-sua-cmt">
					<div class="form-group col-md-12">
						<input type="hidden" name="idbl" id="idbl-modal"/>
						<textarea rows='1' class="form-control" id="noidung-modal" name="noidung"></textarea>
					</div>
					<div class="form-group col-md-12">
						<button type='button' class='btn btn-default' data-dismiss="modal">Hủy</button>
						<button type='submit' class='btn btn-info' id="btn-sua-modal" disabled="disabled">Chỉnh sửa</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>