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
$(document).ready(function() {//Đổi sang slug
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
				type: "GET",
				url: "kt-dang-nhap.html",
				data: {
					matkhau: function(){
						var mk = $("#matkhau").val();
						return mk;
					},
					tendangnhap: function(){
						var tdn = $("#tendangnhap").val();
							return tdn;
					}
				},
				success: function(result){
					alert(result);
					console.log(result);
					/*alert(result);*/
					if(result == 'true'){
						$("#tb-loi-dn").html('');
						form.submit();
					}else if(result == 'khoa'){
						$("#tb-loi-dn").html('Tài khoản của bạn đã bị khóa. Vui lòng liên hệ quản trị để biết thêm chi tiết!');
					}else{
						$("#tb-loi-dn").html('Tài khoản hoặc mật khẩu sai. Vui lòng thử lại!');
						/*alert('Tài khoản hoặc mật khẩu sai');*/
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
	      $('#do-an, #gia-ca, #phuc-vu, #khong-gian').barrating({
	        theme: 'fontawesome-stars-o'
	      });
	   });
});