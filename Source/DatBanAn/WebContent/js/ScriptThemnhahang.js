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
	$("#themnhahang").validate({

		tennhahang : {
			required : {
				depends : function() {
					$(this).val($.trim($(this).val()));
					return true;
				}
			},
			rangelength : [ 5, 50 ],

			remote : {

			},

		},
		name : {
			required : {
				depends : function() {
					$(this).val($.trim($(this).val()));
					return true;
				}
			},
			rangelength : [ 5, 50 ],

			remote : {

			},

		},
		diachi : {
			required : {
				depends : function() {
					$(this).val($.trim($(this).val()));
					return true;
				}
			},
			rangelength : [ 5, 50 ],

			remote : {

			},

		},
		address : {
			required : {
				depends : function() {
					$(this).val($.trim($(this).val()));
					return true;
				}
			},
			rangelength : [ 5, 50 ],

			remote : {

			},

		},
		tinhthanh : {
			required : {
				depends : function() {
					$(this).val($.trim($(this).val()));
					return true;
				}
			},
			rangelength : [ 5, 50 ],

			remote : {

			},

		},
		city : {
			required : {
				depends : function() {
					$(this).val($.trim($(this).val()));
					return true;
				}
			},
			rangelength : [ 5, 50 ],

			remote : {

			},

		},

		tinhthanh : {
			required : {
				depends : function() {
					$(this).val($.trim($(this).val()));
					return true;
				}
			},
			rangelength : [ 5, 50 ],

			remote : {

			},

		},
		tinhthanh : {
			required : {
				depends : function() {
					$(this).val($.trim($(this).val()));
					return true;
				}
			},
			rangelength : [ 5, 50 ],

			remote : {

			},

		},
		tinhthanh : {
			required : {
				depends : function() {
					$(this).val($.trim($(this).val()));
					return true;
				}
			},
			rangelength : [ 5, 50 ],

			remote : {

			},

		},
		quanhuyen : {
			required : {
				depends : function() {
					$(this).val($.trim($(this).val()));
					return true;
				}
			},
			rangelength : [ 5, 50 ],

			remote : {

			},

		},
		district : {
			required : {
				depends : function() {
					$(this).val($.trim($(this).val()));
					return true;
				}
			},
			rangelength : [ 5, 50 ],

			remote : {

			},

		},
		phuongxa : {
			required : {
				depends : function() {
					$(this).val($.trim($(this).val()));
					return true;
				}
			},
			rangelength : [ 5, 50 ],

			remote : {

			},

		},
		ward : {
			required : {
				depends : function() {
					$(this).val($.trim($(this).val()));
					return true;
				}
			},
			rangelength : [ 5, 50 ],

			remote : {

			},

		},
		sdt : {
			required : {
				depends : function() {
					$(this).val($.trim($(this).val()));
					return true;
				}
			},
			digits : true,
			rangelength : [ 9, 11 ],
			chuanSDT : true

		},
		thumbnail : {
			required : {
				depends : function() {
					$(this).val($.trim($(this).val()));
					return true;
				}
			},
			rangelength : [ 5, 50 ],

			remote : {

			},

		},
		gioithieu : {
			required : {
				depends : function() {
					$(this).val($.trim($(this).val()));
					return true;
				}
			},
			rangelength : [ 5, 200 ],

			remote : {

			},

		},
		aboutus : {
			required : {
				depends : function() {
					$(this).val($.trim($(this).val()));
					return true;
				}
			},
			rangelength : [ 5, 200 ],

			remote : {

			},

		},
		messages : {
			tennhahang : {
				required : "Vui lòng nhập tên nhà hàng",
				rangelength : "Tên nhà hàng phai từ 5-50 ký tự",
			},
			name : {
				required : "Vui lòng nhập tên nhà hàng",
				rangelength : "Tên nhà hàng phai từ 5-50 ký tự",
			},
			diachi : {
				required : "Vui lòng nhập địa chỉ",
				rangelength : "Địa chỉ phai từ 5-50 ký tự",
			},
			address : {
				required : "Vui lòng nhập địa chỉ",
				rangelength : "Địa chỉ phai từ 5-50 ký tự",
			},
			tinhthanh : {
				required : "Vui lòng nhập tên tỉnh thành",
				rangelength : "Tên tỉnh thành phai từ 5-50 ký tự",
			},
			city : {
				required : "Vui lòng nhập tên tỉnh thành",
				rangelength : "Tên tỉnh thành phai từ 5-50 ký tự",
			},
			quanhuyen : {
				required : "Vui lòng nhập tên quận huyện",
				rangelength : "Tên quận huyện phai từ 5-50 ký tự",
			},
			district : {
				required : "Vui lòng nhập tên quận huyện",
				rangelength : "Tên quận huyện phai từ 5-50 ký tự",
			},
			phuongxa : {
				required : "Vui lòng nhập tên phường xã",
				rangelength : "Tên phường xã phai từ 5-50 ký tự",
			},
			ward : {
				required : "Vui lòng nhập tên khu vực",
				rangelength : "Tên khu vực phai từ 5-50 ký tự",
			},
			sdt : {
				required : "Vui lòng điền số điện thoại",
				digits : "Số điện thoại phải là số và không có khoảng trắng",
				rangelength : "Số điện thoại không hợp lệ",
				chuanSDT : "Số điện thoại phải bắt đầu từ số 0"
			},
			district : {
				required : "Vui lòng nhập tên district",
				rangelength : "Tên district chỉ từ 5 tới 50 ký tự",

			},
			thumbnail : {
				required : "Vui lòng chọn ảnh cho nhà hàng",

			},
			gioithieu : {
				required : "Vui lòng nhập vào ô này",
				rangelength : "Giới thiệu chỉ từ 5 tới 200 ký tự",

			},
			aboutus : {
				required : "Vui lòng nhập vào ô này",
				rangelength : "Aboutus chỉ từ 5 tới 200 ký tự",
			},

			mota : {
				required : "Vui lòng nhập vào ô này",
				rangelength : "Mô tả chỉ từ 5 tới 200 ký tự",
			}
		}

	});
});