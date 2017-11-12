/**
 * 
 */
// Đăng ký validate
$(document).ready(function() {
	
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
	$("#datban").validate({
	
		onchange : true,
		rules : {
			ho : {
				required:true,
				maxlength:20,
				notNumber: true
			},
			ten : {
				required:true,
				maxlength:20,
				notNumber: true
			},
			email : {
				required:{
		              depends: function() {
		                  $(this).val($.trim($(this).val()));
		                  return true;
		                }
		              },
				rangelength:[7,150],
				nowhitespace : true,
				email:true,
			},
			sdt : {
				required:{
		              depends: function() {
		                  $(this).val($.trim($(this).val()));
		                  return true;
		                }
		              },
				rangelength:[9,11],
				digits : true,
				chuanSDT : true
			},
			ghichu :{
				maxlength: 200
			}

		},
		messages : {
			ho : {
				required:"Vui lòng nhập họ",
				maxlength:"Họ quá dài vui lòng thử lại",
				notNumber: "Họ không được có số và ký tự đặc biệt"
			},
			ten : {
				required:"Vui lòng nhập tên",
				maxlength:"Tên quá dài vui lòng thử lại",
				notNumber: "Tên không được có số và ký tự đặc biệt"
			},
			email : {
				required:"Vui lòng điền email",
				rangelength:"Email không hợp lệ",
				nowhitespace : "Email không được có khoảng cách",
				email:"Email không hợp lệ",
			},
			sdt : {
				required:"Vui lòng điền số điện thoại",
				rangelength:"Số điện thoại không hợp lệ",
				digits : "Số điện thoại phải là số và không có khoảng trắng",
				chuanSDT : "Số điện thoại phải bắt đầu từ số 0"
			},
			ghichu :{
				maxlength: "Ghi chú quá dài vui lòng thử lại"
			}
		}
	});
});