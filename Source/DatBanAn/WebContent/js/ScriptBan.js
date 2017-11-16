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
	
	//Kiểm tra thêm 
	$("#themban").validate({
		
		onchange : true,
		rules : {
			soban:{
				required: true,
				remote : {
					type : "GET",
					url : "nhahang/ban/kt-trung-soban.html",
					data: {
						idban: function(){
							var id = $("#idban").val();
							if(id != null){
								return id;
							}else{
								return 0;
							}
						}
					}
				},
				digits : true,
				maxlength:3,
				checkCharactor:true
				
			},
			songuoi:{
				required: true,				
				digits : true,
				maxlength:3,
				checkCharactor:true
			}

		},
		messages : {
			soban:{
				required: "Vui lòng nhập số bàn",
				remote :"Số bàn đã tồn tại",
				digits : "Số bàn phải là số và không có khoảng trống",
				maxlength:"Số bàn quá lớn vui lòng xem lại",
				checkCharactor:"Số bàn không được có ký tự đặc biệt"
				
			},
			songuoi:{
				required: "Vui lòng nhập số người",				
				digits : "Số người phải là số và không có khoảng trống",
				maxlength:"Số người quá lớn vui lòng xem lại",
				checkCharactor:"Số người không được có ký tự đặc biệt"
			}
		}
	});
	
});