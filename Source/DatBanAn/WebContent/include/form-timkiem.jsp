<%@ page pageEncoding="utf-8"%>
<div class="row timkiemnhc timkiemctnh">
	<form class="form-inline">
		<div class="input-group">
			<span class="input-group-addon"><i class="glyphicon glyphicon-search"></i></span> 
			<input type="text" class="form-control" placeholder="Tên nhà hàng, món ăn, địa điểm">
		</div>
		<div class="form-group">
			<input type="text" class="form-control" id="ngaythang" placeholder="Chọn ngày tháng">
		</div>
		<div class="form-group">
			<select class="form-control">
				<option>-Thời gian-</option>
			</select>
		</div>
		<div class="form-group">
			<select class="form-control">
				<option>1 người</option>
				<option>2 người</option>
			</select>
		</div>
		<button class="btn warning btntk">
			<b>Tìm kiếm</b>
		</button>
	</form>
	<div class="col-md-2 "></div>
</div>
<script>
	$(function() {
		$("#ngaythang").datepicker({
			dateFormat : "dd/mm/yy",
			minDate : 0,
			defaultDate : 0
		});
	});
</script>