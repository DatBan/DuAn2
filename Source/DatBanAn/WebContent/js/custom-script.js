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
	
	$("#nguoidung").validate({
		onchange : true,
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
				nowhitespace : true,
				remote:{
					type: "GET",
					url: "kt-dang-nhap.html",
					data: {
						tendangnhap: function(){
							var tdn = $("#tendangnhap").val();
								return tdn;
						}
					}
				}
			}
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
});