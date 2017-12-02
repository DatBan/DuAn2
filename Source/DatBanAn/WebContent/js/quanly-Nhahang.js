$(document).ready(function(){
	//Check validate form themnhahang
	$("#themnhahang").validate({
		onchange: true,
		rules: {
			tennhahang: {
				required: true,
				maxlength: 150
			},
			'loaiamthuc.id': "required",
			diachi: {
				required: true,
				maxlength: 100
			},
			'tinhthanh.id': "required",
			'quanhuyen.id': "required",
			'phuongxa.id': "required",
			sdt: {
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
			giodongcua:{
				greaterThan: "#qcTimepicker-0"
			},
			thumbnail: {
				required: true,
				extension: "jpg|png|gif|jpeg",
				filesize: 2097152
			},
			gioithieu: {
				required: true
			}
		},
		messages: {
			tennhahang: {
				required: "Vui lòng nhập tên nhà hàng",
				maxlength: "Độ dài tối đa là {0} ký tự"
			},
			'loaiamthuc.id': "Vui lòng chọn loại ẩm thực",
			diachi: {
				required: "Vui lòng nhập địa chỉ",
				maxlength: "Độ dài tối đa là {0} ký tự"
			},
			'tinhthanh.id': "Vui lòng chọn tỉnh/thành",
			'quanhuyen.id': "Vui lòng chọn quận/huyện",
			'phuongxa.id': "Vui lòng chọn phường xã",
			sdt: {
				required : "Vui lòng nhập số điện thoại",
				digits : "Số điện thoại phải là số và không có khoảng trắng",
				rangelength : "Số điện thoại không hợp lệ",
				chuanSDT : "Số điện thoại phải bắt đầu từ số 0"
			},
			giodongcua:{
				greaterThan: "Giờ đóng của phải lớn hơn giờ mở cửa"
			},
			thumbnail: {
				required: "Vui lòng chọn hình đại diện cho nhà hàng",
				extension: "Vui lòng chọn file định dạng ảnh như (jpg|png|gif|jpeg)",
				filesize: "Dung lượng file nhỏ hơn 2MB"
			}/*,
			gioithieu: {
				required: true
			}*/
		}
	});
	
	//Check validate form themnhahang
	$("#editnhahang").validate({
		onchange: true,
		rules: {
			tennhahang: {
				required: true,
				maxlength: 150
			},
			'loaiamthuc.id': "required",
			diachi: {
				required: true,
				maxlength: 100
			},
			'tinhthanh.provinceid': "required",
			'quanhuyen.districtid': "required",
			'phuongxa.wardid': "required",
			sdt: {
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
			giodongcua:{
				greaterThan: "#qcTimepicker-0"
			},
			thumbnail: {
				extension: "jpg|png|gif|jpeg",
				filesize: 2097152
			},
			gioithieu: {
				required: true
			}
		},
		messages: {
			tennhahang: {
				required: "Vui lòng nhập tên nhà hàng",
				maxlength: "Độ dài tối đa là {0} ký tự"
			},
			'loaiamthuc.id': "Vui lòng chọn loại ẩm thực",
			diachi: {
				required: "Vui lòng nhập địa chỉ",
				maxlength: "Độ dài tối đa là {0} ký tự"
			},
			'tinhthanh.provinceid': "Vui lòng chọn tỉnh/thành",
			'quanhuyen.districtid': "Vui lòng chọn quận/huyện",
			'phuongxa.wardid': "Vui lòng chọn phường xã",
			sdt: {
				required : "Vui lòng nhập số điện thoại",
				digits : "Số điện thoại phải là số và không có khoảng trắng",
				rangelength : "Số điện thoại không hợp lệ",
				chuanSDT : "Số điện thoại phải bắt đầu từ số 0"
			},
			giodongcua:{
				greaterThan: "Giờ đóng của phải lớn hơn giờ mở cửa"
			},
			thumbnail: {
				extension: "Vui lòng chọn file định dạng ảnh như (jpg|png|gif|jpeg)",
				filesize: "Dung lượng file nhỏ hơn 2MB"
			}/*,
			gioithieu: {
				required: true
			}*/
		}
	});
});