/**
 * 
 */
// Đăng ký validate
$(document).ready(function() {
	// check họ tên (số chữ)
	$.validator.addMethod("wordCount", function(value, element, params) {
		var typedWords = jQuery.trim(value).split(" ").length;

		if (typedWords >= params[0]) {
			return true;
		}
	}

	);
	// Check sdt
	$.validator.addMethod("chuanSDT", function(value, element) {
		var regex = new RegExp(/^0[0-9].*$/);
		var key = value;

		if (!regex.test(key)) {
			return false;
		} else {
			return true;
		}
	});
	// Check số trong họ tên
	$.validator.addMethod("notNumber", function(value, element, param) {
        var reg = /[0-9.@!#$%&'*+\/=?^_`{|}~-]/;
        if(reg.test(value)){
              return false;
        }else{
                return true;
        }
	});
	$("#registerform").validate({
		normalizer : function(value) {
			return $.trim(value);
		},
		onchange : true,
		rules : {
			hoten : {
				required : {
		              depends: function() {
		                  $(this).val($.trim($(this).val()));
		                  return true;
		                }
		              },
				rangelength : [ 4, 50 ],
				wordCount : [ '2' ],
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
			nhaplaimatkhau : {
				required : true,
				equalTo : '[name="matkhau"]'
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
			hoten : {
				required : "Vui lòng nhập đầy đủ họ tên",
				rangelength : "Họ tên không hợp lệ",
				wordCount : "Họ tên phải có khoảng cách",
				notNumber:"Họ tên không được có số và ký tự đặc biệt"
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
			nhaplaimatkhau : {
				required : "Vui lòng nhập lại mật khẩu",
				equalTo : "Mật khẩu bạn nhập lại không đúng"
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