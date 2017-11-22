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
	
	//Kiểm tra thêm 
	$("#themkhuyenmai").validate({
		
		onchange : true,
		rules : {
			chude:{
				required: true,
				remote : {
					type : "GET",
					url : "nhahang/khuyenmai/kt-trung-chude.html",
					data: {
						idkhuyenmai: function(){
							var id = $("#idkhuyenmai").val();
							if(id != null){
								return id;
							}else{
								return 0;
							}
						}
					}
				},
				minlength:5,
				maxlength:100,
				checkCharactor:true
				
			},
			name:{
				required: true,
				remote : {
					type : "GET",
					url : "nhahang/khuyenmai/kt-trung-name.html",
					data: {
						idkhuyenmai: function(){
							var id = $("#idkhuyenmai").val();
							if(id != null){
								return id;
							}else{
								return 0;
							}
						}
					}
				},
				minlength:5,
				maxlength:100,
				checkDau:true,
				checkCharactor:true
			},
			thongtin:{
				required:true,
				minlength:10,
				maxlength:200
			}

		},
		messages : {
			chude:{
				required: "Vui lòng nhập chủ đề khuyến mãi",
				remote :"Tên chủ đề đã tồn tại",	
				minlength:"Chủ đề quá ngắn",
				maxlength:"Chủ đề không quá 100 ký tự",
				checkCharactor:"Chủ đề không được có ký tự đặc biệt"
			},
			name:{
				required: "Vui lòng nhập name chủ đề",
				remote : "Name chủ đề đã tồn tại",	
				minlength:"Name quá ngắn",
				maxlength:"Name không quá 100 ký tự",
				checkDau:"Name phải là tiếng anh",
				checkCharactor:"Name ẩm thực không được có ký tự đặc biệt"
					
			},
			thongtin:{
				required:"Vui lòng nhập thông tin khuyến mãi",
				minlength:"Thông tin quá ngắn",
				maxlength:"Thông tin không quá 200 ký tự"
			}
		}
	});
	
});