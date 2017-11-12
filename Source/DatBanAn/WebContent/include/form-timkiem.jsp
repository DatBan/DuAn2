<%@ page pageEncoding="utf-8"%>
<div class="row timkiemnhc timkiemctnh">
	<form class="form-inline" action="tim-kiem.html" method="get">
		<div class="input-group">
			<span class="input-group-addon"><i class="glyphicon glyphicon-search"></i></span> 
			<input type="text" class="form-control" placeholder="Tên nhà hàng, món ăn, địa điểm">
		</div>
		<div class="form-group">
			<input type="text" class="form-control" id="ngaythang1" name="ohlala" placeholder="Chọn ngày tháng" readonly="readonly" style="cursor:pointer; background-color: #FFFFFF">
		</div>
		<div class="form-group">
			<input type="time" class="timepicker form-control" id="demo">
		</div>
		<div class="form-group">
			<select class="form-control so-nguoi">
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
	/* $(document).ready(function(){ */
		$(document).ready(function(){
			var so_nguoi = document.getElementsByClassName('so-nguoi');
			$('.so-nguoi').empty();
			for(var i = 1; i < 100; i++){
				var opt = document.createElement('option');
				opt.innerHTML = i + " người";
				opt.value = i;
				$('.so-nguoi').append(opt);
			}
			$(function(){		
				$('.timepicker').qcTimepicker({
					'format': 'H:mm',
					'minTime': '7:00:00',
					'maxTime': '23:30:00',
					'step': 900,
					'placeholder': 'halo halo'
				});
				$("#demo-qcTimepicker").attr({"class": "form-control", "name": "thoigian"});
	
				$("#ngaythang1").datepicker({
					dateFormat : "dd/mm/yy",
					gotoCurrent: true,
					minDate : 0
				}).datepicker("setDate", new Date());
			});
		});
	/* }); */
</script>