$(document).ready(function() {
	$("#quenmk").validate({
		onchange : true,
			rules : {
					tendangnhap1 : {
						required : {
				              depends: function() {
				                  $(this).val($.trim($(this).val()));
				                  return true;
				                }
				              },
						rangelength : [ 2, 50 ],
						nowhitespace : true,
						remote :  {
							type : "GET",
							url : "user/mailer/kt-tendangnhap.html"
		
						},
						alphanumeric : true
		
					},
					email : {
						required : {
				              depends: function() {
				                  $(this).val($.trim($(this).val()));
				                  return true;
				                }
				              },
						nowhitespace : true,
						email:true,
						
						remote : {
							type : "GET",
							url : "user/mailer/kt-email.html",
							data: {
								tendangnhap1: function(){
									var id = $("#tendangnhap1").val();
									if(id != null){
										return id;
									}else{
										return null;
									}
								}
							}
						},
						maxlength : 50
				
				
					}
				},
				messages : {
				tendangnhap : {
						required : "Vui lòng nhập tên đăng nhập",
						rangelength : "Tên đăng nhập chỉ từ {0} tới {1} ký tự",
						nowhitespace : "Tên đăng nhập không được có khoảng trống",
						remote : "Tên đăng nhập này không tồn tại",
						
					},
					email : {
						required : "Vui lòng điền email",
						nowhitespace :"Email không được có khoảng cách",
						email : "Email không hợp lệ",
						remote : "Email không đúng với tên đăng nhập",
						maxlength : "Email không hợp lệ",
					},
				}
		});
});