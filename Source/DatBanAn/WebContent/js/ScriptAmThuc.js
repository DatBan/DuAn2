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
	
	//Kiểm tra thêm ẩm thực
	$("#themamthuc").validate({
		
		onchange : true,
		rules : {
			tenloai:{
				required: true,
				remote : {
					type : "GET",
					url : "dashboard/amthuc/kt-trung-tenamthuc.html",
					data: {
						idamthuc: function(){
							var id = $("#idamthuc").val();
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
					url : "dashboard/amthuc/kt-trung-name.html",
					data: {
						idamthuc: function(){
							var id = $("#idamthuc").val();
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
			mota:{
				maxlength:200
			},
			description:{
				maxlength:200
			}

		},
		messages : {
			tenloai:{
				required: "Vui lòng nhập tên loại ẩm thực",
				remote :"Tên ẩm thực đã tồn tại",	
				rangelength:"Tên ẩm thực phải từ 2 tới 100 ký tự",
				checkCharactor:"Tên ẩm thực không được có ký tự đặc biệt"
			},
			name:{
				required: "Vui lòng nhập name ẩm thực",
				remote : "Name ẩm thực đã tồn tại",	
				rangelength:"Name ẩm thực phải từ 2 tới 100 ký tự",
				checkDau:"Name phải là tiếng anh",
				checkCharactor:"Name ẩm thực không được có ký tự đặc biệt"
					
			},
			mota:{
				maxlength:"Mô tả không quá 200 ký tự"
			},
			description:{
				maxlength:"Description không quá 200 ký tự"
			}
		}
	});
	
});