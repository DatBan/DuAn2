/**
 * 
 */

function setactive(){
	$('#lithongtin').removeAttr('class');
	$('#libanan').removeAttr('class');
	$('#limenumonan').attr('class','active');
};
function getthongtinmonan(idmonan,laytenmonan){
		$('#idmonanmodal').val(idmonan);
		$('#settenmon').text(laytenmonan);
	};
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
				minlength:2,
				maxlength:25,
				notNumber: true
			},
			ten : {
				required:true,
				minlength:2,
				maxlength:25,
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
				minlength:"Họ không hợp lệ",
				maxlength:"Họ quá dài vui lòng thử lại",
				notNumber: "Họ không được có số và ký tự đặc biệt"
			},
			ten : {
				required:"Vui lòng nhập tên",
				minlength:"Tên không hợp lệ",
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
	//Xem thông tin bàn
	$("#nhapthongtinban").validate({
		onchange :true,
		rules :{
			email :{
				required :{
		              depends : function() {
		                  $(this).val($.trim($(this).val()));
		                  return true;
		                }
		              },
		              remote : {
							type : "GET",
							url : "datban/kt-email.html",
							
		              },
				rangelength :[7,150],
				nowhitespace : true,
				email :true,
				
			},
			idhoadon :{
				required :{
		              depends : function() {
		                  $(this).val($.trim($(this).val()));
		                  return true;
		                }
		              },
		              remote : {
							type : "GET",
							url : "datban/kt-hoadon.html",
							data: {
								email: function(){
									var id = $("#email").val();
									if(id != null){
										return id;
									}else{
										return 0;
									}
								}
							}
		              }, 
				digits : true,
				maxlength :11
			}
		},
		messages:{
			email :{
				required :"Vui lòng nhập email của bạn",
				remote :"Xin lỗi không có hoá đơn nào có email như vậy",
				rangelength :"Email không hợp lệ",
				nowhitespace : "Email không được có khoảng trắng",
				email:"Email không hợp lệ",
				
			},
			idhoadon :{
				required :"Vui lòng nhập mã hoá đơn của bạn",
				remote :"Mã hoá đơn và email không tồn tại bạn vui lòng kiểm tra lại email",
				digits : "Mã hoá đơn phải là số và không có khoảng trắng",
				maxlength :"Mã hoá đơn không hợp lệ"
			}
		}
	});
	//Sửa hoá đơn
	$("#suadon").validate({
		
		onchange : true,
		rules : {
			ho : {
				
				minlength:2,
				maxlength:25,
				notNumber: true
			},
			ten : {
				
				minlength:2,
				maxlength:25,
				notNumber: true
			},
			email : {
				
				rangelength:[7,150],
				nowhitespace : true,
				email:true,
			},
			sdt : {
				
				rangelength:[9,11],
				digits : true,
				
			},
			ghichu :{
				maxlength: 200
			}

		},
		messages : {
			ho : {
				
				minlength:"Họ không hợp lệ",
				maxlength:"Họ quá dài vui lòng thử lại",
				notNumber: "Họ không được có số và ký tự đặc biệt"
			},
			ten : {
				
				minlength:"Tên không hợp lệ",
				maxlength:"Tên quá dài vui lòng thử lại",
				notNumber: "Tên không được có số và ký tự đặc biệt"
			},
			email : {
				
				rangelength:"Email không hợp lệ",
				nowhitespace : "Email không được có khoảng cách",
				email:"Email không hợp lệ",
			},
			sdt : {
				
				rangelength:"Số điện thoại không hợp lệ",
				digits : "Số điện thoại phải là số và không có khoảng trắng",
				
			},
			ghichu :{
				maxlength: "Ghi chú quá dài vui lòng thử lại"
			}
		}
	});
});