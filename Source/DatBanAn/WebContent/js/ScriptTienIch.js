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
	
	//Kiểm tra thêm đồ ăn
	$("#themtienich").validate({
		
		onchange : true,
		rules : {
			tentienich:{
				required: true,
				remote : {
					type : "GET",
					url : "nhahang/tienich/kt-trung-tentienich.html",
					data: {
						idtienich: function(){
							var id = $("#idtienich").val();
							if(id != null){
								return id;
							}else{
								return 0;
							}
						}
					}
				},
				rangelength:[2,100],
				checkCharactor:true
				
			},
			name:{
				required: true,
				remote : {
					type : "GET",
					url : "nhahang/tienich/kt-trung-name.html",
					data: {
						idtienich: function(){
							var id = $("#idtienich").val();
							if(id != null){
								return id;
							}else{
								return 0;
							}
						}
					}
				},
				rangelength:[2,100],
				checkDau:true,
				checkCharactor:true
			},
			hinh:{
				required: true,
				extension: "jpg|png|gif|jpeg",
				filesize: 1097152
			}

		},
		messages : {
			tentienich:{
				required: "Vui lòng nhập tên tiện ích",
				remote :"Tên tiện ích đã tồn tại",	
				rangelength:"Tên tiện ích phải từ 2 tới 100 ký tự",
				checkCharactor:"Tên tiện ích không được có ký tự đặc biệt"
			},
			name:{
				required: "Vui lòng nhập name tiện ích",
				remote : "Name tiện ích đã tồn tại",	
				rangelength:"Name tiện ích phải từ 2 tới 100 ký tự",
				checkDau:"Name phải là tiếng anh",
				checkCharactor:"Name ẩm thực không được có ký tự đặc biệt"
			},
			hinh:{
				required: "Vui lòng chọn icon cho tiện ích",
				extension: "Vui lòng chọn file định dạng ảnh như (jpg|png|gif|jpeg)",
				filesize: "Dung lượng file nhỏ hơn 2MB"
			}
		}
	});
	//Kiểm tra sửa tiện ích
$("#suatienich").validate({
		
		onchange : true,
		rules : {
			tentienich:{
				required: true,
				remote : {
					type : "GET",
					url : "nhahang/tienich/kt-trung-tentienich.html",
					data: {
						idtienich: function(){
							var id = $("#idtienich").val();
							if(id != null){
								return id;
							}else{
								return 0;
							}
						}
					}
				},
				rangelength:[2,100],
				checkCharactor:true
				
			},
			name:{
				required: true,
				remote : {
					type : "GET",
					url : "nhahang/tienich/kt-trung-name.html",
					data: {
						idtienich: function(){
							var id = $("#idtienich").val();
							if(id != null){
								return id;
							}else{
								return 0;
							}
						}
					}
				},
				rangelength:[2,100],
				checkDau:true
			},
			hinh:{
				
				extension: "jpg|png|gif|jpeg",
				filesize: 1097152
			}

		},
		messages : {
			tentienich:{
				required: "Vui lòng nhập tên tiện ích",
				remote :"Tên tiện ích đã tồn tại",	
				rangelength:"Tên tiện ích phải từ 2 tới 100 ký tự",
				checkCharactor:"Tên tiện ích không được có ký tự đặc biệt"
			},
			name:{
				required: "Vui lòng nhập name tiện ích",
				remote : "Name tiện ích đã tồn tại",	
				rangelength:"Name tiện ích phải từ 2 tới 100 ký tự",
				checkDau:"Name phải là tiếng anh"
			},
			hinh:{
				extension: "Vui lòng chọn file định dạng ảnh như (jpg|png|gif|jpeg)",
				filesize: "Dung lượng file nhỏ hơn 2MB"
			}
		}
	});
});