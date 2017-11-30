<%@ page pageEncoding="utf-8"%>
<style>
	div.easy-autocomplete{
		width: 100% !important;
	}
  .ui-autocomplete-loading {
    background: white url("css/images/ui-anim_basic_16x16.gif") right center no-repeat;
  }
  </style>
<div class="row timkiemnhc timkiemctnh">
	<form class="form-inline" action="tim-kiem.html" method="get" id="tim-kiem-nh">
		<div class="form-group">
			<div class="input-group">
		    	<span class="input-group-addon"><i class="glyphicon glyphicon-search"></i></span>
		                <%-- <input class="form-control js-typeahead" id="keyword" name="q" type="search" value="${q}" placeholder="Tên quán ăn hoặc món ăn" autocomplete="off"> --%>
				<input id="keyword" placeholder="Tên quán ăn hoặc món ăn" style="width: 100%; background: white;" name="search" autocomplete="off" value="${tukhoa}"/>
			</div>
	    </div>
		<div class="form-group">
			<input type="text" class="form-control" id="ngaythang1" name="ngaythang" placeholder="Chọn ngày tháng" readonly="readonly" style="cursor:pointer; background-color: #FFFFFF">
		</div>
		<div class="form-group">
			<input type="time" class="timepicker form-control" id="demo">
		</div>
		<div class="form-group">
			<select class="form-control so-nguoi" name="songuoi" id="songuoi">
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
<input type="hidden" id="h-tukhoa" value="${tukhoa}"/>
<input type="hidden" id="h-ngaythang" value="${ngaythang}"/>
<input type="hidden" id="h-songuoi" value="${songuoi}"/>
<script>
	/* $(document).ready(function(){ */
		$(document).ready(function(){
			var options = {

					  url: function(phrase) {
					    return "search-autocomplete-ajax.html";
					  },
					  
					  categories: [
						{
						        listLocation: "showmore",
						        maxNumberOfElements: 1,
						        header: ""
						},
						{
					        listLocation: "monan",
					        maxNumberOfElements: 4,
					        header: "<i class='fa fa fa-cutlery'></i> Món ăn"
					    }, 
					    {
					        listLocation: "nhahang",
					        maxNumberOfElements: 4,
					        header: "<i class='fa fa-building-o'></i> Nhà hàng"
					    }],

					  getValue: function(element) {
						  console.log(element);
						  if(element.tennhahang != undefined){
							  return element.tennhahang;
						  }
						  
					    return element.tenmonan;
					  },
					  template: {
						  type: "custom",
							method: function(value, item) {
								if(item.showmore != null){
									return "Tìm kiếm thêm với từ khóa \""+value+"\"";
								}
								return "<img src=\"\" />" + value;
							}
					    },

					  ajaxSettings: {
					    dataType: "json",
					    method: "POST",
					    data: {
					      dataType: "json"
					    },
					    beforeSend: function(){
			    			$("#keyword").css("background","white url('css/images/ui-anim_basic_16x16.gif') right center no-repeat");
			    		},
			    		complete: function(){
			    			/* $("#eac-container-placeholder > ul").append($("<li/>",{
			    				"class": "ss"
			    			}).append($("<div/>", {
			    				"class": "eac-item",
			    				"text": "halo"
			    			}))); */
			    			$("#keyword").css("background","white");
			    		}
					  },
					  list: {
					        maxNumberOfElements: 8,
					        match: {
					            enabled: true
					        },
					        sort: {
					            enabled: true
					        }
					    },

					  preparePostData: function(data) {
					    data.search = $("#keyword").val();
					    return data;
					  },
					  theme: "square",
					  requestDelay: 400
				};

			$("#keyword").easyAutocomplete(options);
				
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
					'format': 'HH:mm',
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