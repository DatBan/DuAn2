/**
 * 
 */
$(document).ready(function() {
	
	// Check ký tự đặc biệt
	$.validator.addMethod("checkCharactor", function(value, element, param) {
        var reg = /[.@!#$%&'*+\/=?^_`{|}~-]/;
        if(reg.test(value)){
              return false;
        }else{
                return true;
        }
	});
	// Check tiếng anh
	$.validator.addMethod("checkDau", function(value, element, param) {
        var reg = /[ÁÀẢÃẠÂẤẦẨẪẬĂẮẰẲẴẶÉÈẺẼẸÊẾỀỂỄỆÍÌỈĨỊÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢÚÙỦŨỤƯỨỪỬỮỰYÝỲỶỸỴĐáàảãạâấầẩẫậăắằẳẵặéèẻẽẹêếềểễệíìỉĩịóòỏõọôốồổỗộơớờởỡợúùủũụưứừửữựýỳỷỹỵđÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ]/;
        if(reg.test(value)){
              return false;
        }else{
                return true;
        }
	});
	// Check gia
	$.validator.addMethod("chuanGia", function(value, element) {
		var regex = new RegExp(/^0[0-9].*$/);
		var key = value;

		if (!regex.test(key)) {
			return true;
		} else {
			return false;
		}
	});
	//Kiểm tra thêm đồ ăn
	$("#themdoan").validate({
		
		onchange : true,
		rules : {
			tendoan:{
				required: true,
				remote : {
					type : "GET",
					url : "nhahang/monan/kt-trung-tendoan.html",
					data: {
						idmonan: function(){
							var id = $("#idmonan").val();
							if(id != null){
								return id;
							}else{
								return 0;
							}
						}
					}
				},
				rangelength:[2,50],
				checkCharactor:true
				
			},
			name:{
				required: true,
				remote : {
					type : "GET",
					url : "nhahang/monan/kt-trung-name.html",
					data: {
						idmonan: function(){
							var id = $("#idmonan").val();
							if(id != null){
								return id;
							}else{
								return 0;
							}
						}
					}
				},
				rangelength:[2,50],
				checkDau:true,
				checkCharactor:true
			},
			gia:{
				required: true,
				digits : true,
				maxlength: 100,
				chuanGia: true
			},
			hinh:{
				required: true,
				extension: "jpg|png|gif|jpeg",
				filesize: 2097152
			}

		},
		messages : {
			tendoan:{
				required: "Vui lòng nhập tên đồ ăn",
				remote :"Tên đồ ăn đã tồn tại",	
				rangelength:"Tên đồ ăn phải từ 2 tới 50 ký tự",
				checkCharactor:"Tên đồ ăn không được có ký tự đặc biệt"
			},
			name:{
				required: "Vui lòng nhập name đồ ăn",
				remote : "Name đồ ăn đã tồn tại",	
				rangelength:"Name đồ ăn phải từ 2 tới 50 ký tự",
				checkDau:"Name đồ ăn phải là tiếng anh",
				checkCharactor:"Name ẩm thực không được có ký tự đặc biệt"
			},
			gia:{
				required: "Vui lòng nhập giá",
				digits : "Giá phải là số và không có khoảng cách",
				maxlength: "Giá không hợp lệ",
				chuanGia :"Giá không thể bắt đầu từ số 0"
			},
			hinh:{
				required: "Vui lòng chọn hình cho món ăn",
				extension: "Vui lòng chọn file định dạng ảnh như (jpg|png|gif|jpeg)",
				filesize: "Dung lượng file nhỏ hơn 2MB"
			}
		}
	});
	//Kiểm tra sửa đồ ăn
	$("#suadoan").validate({
		
		onchange : true,
		rules : {
			tendoan:{
				required: true,
				remote : {
					type : "GET",
					url : "nhahang/monan/kt-trung-tendoan.html",
					data: {
						idmonan: function(){
							var id = $("#idmonan").val();
							if(id != null){
								return id;
							}else{
								return 0;
							}
						}
					}
				},
				rangelength:[2,50],
				checkCharactor:true
				
			},
			name:{
				required: true,
				remote : {
					type : "GET",
					url : "nhahang/monan/kt-trung-name.html",
					data: {
						idmonan: function(){
							var id = $("#idmonan").val();
							if(id != null){
								return id;
							}else{
								return 0;
							}
						}
					}
				},
				rangelength:[2,50],
				checkDau:true
			},
			gia:{
				required: true,
				digits : true,
				maxlength: 100,
				chuanGia: true
			},
			hinh:{
				extension: "jpg|png|gif|jpeg",
				filesize: 2097152
			}

		},
		messages : {
			tendoan:{
				required: "Vui lòng nhập tên đồ ăn",
				remote :"Tên đồ ăn đã tồn tại",	
				rangelength:"Tên đồ ăn phải từ 2 tới 50 ký tự",
				checkCharactor:"Tên đồ ăn không được có ký tự đặc biệt"
			},
			name:{
				required: "Vui lòng nhập name đồ ăn",
				remote : "Name đồ ăn đã tồn tại",	
				rangelength:"Name đồ ăn phải từ 2 tới 50 ký tự",
				checkDau:"Name đồ ăn phải là tiếng anh"
			},
			gia:{
				required: "Vui lòng nhập giá",
				digits : "Giá phải là số và không có khoảng cách",
				maxlength: "Giá không hợp lệ",
				chuanGia :"Giá không thể bắt đầu từ số 0"
			},
			hinh:{
				extension: "Vui lòng chọn file định dạng ảnh như (jpg|png|gif|jpeg)",
				filesize: "Dung lượng file nhỏ hơn 2MB"
			}
		}
	});
});