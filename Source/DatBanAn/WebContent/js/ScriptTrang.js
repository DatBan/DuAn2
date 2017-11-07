/**
 * 
 */
$(document).ready(function() {
	
	// Check số trong họ tên
	$.validator.addMethod("notNumber", function(value, element, param) {
        var reg = /[0-9.@!#$%&'*+\/=?^_`{|}~-]/;
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
	//Kiểm tra thêm và sửa trang
	$("#themtrangmoi").validate({
		
		onchange : true,
		rules : {
			tieude : {
				required : true,
				rangelength : [ 4, 50 ],
				notNumber: true,
				remote : {
					type : "GET",
					url : "trang/kt-trung-tieude.html",
					data: {
						idtrang: function(){
							var id = $("#idtrang").val();
							if(id != null){
								return id;
							}else{
								return 0;
							}
						}
					}

				}
			},
//			slug : {
//				required : true,
//				rangelength : [ 4, 80 ],
//				nowhitespace : true,
//				remote : {
//					type : "GET",
//					url : "trang/kt-trung-slug.html",
//					data: {
//						idtrang: function(){
//							var id = $("#idtrang").val();
//							if(id != null){
//								return id;
//							}else{
//								return 0;
//							}
//						}
//					}
//
//				}
//				
//
//			},
			title : {
				required : true,
				rangelength : [ 4, 50 ],
				notNumber : true,
				checkDau :true,
				remote : {
					type : "GET",
					url : "trang/kt-trung-title.html",
					data: {
						idtrang: function(){
							var id = $("#idtrang").val();
							if(id != null){
								return id;
							}else{
								return 0;
							}
						}
					}
				}
			},
			area1 : {
				required : true,
				minlength : 200
			},
			area2 : {
				required : true,
				minlength : 200
			}

		},
		messages : {
			tieude : {
				required : "Vui lòng nhập tiêu đề",
				rangelength : "Tiêu đề không hợp lệ",
				notNumber :"Tiêu đề không được có ký tự đặc biệt và số",
				remote : "Trang đã tồn tại"
			},
			
//			slug : {
//				required : "Vui lòng nhập Slug",
//				rangelength : "Slug không hợp lệ",
//				nowhitespace : "Slug không được có khoảng trống",
//				remote : "Slug đã tồn tại"
//				
//			},
			title : {
				required : "Vui lòng nhập tiêu đề bằng tiếng anh",
				rangelength : "Tiêu đề tiếng anh không hợp lệ",
				notNumber :"Tiêu đề tiếng anh không được có ký tự đặc biệt và số",
				checkDau: "Title phải là tiếng anh",
				remote : "Trang đã tồn tại"
			},
			area1 : {
				required : "Vui lòng nhập nội dung",
				minlength : "Nội dung quá ngắn"
			},
			area2 : {
				required : "Vui lòng nhập nội dung bằng tiếng anh",
				minlength : "Nội dung quá ngắn"
			}
		}
	});
});