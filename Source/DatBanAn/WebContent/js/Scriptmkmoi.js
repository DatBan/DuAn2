/**
 * 
 */
// Đăng ký validate
$(document).ready(function() {

	$("#quenmkform").validate({
	
		onchange : true,
		rules : {
		
			taikhoan : {
				required : {
		              depends: function() {
		                  $(this).val($.trim($(this).val()));
		                  return true;
		                }
		              },
				rangelength : [ 2, 50 ],
				nowhitespace : true,
				remote :  {
					type : "GET",
					url : "user/mailer/kt-tendangnhap1.html"

				},
				alphanumeric : true
				
			},
			matkhaucu : {
				required : true,
				
		
			

			},
			matkhaumoi : {
				required : {
		              depends: function() {
		                  $(this).val($.trim($(this).val()));
		                  return true;
		                }
		              },
				minlength : 6,
				maxlength : 30,
				nowhitespace : true
			},
			nhaplaimkmoi : {
				required : true,
				equalTo : '#matkhaumoi'
			},
		},
		messages : {
			taikhoan : {
				required : "Vui lòng nhập tên đăng nhập",
				rangelength : "Tên đăng nhập chỉ từ {0} tới {1} ký tự",
				nowhitespace : "Tên đăng nhập không được có khoảng trống",
				remote : "Tên đăng nhập này không tồn tại",
			},
			matkhaucu : {
				required : "Vui lòng nhập lại mật khẩu cũ",
			
			},
			matkhaumoi : {
				required : "Vui lòng điền mật khẩu",
				minlength : "Mật khẩu quá ngắn",
				maxlength : "Mật khẩu vượt quá giới hạn",
				nowhitespace :"Mật khẩu không được có khoảng trống"
			},
			nhaplaimkmoi : {
				required : "Vui lòng nhập lại mật khẩu",
				equalTo : "Mật khẩu bạn nhập lại không đúng"
			}
		}
	});
});