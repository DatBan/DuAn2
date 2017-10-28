/**
 * 
 */
//Đăng ký validate
$(document).ready(function(){
	$("#registerform").validate({
		onchange: true,
		rules:{
			hoten:{
				required:true,
				rangelength:[6,50]
			},
			tendangnhap:{
				required:true,
				minlength:4,
				maxlength:20,
				noSpace:true
			},
			matkhau:{
				required:true,
				minlength:6,
				maxlength:20				
			},
			nhaplaimatkhau:{
				required:true,
				equalTo:matkhau			
			},
			email:{
				required:true,
				email:email
			}
		
	},
		messages:{
			hoten:{
				requered:"Vui lòng nhập đầy đủ họ tên",
				rangelength:"Họ tên không hợp lệ"
			},
			tendangnhap:{
				required:"Vui lòng nhập tên đăng nhập",
				minlength:"Tên đăng nhập quá ngắn",
				maxlength:"Tên đăng nhập vượt quá giới hạn",
				noSpace:"Tên đăng nhập không được có khoảng trống"
			},
			matkhau:{
				required:"Vui lòng điền mật khẩu",
				minlength:"Mật khẩu quá ngắn",
				maxlength:"Mật khẩu vượt quá giới hạn"				
			},
			nhaplaimatkhau:{
				required:"Vui lòng nhập lại mật khẩu",
				equalTo:"Mật khẩu bạn nhập lại không đúng"			
			},
			email:{
				required:"Vui lòng điền email",
				email:"email không hợp lệ"
			}
		}
	});
})