function change_alias(alias) {
		var str = alias;
		str = str.toLowerCase();
		str = str.replace(/à|á|ạ|ả|ã|â|ầ|ấ|ậ|ẩ|ẫ|ă|ằ|ắ|ặ|ẳ|ẵ/g, "a");
		str = str.replace(/è|é|ẹ|ẻ|ẽ|ê|ề|ế|ệ|ể|ễ/g, "e");
		str = str.replace(/ì|í|ị|ỉ|ĩ/g, "i");
		str = str.replace(/ò|ó|ọ|ỏ|õ|ô|ồ|ố|ộ|ổ|ỗ|ơ|ờ|ớ|ợ|ở|ỡ/g, "o");
		str = str.replace(/ù|ú|ụ|ủ|ũ|ư|ừ|ứ|ự|ử|ữ/g, "u");
		str = str.replace(/ỳ|ý|ỵ|ỷ|ỹ/g, "y");
		str = str.replace(/đ/g, "d");
		str = str.replace(/!|@|%|\^|\*|\(|\)|\+|\=|\<|\>|\?|\/|,|\.|\:|\;|\'| |\"|\&|\#|\[|\]|~|$|_/g,"-");
		/* tìm và thay thế các kí tự đặc biệt trong chuỗi sang kí tự - */
		str = str.replace(/-+-/g, "-"); // thay thế 2- thành 1-
		str = str.replace(/^\-+|\-+$/g, "");
		// cắt bỏ ký tự - ở đầu và cuối chuỗi
		return str;
	}
$(document).ready(function() {
	var cmt_moi = [0];
	//Đổi sang slug
	//Tooltip the a
	$('[data-toggle="tooltip"]').tooltip();
	
	//chuyen tieu de thanh slug dep
	var tieuDe = document.getElementById('tieude');
	if(tieuDe != null){
		tieuDe.addEventListener('change', function() {
			var permalink = document.getElementById('slug');
			doiPermarlink(tieuDe.value, permalink);
		});
	}
	
	function doiPermarlink(tieude, permalink) {
		permalink.value = change_alias(tieude);
	}
	
	//Check validate dang nhap
	$("#login").validate({
		onchange : false,
		onfocusout : false,
		onkeyup : false,
		onclick : false,
		rules : {
			tendangnhap : {
				required : {
					depends : function() {
						$(this).val($.trim($(this).val()));
						return true;
					}
				},
				rangelength : [ 5, 50 ],
				nowhitespace : true,
				alphanumeric : true
			},
			matkhau:{
				required : {
		              depends: function() {
		                  $(this).val($.trim($(this).val()));
		                  return true;
		                }
		              },
				minlength : 6,
				maxlength : 30,
				nowhitespace : true/*,
				remote:{
					type: "GET",
					url: "kt-dang-nhap.html",
					data: {
						tendangnhap: function(){
							var tdn = $("#tendangnhap").val();
								return tdn;
						}
					}
				}*/
			}
		},
		submitHandler: function(form) {
			$("#nut-dn").attr('disabled','disabled');
			$("#nut-dn").html('<i class="fa-li fa fa-spinner fa-spin" style="position: initial;"></i> Đang kiểm tra...');
			$.ajax({
				type: "POST",
				url: "kt-dang-nhap.html",
				data: {
					matkhau: function(){
						var mk = $("#matkhau").val();
						return mk;
					},
					tendangnhap: function(){
						var tdn = $("#tendangnhap").val();
							return tdn;
					},
					remember: function(){
						var rmb = $("#remember").is(":checked");
							return rmb;
					}
				},
				success: function(result){
					if(result == 'true'){
						$("#tb-loi-dn").html('');
						location.reload();
					}else if(result == 'khoa'){
						$("#tb-loi-dn").html('Tài khoản của bạn đã bị khóa. Vui lòng liên hệ quản trị để biết thêm chi tiết!');
					}else{
						$("#tb-loi-dn").html('Tài khoản hoặc mật khẩu sai. Vui lòng thử lại!');
					}
				}
			}).always(function(){
				$("#nut-dn").removeAttr('disabled');
				$("#nut-dn").html('Đăng nhập');
			});
		 },
		messages : {
			tendangnhap : {
				required : "Vui lòng nhập tên đăng nhập",
				rangelength : "Tên đăng nhập chỉ từ {0} tới {1} ký tự",
				nowhitespace : "Tên đăng nhập không được có khoảng trống",
				alphanumeric : "Tên đăng nhập viết thường không dấu và không được có ký tự đặc biệt"
			},
			matkhau : {
				required : "Vui lòng điền mật khẩu",
				minlength : "Mật khẩu quá ngắn",
				maxlength : "Mật khẩu vượt quá giới hạn",
				nowhitespace :"Mật khẩu không được có khoảng trống",
				remote : "Tài khoản hoặc mật khẩu sai. Vui lòng thử lại!"
			},
		}
	});
	
	//Check validate edit-user
	$("#edit-user-db").validate({
		onchange : true,
		rules : {
			hoten : {
				required :true,
				rangelength : [ 4, 50 ],
				wordCount : [ '2' ],
				notNumber: true
				
			},
			matkhau : {
				minlength : 6,
				maxlength : 30,
				nowhitespace : true
			},
			email : {
				required : {
		              depends: function() {
		                  $(this).val($.trim($(this).val()));
		                  return true;
		                }
		              },
				nowhitespace : true,
				email:true,
				remote : {
					type : "GET",
					url : "kt-trung-email.html",
					data: {
						tdn: function(){
							var emailcu = $("#tendangnhap").val();
							return emailcu;
						}
					}
				},
				maxlength : 150
			},
			sdt : {
				required : {
		              depends: function() {
		                  $(this).val($.trim($(this).val()));
		                  return true;
		                }
		              },
				digits : true,
				rangelength : [ 9, 11 ],
				chuanSDT : true
			},
			diachi : {
				maxlength : 200
	              
			}

		},
		messages : {
			hoten : {
				required : "Vui lòng nhập đầy đủ họ tên",
				rangelength : "Họ tên không hợp lệ",
				wordCount : "Họ tên phải có khoảng cách",
				notNumber:"Họ tên không được có số và ký tự đặc biệt"
			},
			matkhau : {
				minlength : "Mật khẩu quá ngắn",
				maxlength : "Mật khẩu vượt quá giới hạn",
				nowhitespace :"Mật khẩu không được có khoảng trống"
			},
			email : {
				required : "Vui lòng điền email",
				nowhitespace :"Email không được có khoảng cách",
				email : "Email không hợp lệ",
				
				remote : "Email này đã được sử dụng",
				maxlength : "Email không hợp lệ",
				
			},
			sdt : {
				required : "Vui lòng điền số điện thoại",
				digits : "Số điện thoại phải là số và không có khoảng trắng",
				rangelength : "Số điện thoại không hợp lệ",
				chuanSDT : "Số điện thoại phải bắt đầu từ số 0"
			},
			diachi : {
				maxlength : "Địa chỉ không hợp lệ"
			}
		}
	});
	
	$(function() {
		//Jquery barating
	      $('#do-an, #gia-ca, #phuc-vu, #khong-gian').barrating('show',{
	        theme: 'fontawesome-stars-o',
	        initialRating: 3
	      }).barrating('set', '3');
	      //Jquery dialog
	      $( "#dialog" ).dialog({
	      	autoOpen: false,
	      	draggable: false,
	      	resizable: false,
	      	modal: true,
	  		buttons: {
	  	        Đóng: function() {
	  	          $( this ).dialog( "close" );
	  	        }
	  	      }
	      });
	   });
	
	//Check validate dang nhap
	$("#danh-gia").validate({
		/*onchange : false,
		onfocusout : false,
		onkeyup : false,
		onclick : false,*/
		rules : {
			tieudedg : {
				required : {
					depends : function() {
						$(this).val($.trim($(this).val()));
						return true;
					}
				},
				rangelength : [ 5, 30 ]
			},
			doan:"required",
			noidungdg : {
				required : {
					depends : function() {
						$(this).val($.trim($(this).val()));
						return true;
					}
				},
				rangelength : [ 5, 150 ]
			}
		},
		submitHandler: function(form) {
			/*$("#Modaldanhgia").modal('hide');*/
			$("#btn-danhgia").attr('disabled','disabled');
			$("#btn-danhgia").html('<i class="fa-li fa fa-spinner fa-spin" style="position: initial;"></i> Đánh giá');
			$.ajax({
				type: "GET",
				url: "danh-gia.html",
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
							"<input type='hidden' class='gio"+result.id+"' value='"+result.ngaytao+"' /> <span>"+result.nguoidanhgia.hoten+"</span>: <span class='ngaytao"+result.id+"'>3 "+
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
				required : "Vui lòng nhập tên đăng nhập",
				rangelength : "Tên đăng nhập chỉ từ {0} tới {1} ký tự"
			},
			noidungdg : {
				required : "Vui lòng nhập tên đăng nhập",
				rangelength : "Tên đăng nhập chỉ từ {0} tới {1} ký tự"
			},
		}
	});
		var sapxep = "new";
		var target = $("div.danhgia").offset();
		var sotrang = 0;
		if(target != undefined){
			target = $("div.danhgia").offset().top - 300;
			var interval = setInterval(function() {
			    var scroll = $(window).scrollTop();
			   /* alert(scroll);*/
			    // Do something
			    /*console.log(scroll);*/
					 if (scroll >= target) {
						 $("#xem-them-dg").html('<i class="fa-li fa fa-spinner fa-spin" style="position: initial;"></i> Đang tải');
							sotrang++;
						 	$.ajax({
								type: "GET",
								url: "list-danh-gia.html",
								data: {trang: sotrang, 'idmoi[]': cmt_moi, sapxep: sapxep},
								dataType: "json",
								success: function(result){
									setTimeout(function(){
										if(result.rong == 'dung'){
											$("#xem-them-dg").css("display", "none");
											$("#danhsach-dg").attr("class", "text-center");
											$("#danhsach-dg").append(
													"<span class='text-center' style='color:gray;'>" +
														"<b>Chưa có đánh giá nào về nhà hàng này</b>" +
													"</span>");
										}else{
											$(".timdg").css("display", "block");
											$("#btn-filter-danhgia").before("<hr style='border-color: #ddd;'/>");
										}
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
							 clearInterval(interval);
					 }
			}, 500);
		}
	$("#xem-them-dg").bind("click",function(){
		$(this).html('<i class="fa-li fa fa-spinner fa-spin" style="position: initial;"></i> Đang tải');
		sotrang++;
		$.ajax({
			type: "GET",
			url: "list-danh-gia.html",/*
			dataType: "json",*/
			data: {trang: sotrang, 'idmoi[]': cmt_moi, sapxep: sapxep},
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
		sotrang = 1 ;
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
			type: "GET",
			url: "list-danh-gia.html",
			dataType: "json",
			data: {trang: 0, 'idmoi[]': cmt_moi, sapxep: sapxep},
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
});