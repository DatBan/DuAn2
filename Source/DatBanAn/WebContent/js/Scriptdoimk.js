
$("#doimk").validate({
	
			tendangnhap : {
				required : {
		              depends: function() {
		                  $(this).val($.trim($(this).val()));
		                  return true;
		                }
		              },
				rangelength : [ 5, 50 ],
				nowhitespace : true,
				remote :  {
					type : "GET",
					url : "kt-db-tendangnhap.html"

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
				
				remote :  {
					type : "GET",
					url : "kt-db-email.html"
				},
				maxlength : 150
		
		
			},
			tendangnhap : {
				required : "Vui lòng nhập tên đăng nhập",
				rangelength : "Tên đăng nhập chỉ từ 5 tới 50 ký tự",
				nowhitespace : "Tên đăng nhập không được có khoảng trống",
				alphanumeric : "Tên đăng nhập viết thường không dấu và không được có ký tự đặc biệt"
			},
			
			
			email : {
				required : "Vui lòng điền email",
				nowhitespace :"Email không được có khoảng cách",
				email : "Email không hợp lệ",
				maxlength : "Email không hợp lệ",
			},
	});