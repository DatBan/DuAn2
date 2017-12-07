$(document).ready(function(){
	var cmt_moi = [0];
	//Check validate dang nhap
	$("#danh-gia").validate({
		/*onchange : false,
		onfocusout : false,
		onkeyup : false,
		onclick : false,*/
		rules : {
			tieudedg : {
				required : true,
				rangelength : [ 5, 30 ]
			},
			doan:"required",
			noidungdg : {
				required: true,
				rangelength : [ 5, 150 ]
			}
		},
		submitHandler: function(form) {
			/*$("#Modaldanhgia").modal('hide');*/
			$("#btn-danhgia").attr('disabled','disabled');
			$("#btn-danhgia").html('<i class="fa-li fa fa-spinner fa-spin" style="position: initial;"></i> Đánh giá');
			$.ajax({
				type: "POST",
				url: "danh-gia/gui-danh-gia.html",
				data: $("#danh-gia").serialize(),
				dataType: 'json',
				success: function(result){
					console.log(result);
					$('#do-an, #gia-ca, #phuc-vu, #khong-gian').barrating('show',{
				        initialRating: 3
					}).barrating('set', '3');
					$("#tieudedg").val('');
					$("#noidungdg").val('');
					cmt_moi.push(result.id);
					/*alert(cmt_moi);*/
					
						var hienthi_cmt ="<div class='row'>"+
						"<div class='col-md-12 nddg'>" +
							"<div class='col-md-3' title='"+result.diemdanhgia+"/5'>" +
								"<select id='tdiem"+result.id+"'>"+
									"<option value='1'>1</option>"+
									"<option value='2'>2</option>"+
									"<option value='3'>3</option>"+
									"<option value='4'>4</option>"+
									"<option value='5'>5</option>"+
								"</select>"+
							"</div>" +
							"<div class='col-md-9'>" +
								"<img src='images/userdg.png' />" +
								"<input type='hidden' class='gio"+result.id+"' value='"+result.ngaytao+"' /> <span>"+result.nguoidanhgia.ho+ " "+result.nguoidanhgia.ten+"</span>: <span class='ngaytao"+result.id+"'>3 "+
								"phút trước</span>" +
							"</div>" +
						"</div>" +
						"</div>" +
						"<div class='row'>" +
							"<div class='col-md-9 colnddg'>" +
								"<div class='col-md-12 noidungdg'>" +
									"<span>"+result.noidung+"</span>" +
								"</div>" +
							"</div>" +
						"<div class='col-md-3'>" +
						"<div class='row'>" +
							"<div class='col-md-5'>" +
								"<span>Đồ ăn</span>" +
							"</div>" +
							"<div class='col-md-7'>" +
								"<span>"+result.doan+"</span>" +
							"</div>" +
						"</div>" +
						"<div class='row'>" +
							"<div class='col-md-5'>" +
								"<span>Phục vụ</span>" +
							"</div>" +
							"<div class='col-md-7'>" +
								"<span>"+result.phucvu+"</span>" +
							"</div>" +
						"</div>" +
						"<div class='row'>" +
							"<div class='col-md-5'>" +
								"<span>Không gian</span>" +
							"</div>" +
							"<div class='col-md-7'>" +
								"<span>"+result.khongian+"</span>" +
							"</div>" +
						"</div>" +
						"<div class='row'>" +
							"<div class='col-md-5'>" +
								"<span>Giá cả</span>" +
							"</div>" +
							"<div class='col-md-7'>" +
								"<span>"+result.giaca+"</span>" +
							"</div>" +
						"</div>" +
						"</div>" +
					"</div>"+
					"<hr/>"+
					"<script>" +
						"$(document).ready(function(){" +
						"var diemddg = "+result.diemdanhgia+";"+
							"$('#tdiem"+result.id+"').barrating('show',{"+
								"theme: 'fontawesome-stars-o',"+
								"initialRating:diemddg"+
							"}).barrating('readonly', true);" +
						"});" +
						"var day = moment($('.gio"+result.id+"').val());"+
						"$('.ngaytao"+result.id+"').html(day.fromNow());" +
					"</script>" ;
						$("#Modaldanhgia").modal('hide');
						console.log(result.diemdanhgia);
						setTimeout(function(){
						if($("#rong-dg").val() != undefined){
							$(".timdg").css("display", "block");
							$("#btn-filter-danhgia").before("<hr style='border-color: #ddd;'/>");
							$("#danhsach-dg").attr("class", "");
							$("#danhsach-dg").html('');
						}
							$("#danhsach-dg").prepend(hienthi_cmt);
							$( "#dialog" ).dialog('open');
						}, 500);
				},
				error: function(error){
					console.log(error);
				}
			}).always(function(){
				$("#btn-danhgia").removeAttr('disabled');
				$("#btn-danhgia").html('Đăng nhập');
			});
		 },
		messages : {
			tieudedg : {
				required : "Vui lòng nhập tiêu đề đánh giá",
				rangelength : "Tiêu đề đánh giá chỉ từ {0} tới {1} ký tự"
			},
			noidungdg : {
				required : "Vui lòng nhập nội dung đánh giá",
				rangelength : "Nội dung đánh giá chỉ từ {0} tới {1} ký tự"
			},
		}
	});
		var sapxep = "new";
		var target = $("div.danhgia").offset();
		var sotrang_dg = 0;
		if(target != undefined){
			target = $("div.danhgia").offset().top - 300;
			var interval = setInterval(function() {
			    var scroll = $(window).scrollTop();
			   /* alert(scroll);*/
			    // Do something
			    /*console.log(scroll);*/
					 if (scroll >= target) {
						 $("#xem-them-dg").html('<i class="fa-li fa fa-spinner fa-spin" style="position: initial;"></i> Đang tải');
						 sotrang_dg++;
						 	$.ajax({
								type: "POST",
								url: "danh-gia/list-danh-gia.html",
								data: {trang: sotrang_dg, 'idmoi[]': cmt_moi, sapxep: sapxep, idnh: $("#idctnh").val()},
								dataType: "json",
								success: function(result){
									console.log(result);
									setTimeout(function(){
										if(result.rong == 'dung' || result.trave == ""){
											$("#xem-them-dg").css("display", "none");
											$("#danhsach-dg").attr("class", "text-center");
											$("#danhsach-dg").append(
													"<span class='text-center' style='color:gray;' id='rong-dg'>" +
														"<b>Chưa có đánh giá nào về nhà hàng này</b>" +
													"</span>");
										}else{
											$(".timdg").css("display", "block");
											$("#btn-filter-danhgia").before("<hr style='border-color: #ddd;'/>");
										}
										if(result.chuoi == 'out' || result.pagecount == '1'){
											$("#xem-them-dg").css("display", "none");
										}
										$("#xem-them-dg").html('Xem thêm');
										$("#danhsach-dg").append(result.trave);
									}, 500);
								},
								error: function(error){
									console.log("LOI "+error);
								}
							});
							 clearInterval(interval);
					 }
			}, 500);
		}
	$("#xem-them-dg").bind("click",function(){
		$(this).html('<i class="fa-li fa fa-spinner fa-spin" style="position: initial;"></i> Đang tải');
		sotrang_dg++;
		$.ajax({
			type: "POST",
			url: "danh-gia/list-danh-gia.html",/*
			dataType: "json",*/
			data: {trang: sotrang_dg, 'idmoi[]': cmt_moi, sapxep: sapxep, idnh: $("#idctnh").val()},
			dataType: "json",
			success: function(result){
				console.log(result);
				setTimeout(function(){
					if(result.chuoi == 'out'){
						$("#xem-them-dg").css("display", "none");
					}
					$("#xem-them-dg").html('Xem thêm');
					$("#danhsach-dg").append(result.trave);
				}, 500);
			},
			error: function(error){
				console.log("LOI "+error);
			}
		});
	});
	
	$(".sap-xep").bind("change",function(){
		sotrang_dg = 1 ;
		$("#xem-them-dg").html('<i class="fa-li fa fa-spinner fa-spin" style="position: initial;"></i> Đang tải');
		$("#danhsach-dg").html('');
		$("#xem-them-dg").css("display", "block");
		
		if($(this).val() == 'oldest'){
			sapxep = "old";
		}else if($(this).val() == 'popular'){
			sapxep = "popular";
		}else{
			sapxep = "new";
		}
		/*$(".sap-xep").removeClass("active");
		$(this).addClass('active');*/
		cmt_moi = [0];
		$.ajax({
			type: "POST",
			url: "danh-gia/list-danh-gia.html",
			dataType: "json",
			data: {trang: 0, 'idmoi[]': cmt_moi, sapxep: sapxep, idnh: $("#idctnh").val()},
			dataType: "json",
			success: function(result){
				console.log(result);
				setTimeout(function(){
					if(result.chuoi == 'out' || result.pagecount == '1' || result.trave == ""){
						$("#xem-them-dg").css("display", "none");
					}
					$("#xem-them-dg").html('Xem thêm');
					$("#danhsach-dg").append(result.trave);
				}, 500);
			},
			error: function(error){
				console.log("LOI "+error);
			}
		});
	});
});