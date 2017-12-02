/**
 * 
 */
$(document).ready(function(){
	$("#add-user-db").validate({
		
		onchange : true,
		rules : {
			ho : {
				required :true,
				rangelength : [ 2, 25 ],
				notNumber: true
				
			},
			ten : {
				required :true,
				rangelength : [ 2, 25 ],
				notNumber: true
				
			},
			tendangnhap : {
				required : {
		              depends: function() {
		                  $(this).val($.trim($(this).val()));
		                  return true;
		                }
		              },
				rangelength : [ 5, 50 ],
				nowhitespace : true,
				remote : {
					type : "GET",
					url : "kt-trung-tendangnhap.html"

				},
				alphanumeric : true

			},
			matkhau : {
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
					url : "kt-trung-email.html"
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
			ho : {
				required : "Vui lòng nhập họ",
				rangelength : "Họ chỉ từ 2 tới 25 ký tự",				
				notNumber:"Họ không được có số và ký tự đặc biệt"
			},
			ten : {
				required : "Vui lòng nhập tên",
				rangelength : "Tên chỉ từ 2 tới 25 ký tự",				
				notNumber:"Tên không được có số và ký tự đặc biệt"
			},
			tendangnhap : {
				required : "Vui lòng nhập tên đăng nhập",
				rangelength : "Tên đăng nhập chỉ từ 5 tới 50 ký tự",
				nowhitespace : "Tên đăng nhập không được có khoảng trống",
				remote : "Tên đăng nhập đã tồn tại. Vui lòng thử lại",
				alphanumeric : "Tên đăng nhập viết thường không dấu và không được có ký tự đặc biệt"
			},
			matkhau : {
				required : "Vui lòng điền mật khẩu",
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
});